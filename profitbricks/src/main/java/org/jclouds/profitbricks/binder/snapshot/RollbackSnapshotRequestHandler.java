package org.jclouds.profitbricks.binder.snapshot;

import org.jclouds.profitbricks.binder.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.Snapshot;

import static java.lang.String.format;

public class RollbackSnapshotRequestHandler extends BaseProfitBricksRequestBinder<Snapshot.Request.RollbackPayload> {
    protected final StringBuilder requestBuilder;

    protected RollbackSnapshotRequestHandler() {
        super("snapshot");
        this.requestBuilder = new StringBuilder(128);
    }

    @Override
    protected String createPayload(Snapshot.Request.RollbackPayload payload){
        requestBuilder.append("<ws:rollbackSnapshot>")
                .append("<request>")
                .append(format("<snapshotId>%s</snapshotId>", payload.snapshotId()))
                .append(format("<storageId>%s</storageId>", payload.storageId()))
                .append("</request>")
                .append("</ws:rollbackSnapshot>");
        return requestBuilder.toString();
    }
}
