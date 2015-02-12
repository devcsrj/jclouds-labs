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

@AutoValue
public abstract class Firewall {

    public abstract String id();

    public abstract String nicId();

    public abstract boolean active();

    public abstract ProvisioningState state();

    public abstract List<FirewallRule> firewallRules();

    public static Firewall create(String id, String nicId, boolean active, ProvisioningState provisioningState, List<FirewallRule> firewallRules) {
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

        public static CreatePayload.Builder creatingBuilder() {
            return new CreatePayload.Builder();
        }

        @AutoValue
        public abstract static class CreatePayload {

            public abstract String nicid();
            
            public static CreatePayload create(String nicid){
                return new AutoValue_Firewall_Request_CreatePayload(nicid);
            }
            public static class Builder {

            }
        }
    }
}
