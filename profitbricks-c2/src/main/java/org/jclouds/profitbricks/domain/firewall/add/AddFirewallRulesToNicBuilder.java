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
package org.jclouds.profitbricks.domain.firewall.add;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jclouds.profitbricks.domain.firewall.FirewallRuleRequest;

import com.google.common.collect.Lists;

public class AddFirewallRulesToNicBuilder {

   private final Pattern macAddr = Pattern.compile("([0-9a-f]{2}[:-]){5}([0-9a-f]{2})");
   private final List<FirewallRuleRequest> request;
   private String nicId;

   public AddFirewallRulesToNicBuilder() {
      this.request = Lists.newArrayList();
   }

   public AddFirewallRulesToNicBuilder addRuleRequest(FirewallRuleRequest ruleRequest) {
      this.request.add(checkRuleRequest(ruleRequest));
      return this;
   }

   public AddFirewallRulesToNicBuilder nicId(String nicId) {
      this.nicId = checkNicId(nicId);
      return this;
   }

   public AddFirewallRulesToNic build() {
      checkFields();
      return new AddFirewallRulesToNic(request, nicId);
   }

   private void checkFields() {
      checkNicId(nicId);
      checkNotNull(request);
   }

   private String checkNicId(String nicId) {
      return checkNotNull(nicId);
   }

   private FirewallRuleRequest checkRuleRequest(FirewallRuleRequest ruleRequest) {
      checkNotNull(ruleRequest);
      if (ruleRequest.getSourceMac() != null) {
         Matcher matcher = macAddr.matcher(ruleRequest.getSourceMac());
         checkState(matcher.matches(), "MAC address must match pattern: aa:bb:cc:dd:ee:ff"); // aa:bb:cc:dd:ee:ff
      }
      // TODO regex check IP if not null
      if (ruleRequest.getPortRangeStart() != null)
         checkNotNull(ruleRequest.getPortRangeStart());
      if (ruleRequest.getPortRangeEnd() != null)
         checkNotNull(ruleRequest.getPortRangeEnd());
      if (ruleRequest.getPortRangeStart() != null && ruleRequest.getPortRangeEnd() != null) {
         checkState(ruleRequest.getPortRangeStart() > ruleRequest.getPortRangeEnd());
         checkState(ruleRequest.getPortRangeStart() >= 1);
         checkState(ruleRequest.getPortRangeEnd() <= 65534);
      }
      if (ruleRequest.getIcmpCode() != null)
         checkState(ruleRequest.getIcmpCode() >= 0 && ruleRequest.getIcmpCode() <= 254);
      if (ruleRequest.getIcmpType() != null)
         checkState(ruleRequest.getIcmpType() >= 0 && ruleRequest.getIcmpType() <= 254);
      return ruleRequest;
   }

}
