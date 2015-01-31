package org.jclouds.profitbricks.http.parser.firewall;

import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;

public abstract class BaseFirewallResponseHandler<T> extends BaseProfitBricksResponseHandler<T> {

    protected Firewall.Builder builder;


    BaseFirewallResponseHandler() {
        builder = Firewall.builder();
    }

    @Override
    protected void setPropertyOnEndTag(String qName) {
        if ("nicId".equals(qName))
            builder.nicId(textToStringValue());
        else if ("active".equals(qName))
            builder.active(textToBooleanValue());
        else if ("firewallId".equals(qName))
            builder.fireWallId(textToStringValue());
        else if ("provisioningState".equals(qName))
            builder.provisioningState(ProvisioningState.fromValue(textToStringValue()));
    }
}
