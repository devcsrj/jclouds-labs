package org.jclouds.profitbricks.http.parser.snapshot;

import org.jclouds.date.DateCodecFactory;
import org.jclouds.profitbricks.domain.Server;
import org.jclouds.profitbricks.domain.Snapshot;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;
import org.xml.sax.SAXException;


public class SnapshotIdOnlyResponseHandler extends BaseSnapshotResponseHandler<Snapshot> {

    private boolean done = false;

    SnapshotIdOnlyResponseHandler( ) {
    }

    @Override
    public void endElement( String uri, String localName, String qName ) throws SAXException {
        if ( done )
            return;
        setPropertyOnEndTag(qName);
        if ( "return".equals( qName ) )
            done = true;
        clearTextBuffer();
    }

    @Override
    public Snapshot getResult() {
        return builder.build();
    }

}
