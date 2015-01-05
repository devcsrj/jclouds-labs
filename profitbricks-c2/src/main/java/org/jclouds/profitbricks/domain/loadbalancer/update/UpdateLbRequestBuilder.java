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
package org.jclouds.profitbricks.domain.loadbalancer.update;

import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancerAlgorithm;

public class UpdateLbRequestBuilder {

   private String loadBalancerId;
   private String loadBalancerName;
   private LoadBalancerAlgorithm loadBalancerAlgorithm;
   private String ip;

   public UpdateLbRequestBuilder() {
   }

   public UpdateLbRequestBuilder loadBalancerId(String loadBalancerId) {
      this.loadBalancerId = checkLoadBalancerId(loadBalancerId);
      return this;
   }

   public UpdateLbRequestBuilder loadBalancerName(String loadBalancerName) {
      this.loadBalancerName = loadBalancerName;
      return this;
   }

   public UpdateLbRequestBuilder loadBalancerAlgorithm(LoadBalancerAlgorithm loadBalancerAlgorithm) {
      this.loadBalancerAlgorithm = loadBalancerAlgorithm;
      return this;
   }

   public UpdateLbRequestBuilder ip(String ip) {
      this.ip = ip;
      return this;
   }

   public UpdateLbRequest build() {
      checkLoadBalancerId(loadBalancerId);
      return new UpdateLbRequest(loadBalancerId, loadBalancerName, loadBalancerAlgorithm, ip);
   }

   public String checkLoadBalancerId(String loadBalancerId) {
      return checkNotNull(loadBalancerId);
   }

}
