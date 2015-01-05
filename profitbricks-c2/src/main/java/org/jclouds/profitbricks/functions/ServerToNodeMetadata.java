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
package org.jclouds.profitbricks.functions;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.find;
import static java.lang.String.format;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapOS;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapStatus;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.jclouds.collect.Memoized;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.HardwareBuilder;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.NodeMetadataBuilder;
import org.jclouds.compute.domain.Processor;
import org.jclouds.compute.domain.Volume;
import org.jclouds.domain.Location;
import org.jclouds.profitbricks.domain.firewall.Firewall;
import org.jclouds.profitbricks.domain.firewall.FirewallRule;
import org.jclouds.profitbricks.domain.nic.Nic;
import org.jclouds.profitbricks.domain.romdrive.RomDrive;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.storage.connect.ConnectedStorage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A function for transforming a ProfitBricks {@link Server} into a generic NodeMetadata object.
 */
public class ServerToNodeMetadata implements Function<Server, NodeMetadata> {

   private final ConnectedStorageToVolume storageToVolume;
   private final Supplier<Set<? extends Location>> locationsSupply;

   @Inject
   public ServerToNodeMetadata(ConnectedStorageToVolume storageToVolume,
           @Memoized Supplier<Set<? extends Location>> locationsSupply) {
      this.storageToVolume = storageToVolume;
      this.locationsSupply = locationsSupply;
   }

   @Override
   public NodeMetadata apply(final Server server) {
      checkNotNull(server, "server");

      Set<? extends Location> locations = this.locationsSupply.get();
      Location region = find(locations, new Predicate<Location>() {

         @Override
         public boolean apply(Location input) {
            return input.getId().equals(server.getDataCenterId());
         }

         @Override
         public String toString() {
            return "locationId(" + server.getDataCenterId() + ")";
         }

      });

      Location serverZone = server.getAvailabilityZone().toLocation(region);

      List<ConnectedStorage> connectedStorages = server.getConnectedStorages();
      List<Volume> volumes = Lists.newArrayListWithExpectedSize(connectedStorages.size());
      for (ConnectedStorage storage : connectedStorages) {
         volumes.add(storageToVolume.apply(storage));
      }

      Hardware hardware = new HardwareBuilder()
              .id(server.getServerId())
              .processor(new Processor(server.getCores(), 0))
              .ram(server.getRam())
              .location(serverZone)
              .volumes(volumes)
              .build();

      NodeMetadata nodeMetadata = new NodeMetadataBuilder()
              .ids(server.getServerId())
              .name(server.getServerName())
              .hostname(server.getServerName())
              .status(mapStatus(server.getVirtualMachineState()))
              .operatingSystem(mapOS(server.getOsType()))
              .hardware(hardware)
              .backendStatus(server.getProvisioningState().value())
              .publicAddresses(server.getIps())
              .location(region)
//              .userMetadata(buildMetadata(server))
              .build();

      return nodeMetadata;
   }

   /**
    * Method to map server extra properties from PB API as metadata
    */
   private Map<String, String> buildMetadata(final Server server) {
      final LinkedHashMap<String, String> meta = Maps.newLinkedHashMap();
      final Iterator<Nic> nicIt = server.getNics().iterator();
      int i = 1;
      while (nicIt.hasNext()) {
         Nic nic = nicIt.next();
         addMeta(meta, format("nic[%d].id", i), nic.getNicId());
         addMeta(meta, format("nic[%d].name", i), nic.getNicName());
         addMeta(meta, format("nic[%d].gatewayIp", i), nic.getGatewayIp());
         addMeta(meta, format("nic[%d].lanId", i), nic.getLanId() + "");
         addMeta(meta, format("nic[%d].provisioningState", i), nic.getProvisioningState().value());

         Firewall firewall = nic.getFirewall();
         if (firewall != null) {
            int j = 1;
            addMeta(meta, format("nic[%d].firewall.id", i), firewall.getFirewallId());
            addMeta(meta, format("nic[%d].firewall.provisioningState", i), firewall.getProvisioningState().value());
            addMeta(meta, format("nic[%d].firewall.isActive", i), firewall.isActive() + "");
            Iterator<FirewallRule> ruleIt = firewall.getFirewallRules().iterator();
            while (ruleIt.hasNext()) {
               FirewallRule rule = ruleIt.next();
               addMeta(meta, format("nic[%d].firewall.rules[%d].id", i, j), rule.getFirewallRuleId());
               addMeta(meta, format("nic[%d].firewall.rules[%d].name", i, j), rule.getName());
               addMeta(meta, format("nic[%d].firewall.rules[%d].sourceIp", i, j), rule.getSourceIp());
               addMeta(meta, format("nic[%d].firewall.rules[%d].targetIp", i, j), rule.getTargetIp());
               addMeta(meta, format("nic[%d].firewall.rules[%d].sourceMac", i, j), rule.getSourceMac());
               addMeta(meta, format("nic[%d].firewall.rules[%d].portRangeStart", i, j), rule.getPortRangeStart() + "");
               addMeta(meta, format("nic[%d].firewall.rules[%d].portRangeEnd", i, j), rule.getPortRangeEnd() + "");
               addMeta(meta, format("nic[%d].firewall.rules[%d].protocol", i, j), rule.getProtocol().value());
               addMeta(meta, format("nic[%d].firewall.rules[%d].icmpType", i, j), rule.getIcmpType().toString());
               addMeta(meta, format("nic[%d].firewall.rules[%d].icmpCode", i, j), rule.getIcmpCode().toString());
               j++;
            }
         }
         i++;
      }
      final Iterator<RomDrive> romIt = server.getRomDrives().iterator();
      i = 1;
      while (romIt.hasNext()) {
         RomDrive rom = romIt.next();
         addMeta(meta, format("rom-%d:imageId", i), rom.getImageId());
         addMeta(meta, format("rom-%d:imageName", i), rom.getImageName());
         addMeta(meta, format("rom-%d:isBootDevice", i), rom.isBootDevice() + "");
         i++;
      }
      return meta;
   }

   private String addMeta(Map<String, String> meta, String key, String value) {
      return meta.put(key, value == null ? "" : value);
   }
}
