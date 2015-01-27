package org.jclouds.profitbricks.http.parser.snapshot;

import org.jclouds.profitbricks.domain.Snapshot;
import org.xml.sax.SAXException;


public class SnapshotResponseHandler extends BaseSnapshotResponseHandler<Snapshot> {

    private boolean done = false;

    SnapshotResponseHandler() {
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
