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
package org.jclouds.profitbricks.domain;

import com.google.auto.value.AutoValue;

import java.util.List;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.profitbricks.domain.internal.FirewallRuleCommonProperties;

import autovalue.shaded.com.google.common.common.collect.Lists;

@AutoValue
public abstract class Firewall {

   public enum Protocol {

      TCP, UDP, ICMP, ANY, UNRECOGNIZED;

      public static Protocol fromValue(String value) {
	 try {
	    return valueOf(value);
	 } catch (IllegalArgumentException e) {
	    return UNRECOGNIZED;
	 }
      }
   }

   public abstract String id();

   @Nullable
   public abstract String nicId();

   public abstract boolean active();

   @Nullable
   public abstract ProvisioningState state();

   @Nullable
   public abstract List<Rule> rules();

   public static Firewall create(String id, String nicId, boolean active, ProvisioningState provisioningState,
	   List<Rule> rules) {
      return new AutoValue_Firewall(id, nicId, active, provisioningState, rules);
   }

   public static Builder builder() {
      return new Builder();
   }

   public static final class Request {

      public static AddRulePayload.Builder ruleAddingBuilder() {
	 return new AddRulePayload.Builder();
      }

      @AutoValue
      public static abstract class AddRulePayload {

	 public abstract String nicId();

	 public abstract List<RuleWithIcmp> rules();

	 public static AddRulePayload create(String nicId, List<RuleWithIcmp> rules) {
	    return new AutoValue_Firewall_Request_AddRulePayload(nicId, rules);
	 }

	 public static class Builder {

	    private String nicId;
	    private List<RuleWithIcmp> rules = Lists.newArrayList();

	    public Builder nicId(String nicId) {
	       this.nicId = nicId;
	       return this;
	    }

	    public Builder rules(List<RuleWithIcmp> rules) {
	       this.rules = rules;
	       return this;
	    }

	    public RuleWithIcmp.Builder newRule() {
	       return new RuleWithIcmp.Builder(this);
	    }

	    public Builder addRule(RuleWithIcmp rule) {
	       this.rules.add(rule);
	       return this;
	    }

	    public AddRulePayload build() {
	       return AddRulePayload.create(nicId, rules);
	    }
	 }
      }
   }

   public static class Builder {

      private String id;
      private String nicId;
      private boolean active;

      private ProvisioningState state;
      private List<Rule> rules;

      public Builder id(String id) {
	 this.id = id;
	 return this;
      }

      public Builder nicId(String nicId) {
	 this.nicId = nicId;
	 return this;
      }

      public Builder active(boolean active) {
	 this.active = active;
	 return this;
      }

      public Builder state(ProvisioningState state) {
	 this.state = state;
	 return this;
      }

      public Builder rules(List<Rule> firewallRules) {
	 this.rules = firewallRules;
	 return this;
      }

      public Builder fromFirewall(Firewall in) {
	 return this.id(in.id()).nicId(in.nicId()).active(in.active()).state(in.state())
		 .rules(in.rules());
      }

      public Firewall build() {
	 return Firewall.create(id, nicId, active, state, rules);
      }
   }

   public static abstract class RuleBuilder<B extends RuleBuilder, D extends FirewallRuleCommonProperties> {

      protected String name;
      protected String portRangeEnd;
      protected String portRangeStart;
      protected Protocol protocol;
      protected String sourceIp;
      protected String sourceMac;
      protected String targetIp;

      public B name(String name) {
	 this.name = name;
	 return self();
      }

      public B portRangeEnd(String portRangeEnd) {
	 this.portRangeEnd = portRangeEnd;
	 return self();
      }

      public B portRangeStart(String portRangeStart) {
	 this.portRangeStart = portRangeStart;
	 return self();
      }

      public B protocol(Protocol protocol) {
	 this.protocol = protocol;
	 return self();
      }

      public B sourceIp(String sourceIp) {
	 this.sourceIp = sourceIp;
	 return self();
      }

      public B sourceMac(String sourceMac) {
	 this.sourceMac = sourceMac;
	 return self();
      }

      public B targetIp(String targetIp) {
	 this.targetIp = targetIp;
	 return self();
      }

      public abstract B self();

      public abstract D build();

   }

   @AutoValue
   public static abstract class Rule implements FirewallRuleCommonProperties {

      @Nullable
      public abstract String id();

      public static Rule create(String id, String name, String portRangeEnd, String portRangeStart,
	      Protocol protocol, String sourceIp, String sourceMac, String targetIp) {
	 return new AutoValue_Firewall_Rule(name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac,
		 targetIp, id);
      }

      public static Builder describingBuilder() {
	 return new Builder();
      }

      public static class Builder extends RuleBuilder<Builder, Rule> {

	 private String id;

	 public Builder id(String id) {
	    this.id = id;
	    return self();
	 }

	 @Override
	 public Builder self() {
	    return this;
	 }

	 @Override
	 public Rule build() {
	    return Rule.create(id, name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
	 }

      }

   }

   @AutoValue
   public static abstract class RuleWithIcmp implements FirewallRuleCommonProperties {

      @Nullable
      public abstract String icmpCode();

      @Nullable
      public abstract String icmpType();

      public static RuleWithIcmp create(String icmpCode, String icmpType, String name, String portRangeEnd,
	      String portRangeStart, Protocol protocol, String sourceIp, String sourceMac, String targetIp) {
	 return new AutoValue_Firewall_RuleWithIcmp(name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac,
		 targetIp, icmpCode, icmpType);
      }

      public static Builder builder() {
	 return new Builder();
      }

      public static class Builder extends RuleBuilder<Builder, RuleWithIcmp> {

	 private Request.AddRulePayload.Builder parentBuilder;

	 private String icmpCode;
	 private String icmpType;

	 public Builder() {

	 }

	 private Builder(Request.AddRulePayload.Builder parentBuilder) {
	    this.parentBuilder = parentBuilder;
	 }

	 public Builder nextRule() {
	    this.parentBuilder.addRule(build());
	    return new Builder(parentBuilder);
	 }

	 public Request.AddRulePayload.Builder endRule() {
	    this.parentBuilder.addRule(build());
	    return parentBuilder;
	 }

	 public Builder icmpCode(String icmpCode) {
	    this.icmpCode = icmpCode;
	    return this;
	 }

	 public Builder icmpType(String icmpType) {
	    this.icmpType = icmpType;
	    return this;
	 }

	 @Override
	 public Builder self() {
	    return this;
	 }

	 @Override
	 public RuleWithIcmp build() {
	    return RuleWithIcmp.create(icmpCode, icmpType, name, portRangeEnd, portRangeStart, protocol,
		    sourceIp, sourceMac, targetIp);
	 }

      }
   }
}
