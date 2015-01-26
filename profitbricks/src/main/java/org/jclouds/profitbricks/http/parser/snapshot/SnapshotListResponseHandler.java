package org.jclouds.profitbricks.http.parser.snapshot;

import com.google.common.collect.Lists;
import org.jclouds.date.DateCodecFactory;
import org.jclouds.profitbricks.domain.Image;
import org.jclouds.profitbricks.domain.Snapshot;
import org.jclouds.profitbricks.http.parser.image.BaseImageResponseHandler;
import org.xml.sax.SAXException;

import java.util.List;

/**
 * Created by JASMIN on 01/26/15.
 */
public class SnapshotListResponseHandler extends BaseSnapshotResponseHandler<List<Snapshot>> {

    private final List<Snapshot> snapshots;

    SnapshotListResponseHandler() {
        this.snapshots = Lists.newArrayList();
    }

    @Override
    public void endElement( String uri, String localName, String qName ) throws SAXException {
        setPropertyOnEndTag( qName );
        if ( "return".equals( qName ) ) {
            snapshots.add( builder.build() );
            builder = Snapshot.builder();
        }
        clearTextBuffer();
    }

    @Override
    public List<Snapshot> getResult() {
        return snapshots;
    }

}
