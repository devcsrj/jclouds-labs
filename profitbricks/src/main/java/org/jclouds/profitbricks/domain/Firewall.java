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

@AutoValue
public abstract class Firewall {

    public abstract int icmpCode();

    public abstract int icmpType();

    public abstract int portRangeEnd();

    public abstract int portRangeStart();

    public abstract Protocol protocol();

    public abstract String sourceIp();

    public abstract String sourceMac();

    public abstract String targetIp();

    public static Firewall create(int icmpCode, int icmpType, int portRangeEnd, int portRangeStart, Protocol protocol, String sourceIp, String sourceMac, String targetIp) {
        return new AutoValue_Firewall(icmpCode, icmpType, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return builder().fromFirewall(this);
    }

    public static class Builder {
        public int icmpCode;

        public int icmpType;

        public int portRangeEnd;

        public int portRangeStart;

        public Protocol protocol;

        public String sourceIp;

        public String sourceMac;

        public String targetIp;

        public Builder icmpCode(int icmpCode) {
            this.icmpCode = icmpCode;
            return this;
        }

        public Builder icmpType(int icmpType) {
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
    }
}
