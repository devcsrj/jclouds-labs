package org.jclouds.profitbricks.features;

import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.Snapshot;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

@Test(groups = "live", testName = "DataCenterApiLiveTest", singleThreaded = true)
public class SnapshotApiLiveTest extends BaseProfitBricksLiveTest {
    private String snapshotId;
    private String storageId = "7e84c2ef-968e-42f8-87d2-15aeb1a70539";

    @Test
    public void testCreateSnapshot() {
        Snapshot snapshot = api.snapshotApi().createSnapshot(Snapshot.Request.CreatePayload.create(storageId, "my description", "test snapshot"));

        assertNotNull(snapshot);

        snapshotId = snapshot.snapshotId();
    }

    @Test
    public void testGetAllSnapshots() {
        List<Snapshot> snapshots = api.snapshotApi().getAllSnapshots();

        assertNotNull(snapshots);
        assertTrue(snapshots.size() > 0);
    }

    @Test
    public void testGetSnapshot() {
        Snapshot snapshot = api.snapshotApi().getSnapshot(snapshotId);

        assertNotNull(snapshot);
        assertTrue(snapshot.snapshotId() == snapshotId);
    }

    @Test
    public void testUpdateSnapshot() {
        api.snapshotApi().updateSnapshot(Snapshot.Request.UpdatePayload.create(snapshotId, "new description", "new name", true, OsType.LINUX, true, true, true, true, true, true, true, true));

        Snapshot snapshot = api.snapshotApi().getSnapshot(snapshotId);

        assertTrue(snapshot.description() == "new description");
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
