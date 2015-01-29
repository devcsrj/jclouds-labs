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
package org.jclouds.profitbricks.domain.FireWal;

import com.google.auto.value.AutoValue;
import org.jclouds.profitbricks.domain.Firewall;

import java.util.List;

@AutoValue
public abstract class Nic {

    public abstract String nicId();

    public abstract String dataCenterId();

    public abstract int dataCenterVersion();

    public abstract String lanId();

    public abstract boolean internetAccess();

    public abstract String serverId();

    public abstract List<String> ips();

    public abstract String macAddress();

    public abstract List<Firewall> firewalls();

    public static Nic create(String nicId, String dataCenterId, int dataCenterVersion, String lanId, boolean internetAccess, String serverId, List<String> ips, String macAddress, List<Firewall> firewalls) {
        return new AutoValue_Nic(nicId, dataCenterId, dataCenterVersion, lanId, internetAccess, serverId, ips, macAddress, firewalls);
    }

    public static class Builder {
        public String nicId;

        public String dataCenterId;

        public int dataCenterVersion;

        public String lanId;

        public boolean internetAccess;

        public String serverId;

        public List<String> ips;

        public String macAddress;

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

        public Builder ips(List<String> ips) {
            this.ips = ips;
            return this;
        }

        public Builder macAddress(String macAddress) {
            this.macAddress = macAddress;
            return this;
        }

        private Nic.Builder fromNic(Nic in) {
            return this.nicId(in.nicId()).dataCenterId(in.dataCenterId()).dataCenterVersion(in.dataCenterVersion())
                    .lanId(in.lanId()).internetAccess(in.internetAccess()).serverId(in.serverId())
                    .ips(in.ips()).macAddress(in.macAddress());
        }
    }
}
