package org.jclouds.profitbricks.binder.snapshot;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.Snapshot;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Created by JASMIN on 01/27/15.
 */
public class UpdateSnapshotRequestBinderTest {

    @Test
    public void testUpdatePayload() {
        UpdateSnapshotRequestBinder binder = new UpdateSnapshotRequestBinder();

        Snapshot.Request.UpdatePayload payload = Snapshot.Request.UpdatePayload.create("qswdefrg-qaws-qaws-defe-rgrgdsvcxbrh", "description", "snapshot-name", true, OsType.LINUX, true, true, true, true, true, true, true, true);

        String actual = binder.createPayload(payload);
        assertNotNull(actual, "Binder returned null payload");
        assertEquals(expectedPayload, actual);

    }

    private final String expectedPayload =
            "<ws:updateSnapshot>" +
                    "<request>" +
                    "<snapshotId>qswdefrg-qaws-qaws-defe-rgrgdsvcxbrh</snapshotId>" +
                    "<description>description</description>" +
                    "<snapshotName>snapshot-name</snapshotName>" +
                    "<bootable>true</bootable>" +
                    "<osType>LINUX</osType>" +
                    "<cpuHotPlug>true</cpuHotPlug>" +
                    "<cpuHotUnPlug>true</cpuHotUnPlug>" +
                    "<ramHotPlug>true</ramHotPlug>" +
                    "<ramHotUnPlug>true</ramHotUnPlug>" +
                    "<nicHotPlug>true</nicHotPlug>" +
                    "<nicHotUnPlug>true</nicHotUnPlug>" +
                    "<discVirtioHotPlug>true</discVirtioHotPlug>" +
                    "<discVirtioHotUnPlug>true</discVirtioHotUnPlug>" +
                    "</request>" +
                    "</ws:updateSnapshot>" .replaceAll("\\s", "");

}
