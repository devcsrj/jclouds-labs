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
public abstract class FirewallRule {

   public abstract String id();

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

   public static FirewallRule create(String id, String name, String portRangeEnd, String portRangeStart, 
	   Protocol protocol, String sourceIp, String sourceMac, String targetIp) {
      return new AutoValue_FirewallRule(id, name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
   }

   public static Builder builder() {
      return new Builder();
   }

   public static class Builder {

      private String id;

      private String name;

      private String portRangeEnd;

      private String portRangeStart;

      private Protocol protocol;

      private String sourceIp;

      private String sourceMac;

      private String targetIp;

      public Builder id(String id) {
	 this.id = id;
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

      private Builder fromFirewallRule(FirewallRule in) {
	 return this.id(in.id()).name(in.name()).portRangeEnd(in.portRangeEnd()).portRangeStart(in.portRangeStart())
		 .protocol(in.protocol()).sourceIp(in.sourceIp()).sourceMac(in.sourceMac()).targetIp(in.targetIp());
      }

      public FirewallRule build() {
	 return FirewallRule.create(id, name, portRangeEnd, portRangeStart, protocol, sourceIp, sourceMac, targetIp);
      }
   }
}
