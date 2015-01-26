package org.jclouds.profitbricks.http.parser.snapshot;

import com.google.inject.Inject;
import org.jclouds.date.DateCodec;
import org.jclouds.date.DateCodecFactory;
import org.jclouds.profitbricks.domain.Image;
import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.Snapshot;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;

import java.util.Date;

public abstract class BaseSnapshotResponseHandler<T> extends BaseProfitBricksResponseHandler<T> {

    protected Snapshot.Builder builder;

    BaseSnapshotResponseHandler( ) {
        this.builder = Snapshot.builder();
    }

    @Override
    protected void setPropertyOnEndTag( String qName ) {
        if ( "snapshotId".equals( qName ) )
            builder.id(textToStringValue());
        else if ( "snapshotName".equals( qName ) )
            builder.name(textToStringValue());
        else if ( "snapshotSize".equals( qName ) )
            builder.size(textToFloatValue());
        else if ( "osType".equals( qName ) )
            builder.osType(OsType.fromValue(textToStringValue()));
        else if ( "location".equals( qName ) )
            builder.location(Location.fromId(textToStringValue()));
        else if ( "description".equals( qName ) )
            builder.description(qName);
        else if ( "bootable".equals( qName ) )
            builder.bootable(textToBooleanValue());
        else if ( "cpuHotPlug".equals( qName ) )
            builder.cpuHotPlug(textToBooleanValue());
        else if ( "cpuHotUnPlug".equals( qName ) )
            builder.cpuHotUnPlug(textToBooleanValue());
        else if ( "ramHotPlug".equals( qName ) )
            builder.ramHotPlug( textToBooleanValue() );
        else if ( "ramHotUnPlug".equals( qName ) )
            builder.ramHotUnPlug( textToBooleanValue() );
        else if ( "nicHotPlug".equals( qName ) )
            builder.nicHotPlug( textToBooleanValue() );
        else if ( "nicHotUnPlug".equals( qName ) )
            builder.nicHotUnPlug( textToBooleanValue() );
        else if ( "discVirtioHotPlug".equals( qName ) )
            builder.discVirtioHotPlug( textToBooleanValue() );
        else if ( "discVirtioHotUnPlug".equals( qName ) )
            builder.discVirtioHotUnPlug( textToBooleanValue() );
    }

}
