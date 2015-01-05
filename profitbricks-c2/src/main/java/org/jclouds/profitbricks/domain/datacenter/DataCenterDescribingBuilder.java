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
package org.jclouds.profitbricks.domain.datacenter;

import java.util.List;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponseBuilder;
import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancer;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.storage.Storage;

public class DataCenterDescribingBuilder extends VersionResponseBuilder<DataCenterDescribingBuilder> {

   private String dataCenterName;
   private List<Server> servers;
   private List<Storage> storages;
   private List<LoadBalancer> loadBalancers;
   private ProvisioningState provisioningState;
   private Location location;

   public DataCenterDescribingBuilder() {
   }

   public DataCenterDescribingBuilder dataCenterName(String dataCenterName) {
      this.dataCenterName = dataCenterName;
      return this;
   }

   public DataCenterDescribingBuilder servers(List<Server> servers) {
      this.servers = servers;
      return this;
   }

   public DataCenterDescribingBuilder storages(List<Storage> storages) {
      this.storages = storages;
      return this;
   }

   public DataCenterDescribingBuilder loadBalancers(List<LoadBalancer> loadBalancers) {
      this.loadBalancers = loadBalancers;
      return this;
   }

   public DataCenterDescribingBuilder provisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
      return this;
   }

   public DataCenterDescribingBuilder location(Location location) {
      this.location = location;
      return this;
   }

   public DataCenter build() {
      return new DataCenter(dataCenterName, servers, storages, loadBalancers, provisioningState, location, dataCenterId, dataCenterVersion);
   }

   @Override
   public DataCenterDescribingBuilder self() {
      return this;
   }

}
