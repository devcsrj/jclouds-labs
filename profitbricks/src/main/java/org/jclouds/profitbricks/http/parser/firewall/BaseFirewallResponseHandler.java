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

import com.google.common.collect.Lists;
import com.google.inject.Inject;

import java.util.List;

import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;
import org.jclouds.profitbricks.http.parser.firewall.rule.FirewallRuleResponseHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public abstract class BaseFirewallResponseHandler<T> extends BaseProfitBricksResponseHandler<T> {

   protected final FirewallRuleResponseHandler firewallRuleResponseHandler;
   protected final List<Firewall.Rule> firewallRules = Lists.newArrayList();
   protected boolean useFirewallRuleParser = false;
   protected Firewall.Builder builder;

   @Inject
   BaseFirewallResponseHandler(FirewallRuleResponseHandler firewallRuleResponseHandler) {
      this.builder = Firewall.builder();
      this.firewallRuleResponseHandler = firewallRuleResponseHandler;
   }

   @Override
   public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      if ("firewallRules".equals(qName))
	 useFirewallRuleParser = true;
      if (useFirewallRuleParser)
	 firewallRuleResponseHandler.startElement(uri, localName, qName, attributes);
   }

   @Override
   public void characters(char[] ch, int start, int length) {
      if (useFirewallRuleParser)
	 firewallRuleResponseHandler.characters(ch, start, length);
      else
	 super.characters(ch, start, length);
   }

   @Override
   protected void setPropertyOnEndTag(String qName) {
      if ("firewallId".equals(qName))
	 builder.id(textToStringValue());
      else if ("active".equals(qName))
	 builder.active(textToBooleanValue());
      else if ("nicId".equals(qName))
	 builder.nicId(textToStringValue());
      else if ("provisioningState".equals(qName))
	 builder.state(ProvisioningState.fromValue(textToStringValue()));
   }
}
