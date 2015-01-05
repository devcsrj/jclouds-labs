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
import org.jclouds.profitbricks.domain.snapshot.Snapshot;
import org.jclouds.profitbricks.domain.storage.Storage;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.rest.ResourceNotFoundException;
import org.jclouds.util.Predicates2;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 * Test for the {@link SnapshotApi} class
 */
@Test(groups = "live", testName = "SnapshotApiLiveTest")
public class SnapshotApiLiveTest extends BaseProfitBricksLiveTest {

   Predicate<String> snapshotWaitingPredicate;
   String snapshotId;
   Storage storage;

   @Override
   protected void initialize() {
      super.initialize();
      initializeVDC();
      List<Storage> storages = api.getStorageApi().getAllStorages().getReturn();
      for (Storage storage : storages)
         if (storage.getProvisioningState() == ProvisioningState.AVAILABLE) {
            this.storage = storage;
            break;
         }
      this.snapshotWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.SNAPSHOT), 6l * 60l, 2l, TimeUnit.SECONDS);
   }

   @Test(expectedExceptions = NullPointerException.class)
   public void testCreateSnapshotExceptionOnNullStorageId() {
      api.getSnapshotApi().createSnapshot(
              Snapshot.creatingBuilder()
              .snapshotName("jclouds snapshot")
              .description("This is created via JCloud tests.")
              .build());
   }

   // This test fails - PB API docs says that the API returns 404 RESOURCE_NOT_FOUND when the storage id does not
   // exist; however, the actual call returns 503 UNEXPECTED. Issue was reported, and is yet to be resolved.
   @Test(expectedExceptions = ResourceNotFoundException.class)
   public void testCreateSnapshotOnNonExistingStorageId() {
      api.getSnapshotApi().createSnapshot(
              Snapshot.creatingBuilder()
              .storageId("some-random-non-existing-storage")
              .snapshotName("jclouds snapshot")
              .description("This is created via JCloud tests.")
              .build());
   }

   @Test
   public void testCreateSnapshot() {
      assertNotNull(vdc);
      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      assertNotNull(storage);
      snapshotId = api.getSnapshotApi().createSnapshot(
              Snapshot.creatingBuilder()
              .storageId(storage.getStorageId())
              .snapshotName("jclouds snapshot")
              .description("This is created via JCloud tests.")
              .build()).getReturn().getSnapshotId();

      assertNotNull(snapshotId);
   }

   @Test(dependsOnMethods = "testCreateSnapshot")
   public void testGetSnapshot() {
      Snapshot snapshot = api.getSnapshotApi().getSnapshot(snapshotId).getReturn();

      assertNotNull(snapshot);
   }

   @Test(alwaysRun = true, dependsOnMethods = "testCreateSnapshot")
   public void testGetAllSnapshot() {
      snapshotWaitingPredicate.apply(snapshotId);
      List<Snapshot> snapshots = api.getSnapshotApi().getAllSnapshots().getReturn();

      assertFalse(snapshots.isEmpty(), "No snapshots found.");
   }

   @Test(dependsOnMethods = "testGetAllSnapshot")
   public void testRollbackSnapshot() {
      snapshotWaitingPredicate.apply(snapshotId);
      Snapshot snapshot = api.getSnapshotApi().getSnapshot(snapshotId).getReturn();
      assertTrue(snapshot.getProvisioningState() == ProvisioningState.AVAILABLE,
              "Snapshot was not available before 'Rollback' test.");

      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      VersionResponse response = api.getSnapshotApi().rollbackSnapshot(
              Snapshot.rollbackBuilder()
              .snapshotId(snapshotId)
              .storageId(storage.getStorageId())
              .build()).getReturn();
      assertNotNull(response);
   }

   @Test(dependsOnMethods = "testRollbackSnapshot")
   public void testDeleteSnapshot() {
      snapshotWaitingPredicate.apply(snapshotId);
      Snapshot snapshot = api.getSnapshotApi().getSnapshot(snapshotId).getReturn();
      assertTrue(snapshot.getProvisioningState() == ProvisioningState.AVAILABLE,
              "Snapshot was not available before 'Delete' test.");

      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      String response = api.getSnapshotApi().deleteSnapshot(snapshot.getSnapshotId()).getReturn().getRequestId();
      assertNotNull(response);
   }
}
