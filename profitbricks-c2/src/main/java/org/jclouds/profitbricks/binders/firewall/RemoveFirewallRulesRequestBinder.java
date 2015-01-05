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

import java.util.List;
import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.binders.BaseProfitBricksRequestBinder;

public class RemoveFirewallRulesRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "firewall";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request);

      Object obj = checkNotNull(postParams.get(PARAM));
      List<String> ruleIds = List.class.cast(obj);

      return createRequest(request, generateRequestPayload(ruleIds));
   }

   protected String generateRequestPayload(List<String> ids) {
      requestBuilder.append("<ws:removeFirewallRules>");
      for (String ruleId : ids) {
         requestBuilder.append(ifNotEmpty("<firewallRuleIds>%s</firewallRuleIds>", ruleId));
      }
      requestBuilder.append("</ws:removeFirewallRules>");
      return requestBuilder.toString();
   }
}
