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
package org.jclouds.profitbricks.binders.firewall;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.binders.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.firewall.FirewallRuleRequest;
import org.jclouds.profitbricks.domain.firewall.add.AddFirewallRulesToNic;

public class AddFirewallRulesToNicRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "firewall";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request);

      Object obj = checkNotNull(postParams.get(PARAM));
      AddFirewallRulesToNic rules = AddFirewallRulesToNic.class.cast(obj);

      return createRequest(request, generateRequestPayload(rules));
   }

   private String generateRequestPayload(AddFirewallRulesToNic rules) {
      requestBuilder.append("<ws:addFirewallRulesToNic>");
      for (FirewallRuleRequest rule : rules.getRequest()) {
         requestBuilder.append("<request>")
                 .append(ifNotEmpty("<icmpCode>%d</icmpCode>", rule.getIcmpCode()))
                 .append(ifNotEmpty("<icmpType>%d</icmpType>", rule.getIcmpType()))
                 .append(ifNotEmpty("<name>%s</name>", rule.getName()))
                 .append(ifNotEmpty("<portRangeEnd>%d</portRangeEnd>", rule.getPortRangeEnd()))
                 .append(ifNotEmpty("<portRangeStart>%d</portRangeStart>", rule.getPortRangeStart()))
                 .append(ifNotEmpty("<protocol>%s</protocol>", rule.getProtocol()))
                 .append(ifNotEmpty("<sourceIp>%s</sourceIp>", rule.getSourceIp()))
                 .append(ifNotEmpty("<sourceMac>%s</sourceMac>", rule.getSourceMac()))
                 .append(ifNotEmpty("<targetIp>%s</targetIp>", rule.getTargetIp()))
                 .append("</request>");
      }
      requestBuilder.append(format("<nicId>%s</nicId>", checkNotNull(rules.getNicId())))
              .append("</ws:addFirewallRulesToNic>");
      return requestBuilder.toString();
   }
}
