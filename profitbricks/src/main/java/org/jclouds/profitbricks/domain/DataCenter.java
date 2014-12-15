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

import org.jclouds.javax.annotation.Nullable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DataCenter {

   public abstract String id();

   @Nullable public abstract String name();

   public abstract int version();

   @Nullable public abstract ProvisioningState state();

   @Nullable public abstract Location location();

//   @Nullable public abstract List<Server> servers();
//   @Nullable public abstract List<Storage> storages();
//   @Nullable public abstract List<LoadBalancer> loadBalancers();
   public static DataCenter create(String id, String name, int version, ProvisioningState state, Location location) {
      return new AutoValue_DataCenter(id, name, version, state, location);
   }

   public static Builder builder() {
      return new Builder();
   }

   public Builder toBuilder() {
      return builder().fromDataCenter(this);
   }

   public static final class Builder {

      private String id;
      private String name;
      private ProvisioningState state;
      private Location location;
      private int version;
//      private List<Server> servers;
//      private List<Storage> storage;
//      private List<LoadBalancer> loadBalancer;

      public Builder id(String id) {
	 this.id = id;
	 return this;
      }

      public Builder name(String name) {
	 this.name = name;
	 return this;
      }

      public Builder state(ProvisioningState state) {
	 this.state = state;
	 return this;
      }

      public Builder location(Location location) {
	 this.location = location;
	 return this;
      }

      public Builder version(int version) {
	 this.version = version;
	 return this;
      }

      public DataCenter build() {
	 return DataCenter.create(id, name, version, state, location);
      }

      public Builder fromDataCenter(DataCenter in) {
	 return this.id(in.id()).name(in.name()).version(in.version()).state(in.state()).location(in.location());
      }
   }

   public static final class Request {

      @AutoValue
      public static abstract class CreatePayload {

	 public abstract String name();

	 public abstract Location location();

	 public static CreatePayload create(String name, Location location) {
	    return new AutoValue_DataCenter_Request_CreatePayload(name, location);
	 }

      }
   }
}
