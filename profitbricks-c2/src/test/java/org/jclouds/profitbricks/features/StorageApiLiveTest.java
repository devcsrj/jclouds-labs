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
package org.jclouds.profitbricks.features;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.storage.Storage;
import org.jclouds.profitbricks.domain.storage.connect.ConnectedStorage;
import org.jclouds.profitbricks.domain.storage.create.CreateStorageRequest;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.rest.InsufficientResourcesException;
import org.jclouds.rest.ResourceNotFoundException;
import org.jclouds.util.Predicates2;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

/**
 *
 * Test for the {@link StorageApi} class
 */
@Test(groups = "live", testName = "StorageApiLiveTest")
public class StorageApiLiveTest extends BaseProfitBricksLiveTest {

   Predicate<String> storageWaitingPredicate;
   String storageId;

   @Override
   protected void initialize() {
      super.initialize();
      initializeVDC();
      this.storageWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.STORAGE), 6l * 60l, 2l, TimeUnit.SECONDS);
   }

   @Test(expectedExceptions = InsufficientResourcesException.class)
   public void testUberStorage() {
      api.getStorageApi().createStorage(
              Storage.creatingBuilder()
              .dataCenterId(vdc.getDataCenterId())
              .storageName("Uber Storage")
              .size(9999999l)
              .build()
      );

   }

   @Test(alwaysRun = true, dependsOnMethods = "testUberStorage")
   public void testCreateStorage() {
      assertNotNull(vdc);
      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      CreateStorageRequest storage = Storage.creatingBuilder()
              .dataCenterId(vdc.getDataCenterId())
              .storageName("Random Storage")
              .size(Long.valueOf(2))
              .build();

      storageId = api.getStorageApi().createStorage(storage).getReturn().getStorageId();

      assertNotNull(storageId);
   }

   @Test(expectedExceptions = ResourceNotFoundException.class)
   public void testGetNonExistingStorage() {
      api.getStorageApi().getStorage("some-random-non-existing-storage");
   }

   @Test(dependsOnMethods = "testCreateStorage")
   public void testGetStorage() {
      Storage storage = api.getStorageApi().getStorage(storageId).getReturn();

      assertNotNull(storage);
      assertEquals(storage.getSize(), Long.valueOf(2), "2 GB was created earlier. Expecting 2 GB when retrieved as well.");
   }

   @Test(alwaysRun = true, dependsOnMethods = "testGetStorage")
   public void testGetAllStorages() {
      storageWaitingPredicate.apply(storageId);
      List<Storage> storages = api.getStorageApi().getAllStorages().getReturn();

      assertFalse(storages.isEmpty(), "Storages list should not be empty.");
   }

   @Test(dependsOnMethods = "testGetAllStorages")
   public void testStorageConnection() {
      storageWaitingPredicate.apply(storageId);
      List<Server> servers = api.getServersApi().getAllServers().getReturn();
      if (!servers.isEmpty()) {
         Server server = servers.get(0);
         VersionResponse response = api.getStorageApi().connectStorageToServer(
                 Storage.connectingBuilder()
                 .serverId(server.getServerId())
                 .storageId(storageId)
                 .build()).getReturn();
         assertNotNull(response, "No response after storage connection.");

         vdcWaitingPredicate.apply(server.getDataCenterId());
         server = api.getServersApi().getServer(server.getServerId()).getReturn();
         assertTrue(server.getConnectedStorages().contains(new ConnectedStorage(storageId)),
                 "Server '" + server.getServerId() + "' did not contain storage '" + storageId + "'");

         response = api.getStorageApi().disconnectStorageFromServer(storageId, server.getServerId()).getReturn();
         assertNotNull(response, "No response after storage disconnection.");

         vdcWaitingPredicate.apply(server.getDataCenterId());
         server = api.getServersApi().getServer(server.getServerId()).getReturn();
         assertFalse(server.getConnectedStorages().contains(new ConnectedStorage(storageId)),
                 "Server '" + server.getServerId() + "' did not contain storage '" + storageId + "'");
      } else
         fail("No available server for storage connect/disconnect test");
   }

   @Test(alwaysRun = true, dependsOnMethods = "testStorageConnection")
   public void testDeleteStorage() {
      storageWaitingPredicate.apply(storageId);
      Storage storage = api.getStorageApi().getStorage(storageId).getReturn();
      assertTrue(storage.getProvisioningState() == ProvisioningState.AVAILABLE,
              "Storage was not available before 'Delete' test.");

      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      VersionResponse response = api.getStorageApi().deleteStorage(storageId).getReturn();
      assertNotNull(response);
   }

}
