package org.jclouds.profitbricks.http.parser.nic;

import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;

public abstract class BaseNicResponseHandler<T> extends BaseProfitBricksResponseHandler<T> {
    protected Nic.Builder builder;

    BaseNicResponseHandler(){
        this.builder = Nic.builder();
    }

    @Override
    protected void setPropertyOnEndTag( String qName ) {
        if ( "dataCenterId".equals( qName ) )
            builder.nicId(textToStringValue());
        else if ( "dataCenterVersion".equals( qName ) )
            builder.dataCenterVersion(textToIntValue());
        else if ( "nicId".equals( qName ) )
            builder.lanId(textToStringValue());
        else if ( "lanId".equals( qName ) )
            builder.lanId(textToStringValue());
        else if ( "internetAccess".equals( qName ) )
            builder.internetAccess(textToBooleanValue());
        else if ( "serverId".equals( qName ) )
            builder.serverId(textToStringValue());
        else if ( "ips".equals( qName ) )
            builder.ips(textToStringValue());
        else if ( "macAddress".equals( qName ) )
            builder.macAddress(textToStringValue());
        else if ( "dhcpActive".equals( qName ) )
            builder.dhcpActive(textToBooleanValue());
        else if ( "gatewayIp".equals( qName ) )
            builder.gatewayIp(textToStringValue());
        else if ( "provisioningState".equals( qName ) )
            builder.provisioningState(ProvisioningState.fromValue( textToStringValue()));

    }
}
