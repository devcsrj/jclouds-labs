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

import com.google.common.collect.Iterables;
import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.Snapshot;
import org.testng.annotations.Test;

import java.util.List;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.Storage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@Test(groups = "live", testName = "SnapshotApiLiveTest", singleThreaded = true)
public class SnapshotApiLiveTest extends BaseProfitBricksLiveTest {

    private String snapshotId = "3d5caf11-9c1b-42f6-9327-852e6230a53c";
    private String storageId;

    @Override
    protected void initialize() {
        super.initialize();
        List<Storage> storages = api.storageApi().getAllStorages();
        assertFalse(storages.isEmpty(), "Must atleast have 1 datacenter available for server testing.");

        storageId = Iterables.getFirst(storages, null).id();

        System.out.println("Storages count " + storages.size());

    }

    @Test
    public void testCreateSnapshot() {
        getStorage();
        Snapshot snapshot = api.snapshotApi().createSnapshot(Snapshot.Request.CreatePayload.create(storageId, "my description", "test snapshot"));

        assertNotNull(snapshot);
        System.out.print(snapshot);
        snapshotId = snapshot.id();
    }

    @Test
    public void testGetAllSnapshots() {
        List<Snapshot> snapshots = api.snapshotApi().getAllSnapshots();

        System.out.println("Snapshots count " + snapshots.size());
        snapshotId = snapshots.get(0).id();
        System.out.println("Taking one snapshot ID " + snapshotId);

        assertNotNull(snapshots);
        assertEquals(snapshots.size() > 0, true);
    }

    @Test
    public void testGetSnapshot() {
        getSnapshotId();

        Snapshot snapshot = api.snapshotApi().getSnapshot(snapshotId);

        System.out.print(snapshot);

        assertNotNull(snapshot);
        assertTrue(snapshot.id().equals(snapshotId));
    }

    @Test
    public void testUpdateSnapshot() {
        getSnapshotId();

        System.out.println("Updating snapshot " + snapshotId);

        api.snapshotApi().updateSnapshot(Snapshot.Request.UpdatePayload.create(snapshotId, "new description", "new name123", true, OsType.LINUX, true, true, true, true, true, true, true, true));

        Snapshot snapshot = api.snapshotApi().getSnapshot(snapshotId);

        System.out.print(snapshot);

        assertNotNull(snapshot);
        assertEquals(snapshot.name(), "new name123");
    }

    @Test
    public void testRollbackSnapshot() {
        getSnapshotId();

        System.out.println("Rolling back snapshot " + snapshotId);

        boolean result = api.snapshotApi().rollbackSnapshot(Snapshot.Request.RollbackPayload.create(snapshotId, storageId));

        assertTrue(result);
    }

    @Test
    public void testDeleteSnapshot() {
        getSnapshotId();

        System.out.println("Deleting snapshot " + snapshotId);
        boolean result = api.snapshotApi().deleteSnapshot(snapshotId);

        assertTrue(result);
    }

    private void getSnapshotId() {
        if (snapshotId == null) {
            System.out.println("SnapshotId is null.");
            System.out.println("Fetching a new one.");
            List<Snapshot> snapshots = api.snapshotApi().getAllSnapshots();

            for (Snapshot s : snapshots) {
                if (s.state().equals(ProvisioningState.AVAILABLE)) {
                    snapshotId = s.id();
                }
            }
        }
    }

    private void getStorage() {
        if (storageId == null) {
            System.out.println("Storage ID is null.");
            System.out.println("Fetching a new one.");
            List<Storage> storages = api.storageApi().getAllStorages();

            storageId = Iterables.getFirst(storages, null).id();
        }
    }
}
