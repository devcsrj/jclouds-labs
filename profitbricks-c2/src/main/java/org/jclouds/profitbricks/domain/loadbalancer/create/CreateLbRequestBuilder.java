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
package org.jclouds.profitbricks.domain.loadbalancer.create;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;

import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancerAlgorithm;

import com.google.common.collect.Lists;

public class CreateLbRequestBuilder {

   private String dataCenterId;
   private String loadBalancerName;
   private LoadBalancerAlgorithm loadBalancerAlgorithm;
   private String ip;
   private Integer lanId;
   private final List<String> serverIds;

   public CreateLbRequestBuilder() {
      this.serverIds = Lists.newArrayList();
   }

   public CreateLbRequestBuilder dataCenterId(String dataCenterId) {
      this.dataCenterId = checkDataCenterId(dataCenterId);
      return this;
   }

   public CreateLbRequestBuilder loadBalancerName(String loadBalancerName) {
      this.loadBalancerName = loadBalancerName;
      return this;
   }

   public CreateLbRequestBuilder loadBalancerAlgorithm(LoadBalancerAlgorithm loadBalancerAlgorithm) {
      this.loadBalancerAlgorithm = loadBalancerAlgorithm;
      return this;
   }

   public CreateLbRequestBuilder ip(String ip) {
      this.ip = ip;
      return this;
   }

   public CreateLbRequestBuilder lanId(Integer lanId) {
      this.lanId = lanId;
      return this;
   }

   public CreateLbRequestBuilder addServerId(String serverId) {
      this.serverIds.add(checkNotNull(serverId));
      return this;
   }

   public CreateLbRequestBuilder addServerIds(Collection<? extends String> serverIds) {
      this.serverIds.addAll(checkNotNull(serverIds));
      return this;
   }

   public CreateLbRequest build() {
      checkDataCenterId(dataCenterId);
      return new CreateLbRequest(dataCenterId, loadBalancerName, loadBalancerAlgorithm, ip, lanId, serverIds);
   }

   private String checkDataCenterId(String dataCenterId) {
      return checkNotNull(dataCenterId);
   }

}
