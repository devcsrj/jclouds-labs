package org.jclouds.profitbricks.http.parser.firewall;

import autovalue.shaded.com.google.common.common.collect.Lists;
import org.jclouds.profitbricks.domain.Firewall;
import org.xml.sax.SAXException;

import java.util.List;

public class FirewallListResponseHandler extends BaseFirewallResponseHandler<List<Firewall>> {

    private List<Firewall> firewalls;

    FirewallListResponseHandler(){
        firewalls = Lists.newArrayList();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        setPropertyOnEndTag(qName);
        if ("return".equals(qName)) {
            firewalls.add(builder.build());
            builder = Firewall.builder();
        }
        clearTextBuffer();
    }

    @Override
    public List<Firewall> getResult() {
        return firewalls;
    }
}
