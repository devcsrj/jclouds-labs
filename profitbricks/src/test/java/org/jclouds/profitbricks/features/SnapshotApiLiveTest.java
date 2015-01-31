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

import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.Snapshot;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@Test(groups = "live", testName = "SnapshotApiLiveTest", singleThreaded = true)
public class SnapshotApiLiveTest extends BaseProfitBricksLiveTest {
    private String snapshotId;
    private String storageId = "9fa38c91-b672-422e-8bb4-b4296e12504d";

    @Test
    public void testCreateSnapshot() {
        Snapshot snapshot = api.snapshotApi().createSnapshot(Snapshot.Request.CreatePayload.create(storageId, "my description", "test snapshot"));

        assertNotNull(snapshot);

        dcWaitingPredicate.apply(snapshot.snapshotId());
        snapshotId = snapshot.snapshotId();
    }

    @Test
    public void testGetAllSnapshots() {
        List<Snapshot> snapshots = api.snapshotApi().getAllSnapshots();

        assertNotNull(snapshots);
        assertTrue(snapshots.size() > 0);
        snapshotId = snapshots.get(0).snapshotId();
        System.out.println("********snapshotId*********");
        System.out.println(snapshotId);
    }

    @Test
    public void testGetSnapshot() {
        Snapshot snapshot = api.snapshotApi().getSnapshot("79e17114-6441-4443-888c-2d11f07598bc");

        assertNotNull(snapshot);
        System.out.println("********snapshotId*********");
        System.out.println(snapshot.snapshotId());

        assertTrue(snapshot.snapshotId().compareTo("79e17114-6441-4443-888c-2d11f07598bc")==0);
    }

    @Test
    public void testUpdateSnapshot() {
        api.snapshotApi().updateSnapshot(Snapshot.Request.UpdatePayload.create(snapshotId, "new description", "new name", true, OsType.LINUX, true, true, true, true, true, true, true, true));

        Snapshot snapshot = api.snapshotApi().getSnapshot(snapshotId);

        assertTrue(snapshot.description().equals("new description"));
    }

    @Test
    public void testRollbackSnapshot() {
        boolean result = api.snapshotApi().rollbackSnapshot(Snapshot.Request.RollbackPayload.create(snapshotId, storageId));

        assertTrue(result);
    }

    @Test
    public void testDeleteSnapshot() {
        boolean result = api.snapshotApi().deleteSnapshot(snapshotId);

        assertTrue(result);
    }

}
