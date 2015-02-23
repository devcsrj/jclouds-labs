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

@AutoValue
public abstract class Firewall {

   public abstract String id();

   @Nullable
   public abstract String nicId();

   public abstract boolean active();

   @Nullable
   public abstract ProvisioningState state();

   @Nullable
   public abstract List<FirewallRule> firewallRules();

   public static Firewall create(String id, String nicId, boolean active, ProvisioningState provisioningState,
	   List<FirewallRule> firewallRules) {
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
      private List<FirewallRule> firewallRules;

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

      public Builder firewallRules(List<FirewallRule> firewallRules) {
	 this.firewallRules = firewallRules;
	 return this;
      }

      private Builder fromFirewall(Firewall in) {
	 return this.id(in.id()).nicId(in.nicId()).active(in.active()).state(in.state()).firewallRules(in.firewallRules());
      }

      public Firewall build() {
	 return Firewall.create(id, nicId, active, state, firewallRules);
      }
   }

   public static class Request {

      public static AddFirewallRulePayload.Builder addFirewallRuleBuilder() {
	 return new AddFirewallRulePayload.Builder();
      }

      @AutoValue
      public abstract static class AddFirewallRulePayload {

	 public abstract String nicId();

	 @Nullable
	 public abstract String icmpCode();

	 @Nullable
	 public abstract String icmpType();

	 @Nullable
	 public abstract String name();

	 @Nullable
	 public abstract String portRangeEnd();

	 @Nullable
	 public abstract String portRangeStart();

	 @Nullable
	 public abstract Protocol protocol();

	 @Nullable
	 public abstract String sourceIp();

	 @Nullable
	 public abstract String sourceMac();

	 @Nullable
	 public abstract String targetIp();

	 public static AddFirewallRulePayload create(String nicid, String icmpCode, String icmpType, String name, 
		 String portRangeEnd, String portRangeStart,
		 Protocol protocol, String sourceIp, String sourceMAc, String targetIp) {
	    return new AutoValue_Firewall_Request_AddFirewallRulePayload(nicid, icmpCode, icmpType, name, portRangeEnd, 
		    portRangeStart, protocol, sourceIp, sourceMAc, targetIp);
	 }

	 public static class Builder {

	    private String nicId;
	    private String icmpCode;
	    private String icmpType;
	    private String name;
	    private String portRangeEnd;
	    private String portRangeStart;
	    private Protocol protocol;
	    private String sourceIp;
	    private String sourceMac;
	    private String targetIp;

	    public Builder nicid(String nicId) {
	       this.nicId = nicId;
	       return this;
	    }

	    public Builder icmpCode(String icmpCode) {
	       this.icmpCode = icmpCode;
	       return this;
	    }

	    public Builder icmpType(String icmpType) {
	       this.icmpType = icmpType;
	       return this;
	    }

	    public Builder name(String name) {
	       this.name = name;
	       return this;
	    }

	    public Builder portRangeEnd(String portRangeEnd) {
	       this.portRangeEnd = portRangeEnd;
	       return this;
	    }

	    public Builder portRangeStart(String portRangeStart) {
	       this.portRangeStart = portRangeStart;
	       return this;
	    }

	    public Builder protocol(Protocol protocol) {
	       this.protocol = protocol;
	       return this;
	    }

	    public Builder sourceIp(String sourceIp) {
	       this.sourceIp = sourceIp;
	       return this;
	    }

	    public Builder sourceMac(String sourceMac) {
	       this.sourceMac = sourceMac;
	       return this;
	    }

	    public Builder targetIp(String targetIp) {
	       this.targetIp = targetIp;
	       return this;
	    }

	    public AddFirewallRulePayload build() {
	       return AddFirewallRulePayload.create(nicId, icmpCode, icmpType, name, portRangeEnd, portRangeStart, 
		       protocol, sourceIp, sourceMac, targetIp);
	    }
	 }
      }

   }
}
