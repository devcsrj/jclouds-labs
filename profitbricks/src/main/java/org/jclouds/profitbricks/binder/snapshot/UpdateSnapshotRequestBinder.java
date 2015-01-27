package org.jclouds.profitbricks.binder.snapshot;

import static java.lang.String.format;
import org.jclouds.profitbricks.binder.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.Snapshot;

public class UpdateSnapshotRequestBinder extends BaseProfitBricksRequestBinder <Snapshot.Request.UpdatePayload>{

    protected final StringBuilder requestBuilder;

    protected UpdateSnapshotRequestBinder()
    {
        super("snapshot");
        this.requestBuilder = new StringBuilder(128);
    }

    @Override
    protected String createPayload(Snapshot.Request.UpdatePayload payload) {
        requestBuilder.append("<ws:updateSnapshot>")
                .append("<request>")
                .append(format("<snapshotId>%s</snapshotId>", payload.snapshotId()))
                .append(format("<description>%s</description>", payload.description()))
                .append(format("<snapshotName>%s</snapshotName>", payload.snapshotName()))
                .append(formatIfNotEmpty("<bootable>%s</bootable>", payload.bootable()))
                .append(formatIfNotEmpty("<osType>%s</osType>", payload.osType()))
                .append(formatIfNotEmpty("<cpuHotPlug>%s</cpuHotPlug>", payload.cpuHotplug()))
                .append(formatIfNotEmpty("<cpuHotUnPlug>%s</cpuHotUnPlug>", payload.cpuHotunplug()))
                .append(formatIfNotEmpty("<ramHotPlug>%s</ramHotPlug>", payload.ramHotplug()))
                .append(formatIfNotEmpty("<ramHotUnPlug>%s</ramHotUnPlug>", payload.ramHotunplug()))
                .append(formatIfNotEmpty("<nicHotPlug>%s</nicHotPlug>", payload.nicHotplug()))
                .append(formatIfNotEmpty("<nicHotUnPlug>%s</nicHotUnPlug>", payload.nicHotunplug()))
                .append(formatIfNotEmpty("<discVirtioHotPlug>%s</discVirtioHotPlug>", payload.discVirtioHotplug()))
                .append(formatIfNotEmpty("<discVirtioHotUnPlug>%s</discVirtioHotUnPlug>", payload.discVirtioHotunplug()))
                .append("</request>")
                .append("</ws:updateSnapshot>");
        return requestBuilder.toString();
    }
}
