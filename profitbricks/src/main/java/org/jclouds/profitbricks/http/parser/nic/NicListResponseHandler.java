package org.jclouds.profitbricks.http.parser.nic;

import autovalue.shaded.com.google.common.common.collect.Lists;
import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.http.parser.firewall.FirewallListResponseHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.List;

public class NicListResponseHandler extends BaseNicResponseHandler<Nic> {

    FirewallListResponseHandler firewallResponseHandler;

    List<Firewall> firewalls = Lists.newArrayList();

    private boolean done = false;
    private boolean userFireWallParser = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("servers".equals(qName))
            userFireWallParser = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (done)
            return;

        if ("firewall".equals(qName)) {
            userFireWallParser = false;
            firewalls = firewallResponseHandler.getResult();
        }
    }

    @Override
    public Nic getResult() {
        return builder.build();
    }
}
