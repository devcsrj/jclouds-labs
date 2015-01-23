package org.jclouds.profitbricks.binder.snapshot;

import org.jclouds.profitbricks.binder.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.Snapshot;

import static java.lang.String.format;

/**
 * Created by JASMIN on 01/22/15.
 */
public class CreateSnapshotRequestBinder extends BaseProfitBricksRequestBinder<Snapshot.Request.CreatePayload> {

    protected final StringBuilder requestBuilder;

    protected CreateSnapshotRequestBinder() {
        super("snapshot");
        this.requestBuilder = new StringBuilder( 128 * 2 );
    }

    @Override
    protected String createPayload(Snapshot.Request.CreatePayload payload) {
        requestBuilder.append( "<ws:createStorage>" )
                .append("<request>")
                .append(format("<storageId>%s</storageId>", payload.storageId()))
                .append(format("<description>%s</description>", payload.description()))
                .append(format("<snapshotName>%s</snapshotName>", payload.snapshotName()))
                .append("</request>")
                .append("</ws:createStorage>");
        return requestBuilder.toString();
    }
}
