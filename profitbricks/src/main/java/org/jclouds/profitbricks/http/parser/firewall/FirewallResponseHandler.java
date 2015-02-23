/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.profitbricks.http.parser.firewall;

import com.google.inject.Inject;
import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.http.parser.firewallrule.FirewallRuleResponseHandler;
import org.xml.sax.SAXException;

public class FirewallResponseHandler extends BaseFirewallResponseHandler<Firewall> {

   private boolean done = false;

   @Inject
   FirewallResponseHandler(FirewallRuleResponseHandler firewallRuleResponseHandler) {
      super(firewallRuleResponseHandler);
   }

   @Override
   public void endElement(String uri, String localName, String qName) throws SAXException {
      if (done)
	 return;

      if ("firewallRules".equals(qName)) {
	 useFirewallRuleParser = false;
	 firewallRules.add(firewallRuleResponseHandler.getResult());
      }
      if (useFirewallRuleParser)
	 firewallRuleResponseHandler.endElement(uri, localName, qName);
      else {
	 setPropertyOnEndTag(qName);
	 if ("return".equals(qName)) {
	    done = true;
	    builder.firewallRules(firewallRules);
	 }
	 clearTextBuffer();
      }
   }

   @Override
   public Firewall getResult() {
      return builder.build();
   }
}
