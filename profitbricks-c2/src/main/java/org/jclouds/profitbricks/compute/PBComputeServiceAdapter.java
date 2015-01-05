/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.profitbricks.compute;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.jclouds.compute.ComputeServiceAdapter;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.HardwareBuilder;
import org.jclouds.compute.domain.Processor;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.Volume;
import org.jclouds.compute.domain.internal.VolumeImpl;
import org.jclouds.compute.reference.ComputeServiceConstants;
import org.jclouds.domain.LoginCredentials;
import org.jclouds.logging.Logger;
import org.jclouds.profitbricks.ProfitBricksApi;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.datacenter.DataCenter;
import org.jclouds.profitbricks.domain.datacenter.DataCenterIdentifier;
import org.jclouds.profitbricks.domain.image.Image;
import org.jclouds.profitbricks.domain.image.ImageType;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequest;
import org.jclouds.profitbricks.domain.storage.Storage;
import org.jclouds.profitbricks.domain.storage.create.CreateStorageRequest;
import org.jclouds.profitbricks.features.DataCenterApi;
import org.jclouds.profitbricks.features.ServerApi;
import org.jclouds.profitbricks.features.StorageApi;
import org.jclouds.util.Predicates2;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Designates connection between {@link org.jclouds.compute.ComputeService} API and
 * {@link org.jclouds.profitbricks.ProfitBricksApi} API.
 */
@Singleton
public class PBComputeServiceAdapter implements ComputeServiceAdapter<Server, Hardware, Image, DataCenter> {

   @Resource
   @Named(ComputeServiceConstants.COMPUTE_LOGGER)
   protected Logger logger = Logger.NULL;

   protected ProfitBricksApi pbApi;
   protected Function<Template, CreateServerRequest> templateToServer;

   private final Predicate<String> vdcWaitingPredicate;
   private final LoginCredentials defaultCredentials = LoginCredentials.builder()
           .identity("root")
           .credential("apachejcrauds")
           .build();

   @Inject
   PBComputeServiceAdapter(ProfitBricksApi pbApi, Function<Template, CreateServerRequest> templateToServer) {
      this.pbApi = pbApi;
      this.templateToServer = templateToServer;
      this.vdcWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              pbApi, ProvisioningStatusAware.DATACENTER), 10l * 60l, 2l, TimeUnit.SECONDS);
   }

   @Override
   public NodeAndInitialCredentials<Server> createNodeWithGroupEncodedIntoName(String group, String name, Template template) {
      final String locationId = template.getLocation().getId();
      final Map<String, String> meta = template.getOptions().getUserMetadata();
      final StorageApi storageApi = pbApi.getStorageApi();

      vdcWaitingPredicate.apply(locationId);
      // Create actual server
      CreateServerRequest serverToCreate = templateToServer.apply(template);

      final ServerApi serversApi = pbApi.getServersApi();
      logger.trace(">> creating new server from template [%s]", serverToCreate);
      String createdServerId = serversApi.createServer(serverToCreate).getReturn().getServerId();
      checkNotNull(createdServerId);
      logger.trace("<< server created with id=%s", createdServerId);
      vdcWaitingPredicate.apply(locationId);

      // Because of JCLOUDS-482 (arbitrary for virtual "storage" as well), below retrieves storages to provision via metadata
      final List<String> storageIds = Lists.newArrayList();
      for (int i = 0; i < 8; i++) {
         checkDataCenterState(locationId);
         String key = format("storage[%d]", i);
         if (!meta.containsKey(format("%s.size", key)))
            break;
         final Long totalSize = Long.valueOf(meta.get(format("%s.size", key)));
         logger.trace(">> creating storage with size '%s GB'.", totalSize);

         final String storageName = meta.containsKey(format("%s.name", key)) ? meta.get(format("%s.name", key)) : "New Storage";
         final CreateStorageRequest storage;
         if (meta.containsKey(format("%s.boot", key)))
            storage = Storage.creatingBuilder()
                    .storageName(storageName)
                    .dataCenterId(locationId)
                    .mountImageId(template.getImage().getId())
                    .imagePassword(defaultCredentials.credential)
                    .size(totalSize)
                    .build();
         else
            storage = Storage.creatingBuilder()
                    .storageName(storageName)
                    .dataCenterId(locationId)
                    .size(totalSize)
                    .build();
         // Store id reference later for server-storage connection
         String storageId = storageApi.createStorage(storage).getReturn().getStorageId();
         logger.trace(">> created storage with id=%s", storageId);
         storageIds.add(storageId);
         vdcWaitingPredicate.apply(locationId);
      }

      // Connect previously created storages to newly created server
      for (String storageId : storageIds) {
         checkDataCenterState(locationId);
         logger.trace("<< connecting storage '%s' to server '%s'", storageId, createdServerId);
         storageApi.connectStorageToServer(
                 Storage.connectingBuilder()
                 .serverId(createdServerId)
                 .storageId(storageId)
                 .build());
         logger.trace(">> storage connected.");
         vdcWaitingPredicate.apply(locationId);
      }

      logger.trace(">> getting server with id=%s", createdServerId);
      Server createdServer = pbApi.getServersApi().getServer(createdServerId).getReturn();
      logger.trace("<< got server [%s]", createdServer);

      return new NodeAndInitialCredentials<Server>(
              createdServer,
              createdServerId,
              defaultCredentials
      );
   }

   private void checkDataCenterState(String locationId) {
      checkState(pbApi.getDataCenterApi().getDataCenterState(locationId).getReturn() == ProvisioningState.AVAILABLE,
              "Data center not ready.");
   }

   @Override
   public Iterable<Image> listImages() {
      logger.trace(">> retrieving images..");
      List<Image> allImages = pbApi.getImageApi().getAllImages().getReturn();
      // Filter HDD types only, since JClouds doesn't have a concept of "CD-ROM" anyway
      Iterable<Image> filteredImages = Iterables.filter(allImages, new Predicate<Image>() {

         @Override
         public boolean apply(Image t) {
            return t.getImageType() == ImageType.HDD;
         }
      });
      logger.trace("<< images retrieved.");
      return filteredImages;
   }

   @Override
   public Image getImage(String id) {
      logger.trace(">> searching for image with id=%s", id);
      Image image = pbApi.getImageApi().getImage(id).getReturn();
      logger.trace("<< found image [%s].", image.getImageName());
      return image;
   }

   /**
    * Actual supported hardware profiles:
    * <pre>
    * for (int core = 1; core <= 48; core++) {
    *    for (int ram = 256; ram <= 200704; ram+= 256) {
    *       // up to 8 connected storage each
    *    }
    * }
    * </pre> @see
    * <a href="http://www.profitbricks.com/apidoc/APIDocumentation.html?ResourceLimits.html">Resource Limits</a>
    */
   @Override
   public Iterable<Hardware> listHardwareProfiles() {
      Builder<Hardware> hardware = ImmutableSet.builder();
      final float maxSize = 2048; // GiB
      for (int core = 1; core <= 48; core++) {
         for (int ram : new int[]{256, 512, 1024, 2 * 1024, 4 * 1024, 8 * 1024, 16 * 1024, 32 * 1024}) {
            String id = String.format("cpu=%d,ram=%s,disk=%f", core, ram, maxSize);
            hardware.add(new HardwareBuilder()
                    .supportsImage(Predicates.<org.jclouds.compute.domain.Image>alwaysTrue())
                    .ids(id)
                    .ram(ram)
                    .processors(ImmutableList.of(new Processor(core, 1d)))
                    .hypervisor("kvm")
                    .volumes(ImmutableList.<Volume>of(new VolumeImpl(maxSize, true, true)))
                    .build());
         }
      }
      return hardware.build();
   }

   @Override
   public Iterable<DataCenter> listLocations() {
      logger.trace(">> retrieving virtual datacenters..");
      // ISO codes are now available in v1.3 (http://blog.profitbricks.com/new-profitbricks-cloud-computing-api-1-3-update/)
      // but needs to be retrieved individually using GetDataCenter. (de/fkb, de/fra, us/las)
      // Obvious bottlneck, but the iso code is required for correct image choosing predicate
      DataCenterApi dcApi = pbApi.getDataCenterApi();
      List<DataCenterIdentifier> identifiers = dcApi.getAllDataCenters().getReturn();
      List<DataCenter> dataCenters = Lists.newArrayListWithExpectedSize(identifiers.size());
      for (DataCenterIdentifier vdc : identifiers) {
         dataCenters.add(dcApi.getDataCenter(vdc.getDataCenterId()).getReturn());
      }

      logger.trace(">> virtual datacenters retrieved.");
      return dataCenters;
   }

   @Override
   public Iterable<Server> listNodes() {
      logger.trace(">> retrieving all servers..");
      List<Server> servers = pbApi.getServersApi().getAllServers().getReturn();
      logger.trace(">> servers retrieved.");
      return servers;
   }

   @Override
   public Server getNode(String id) {
      checkNotNull(id, "id");
      logger.trace(">> searching for server with id=%s", id);
      Server server = pbApi.getServersApi().getServer(id).getReturn();
      logger.trace(">> found server [%s]", server.getServerName());
      return server;
   }

   @Override
   public Iterable<Server> listNodesByIds(Iterable<String> nodeIds) {
      checkNotNull(nodeIds);
      List<Server> servers = new ArrayList<Server>();
      for (String id : nodeIds) {
         servers.add(getNode(id));
      }
      return servers;
   }

   @Override
   public void destroyNode(String id) {
      pbApi.getServersApi().deleteServer(id);
   }

   @Override
   public void rebootNode(String id) {
      pbApi.getServersApi().resetServer(id);
   }

   @Override
   public void resumeNode(String id) {
      pbApi.getServersApi().startServer(id);
   }

   @Override
   public void suspendNode(String id) {
      pbApi.getServersApi().stopServer(id);
   }

}
