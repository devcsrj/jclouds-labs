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

@AutoValue
public abstract class Firewall {

    public abstract String fireWallId();

    public abstract boolean active();

    public abstract String nicId();

    public abstract ProvisioningState provisioningState();

    @Nullable
    public abstract String icmpCode();

    @Nullable
    public abstract String icmpType();

    @Nullable
    public abstract int portRangeEnd();

    @Nullable
    public abstract int portRangeStart();

    @Nullable
    public abstract Protocol protocol();

    @Nullable
    public abstract String sourceIp();

    @Nullable
    public abstract String sourceMac();

    @Nullable
    public abstract String targetIp();

    public static Firewall create(String fireWallId, boolean active, String nicId, ProvisioningState provisioningState, String icmpCode, String icmpType, int portRangeEnd, int portRangeStart, Protocol protocol, String sourceIp, String sourceMac, String targetIp) {
        return new AutoValue_Firewall(fireWallId, active, nicId, provisioningState, icmpCode, icmpType, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return builder().fromFirewall(this);
    }

    public static class Builder {

        public String fireWallId;

        public boolean active;

        public String nicId;

        public ProvisioningState provisioningState;

        public String icmpCode;

        public String icmpType;

        public int portRangeEnd;

        public int portRangeStart;

        public Protocol protocol;

        public String sourceIp;

        public String sourceMac;

        public String targetIp;

        public Builder fireWallId(String fireWallId) {
            this.fireWallId = fireWallId;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder nicId(String nicId) {
            this.nicId = nicId;
            return this;
        }

        public Builder provisioningState(ProvisioningState provisioningState) {
            this.provisioningState = provisioningState;
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

        public Builder portRangeEnd(int portRangeEnd) {
            this.portRangeEnd = portRangeEnd;
            return this;
        }

        public Builder portRangeStart(int portRangeStart) {
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

        private Firewall.Builder fromFirewall(Firewall in) {
            return this.icmpCode(in.icmpType()).portRangeEnd(in.portRangeEnd())
                    .portRangeStart(in.portRangeStart()).protocol(in.protocol()).sourceIp(in.sourceIp()).sourceMac(in.sourceMac()).targetIp(in.targetIp());
        }

        public Firewall build() {
            return Firewall.create(fireWallId, active, nicId, provisioningState, icmpCode, icmpType, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
        }
    }
}
