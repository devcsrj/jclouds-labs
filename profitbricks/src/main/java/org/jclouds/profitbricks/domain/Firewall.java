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
   public abstract List<Rule> firewallRules();

   public static Firewall create(String id, String nicId, boolean active, ProvisioningState provisioningState,
	   List<Rule> firewallRules) {
      return new AutoValue_Firewall(id, nicId, active, provisioningState, firewallRules);
   }

   public static Builder builder() {
      return new Builder();
   }

   public static class Builder {

      private String id;
      private String nicId;
      private boolean active;

      private ProvisioningState state;
      private List<Rule> firewallRules;

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

      public Builder firewallRules(List<Rule> firewallRules) {
	 this.firewallRules = firewallRules;
	 return this;
      }

      public Builder fromFirewall(Firewall in) {
	 return this.id(in.id()).nicId(in.nicId()).active(in.active()).state(in.state())
		 .firewallRules(in.firewallRules());
      }

      public Firewall build() {
	 return Firewall.create(id, nicId, active, state, firewallRules);
      }
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

      public static DescribingBuilder describingBuilder() {
	 return new DescribingBuilder();
      }

      public static Request.CreatingBuilder creatingBuilder() {
	 return new Request.CreatingBuilder();
      }

      public static abstract class Builder<B extends Builder, D extends FirewallRuleCommonProperties> {

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

//	 private B fromRule(Rule in) {
//	    return this.id(in.id()).name(in.name()).portRangeEnd(in.portRangeEnd()).portRangeStart(in.portRangeStart())
//		    .protocol(in.protocol()).sourceIp(in.sourceIp()).sourceMac(in.sourceMac()).targetIp(in.targetIp());
//	 }
      }

      public static class DescribingBuilder extends Builder<DescribingBuilder, Rule> {

	 private String id;

	 public DescribingBuilder id(String id) {
	    this.id = id;
	    return self();
	 }

	 @Override
	 public DescribingBuilder self() {
	    return this;
	 }

	 @Override
	 public Rule build() {
	    return Rule.create(id, name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
	 }

      }

      public static class Request {

	 @AutoValue
	 public abstract static class CreatePayload implements FirewallRuleCommonProperties {

	    public abstract String nicId();

	    @Nullable
	    public abstract String icmpCode();

	    @Nullable
	    public abstract String icmpType();

	    public static CreatePayload create(String nicid, String icmpCode, String icmpType,
		    String name, String portRangeEnd, String portRangeStart, Protocol protocol, String sourceIp,
		    String sourceMAc, String targetIp) {
	       return new AutoValue_Firewall_Rule_Request_CreatePayload(name, portRangeEnd, portRangeStart,
		       protocol, sourceIp, sourceMAc, targetIp, nicid, icmpCode, icmpType);
	    }
	 }

	 public static class CreatingBuilder extends Builder<CreatingBuilder, CreatePayload> {

	    private String nicId;
	    private String icmpCode;
	    private String icmpType;

	    public CreatingBuilder nicid(String nicId) {
	       this.nicId = nicId;
	       return this;
	    }

	    public CreatingBuilder icmpCode(String icmpCode) {
	       this.icmpCode = icmpCode;
	       return this;
	    }

	    public CreatingBuilder icmpType(String icmpType) {
	       this.icmpType = icmpType;
	       return this;
	    }

	    @Override
	    public CreatingBuilder self() {
	       return this;
	    }

	    @Override
	    public CreatePayload build() {
	       return CreatePayload.create(nicId, icmpCode, icmpType, name, portRangeEnd, portRangeStart,
		       protocol, sourceIp, sourceMac, targetIp);
	    }

	 }
      }
   }

}
