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
import org.jclouds.javax.annotation.Nullable;

import java.util.List;

@AutoValue
public abstract class Nic {

    @Nullable
    public abstract String requestId();
    @Nullable
    public abstract String nicId();

    @Nullable
    public abstract String dataCenterId();

    @Nullable
    public abstract int dataCenterVersion();

    @Nullable
    public abstract String lanId();

    @Nullable
    public abstract boolean internetAccess();

    @Nullable
    public abstract String serverId();

    @Nullable
    public abstract String ips();

    @Nullable
    public abstract String macAddress();

    @Nullable
    public abstract List<Firewall> firewalls();

    @Nullable
    public abstract boolean dhcpActive();

    @Nullable
    public abstract String gatewayIp();

    @Nullable
    public abstract ProvisioningState provisioningState();

    public static Nic create(String requestId, String nicId, String dataCenterId, int dataCenterVersion,
                             String lanId, boolean internetAccess, String serverId,
                             String ips, String macAddress, List<Firewall> firewalls,
                             boolean dhcpActive, String gatewayIp, ProvisioningState provisioningState) {
        return new AutoValue_Nic(requestId, nicId, dataCenterId, dataCenterVersion, lanId, internetAccess, serverId, ips, macAddress, firewalls, dhcpActive, gatewayIp, provisioningState);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return builder().fromNic(this);
    }


    public static class Builder {

        public String requestId;

        public String nicId;

        public String dataCenterId;

        public int dataCenterVersion;

        public String lanId;

        public boolean internetAccess;

        public String serverId;

        public String ips;

        public String macAddress;

        public boolean dhcpActive;

        public String gatewayIp;

        public ProvisioningState provisioningState;

        private List<Firewall> firewalls;

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder nicId(String nicId) {
            this.nicId = nicId;
            return this;
        }

        public Builder dataCenterId(String dataCenterId) {
            this.dataCenterId = dataCenterId;
            return this;
        }

        public Builder dataCenterVersion(int dataCenterVersion) {
            this.dataCenterVersion = dataCenterVersion;
            return this;
        }

        public Builder lanId(String lanId) {
            this.lanId = lanId;
            return this;
        }

        public Builder internetAccess(boolean internetAccess) {
            this.internetAccess = internetAccess;
            return this;
        }

        public Builder serverId(String serverId) {
            this.serverId = serverId;
            return this;
        }

        public Builder ips(String ips) {
            this.ips = ips;
            return this;
        }

        public Builder macAddress(String macAddress) {
            this.macAddress = macAddress;
            return this;
        }

        public Builder dhcpActive(boolean dhcpActive) {
            this.dhcpActive = dhcpActive;
            return this;
        }

        public Builder gatewayIp(String gatewayIp) {
            this.gatewayIp = gatewayIp;
            return this;
        }

        public Builder firewalls(List<Firewall> firewalls) {
            this.firewalls = firewalls;
            return this;
        }

        public Builder provisioningState(ProvisioningState provisioningState) {
            this.provisioningState = provisioningState;
            return this;
        }

        public Nic build() {
            return Nic.create(requestId, nicId, dataCenterId, dataCenterVersion, lanId, internetAccess, serverId, ips, macAddress, firewalls, dhcpActive, gatewayIp, provisioningState);
        }

        private Builder fromNic(Nic in) {
            return this.nicId(in.nicId()).dataCenterId(in.dataCenterId()).dataCenterVersion(in.dataCenterVersion())
                    .lanId(in.lanId()).internetAccess(in.internetAccess()).serverId(in.serverId())
                    .ips(in.ips()).macAddress(in.macAddress()).dhcpActive(in.dhcpActive()).gatewayIp(in.gatewayIp()).firewalls(in.firewalls()).requestId(in.requestId());
        }
    }

    public static final class Request {

        public static CreatePayload.Builder create() {
            return new CreatePayload.Builder();
        }

        @AutoValue
        public abstract static class CreatePayload {
            public abstract String ip();

            public abstract String nicName();

            public abstract boolean dhcpActive();

            public abstract String serverId();

            public abstract String lanId();

            public static CreatePayload create(String ip, String nicName, boolean dhcpActive, String serverId, String lanId) {
                return new AutoValue_Nic_Request_CreatePayload(ip, nicName, dhcpActive, serverId, lanId);
            }

            public static class Builder {
                private String ip;
                private String nicName;
                private boolean dhcpActive;
                private String serverId;
                private String lanId;

                public Builder ip(String ip) {
                    this.ip = ip;
                    return this;
                }

                public Builder nicName(String nicName) {
                    this.nicName = nicName;
                    return this;
                }

                public Builder dhcpActive(boolean dhcpActive) {
                    this.dhcpActive = dhcpActive;
                    return this;
                }

                public Builder serverId(String serverId) {
                    this.serverId = serverId;
                    return this;
                }

                public Builder lanId(String lanId) {
                    this.lanId = lanId;
                    return this;
                }

                public CreatePayload build() {
                    return CreatePayload.create(ip, nicName, dhcpActive, serverId, lanId);
                }

            }

        }

        @AutoValue
        public abstract static class UpdatePayload {
            public abstract String nicId();

            public abstract String ip();

            public abstract String nicName();

            public abstract boolean dhcpActive();

            public abstract String lanId();

            public static UpdatePayload create(String nicId, String ip, String nicName, boolean dhcpActive, String lanId) {
                return new AutoValue_Nic_Request_UpdatePayload(nicId, ip, nicName, dhcpActive, lanId);
            }

            public static class Builder {
                private String nicId;
                private String ip;
                private String nicName;
                private boolean dhcpActive;
                private String lanId;

                public Builder ip(String nicId) {
                    this.nicId = nicId;
                    return this;
                }

                public Builder nicName(String nicName) {
                    this.nicName = nicName;
                    return this;
                }

                public Builder dhcpActive(boolean dhcpActive) {
                    this.dhcpActive = dhcpActive;
                    return this;
                }

                public Builder lanId(String lanId) {
                    this.lanId = lanId;
                    return this;
                }

                public UpdatePayload build() {
                    return UpdatePayload.create(nicId, ip, nicName, dhcpActive, lanId);
                }

            }

        }

        @AutoValue
        public abstract static class SetInternetAccessPayload {
            public abstract String dataCenterId();

            public abstract String lanId();

            public abstract boolean internetAccess();

            public static SetInternetAccessPayload create(String dataCenterId, String lanId, boolean internetAccess) {
                return new AutoValue_Nic_Request_SetInternetAccessPayload(dataCenterId, lanId, internetAccess);
            }

            public static class Builder {
                public String dataCenterId;
                public String lanId;
                public boolean internetAccess;

                public Builder dataCenterId(String dataCenterId) {
                    this.dataCenterId = dataCenterId;
                    return this;
                }

                public Builder lanId(String lanId) {
                    this.lanId = lanId;
                    return this;
                }

                public Builder internetAccess(boolean internetAccess) {
                    this.internetAccess = internetAccess;
                    return this;
                }

                public SetInternetAccessPayload build() {
                    return SetInternetAccessPayload.create(dataCenterId, lanId, internetAccess);
                }
            }
        }
    }
}

