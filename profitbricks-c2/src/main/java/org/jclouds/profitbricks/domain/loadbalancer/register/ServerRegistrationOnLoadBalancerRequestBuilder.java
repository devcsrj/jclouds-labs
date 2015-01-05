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
package org.jclouds.profitbricks.domain.loadbalancer.register;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class ServerRegistrationOnLoadBalancerRequestBuilder {

   private final List<String> serverIds;
   private String loadBalancerId;

   public ServerRegistrationOnLoadBalancerRequestBuilder() {
      this.serverIds = Lists.newArrayList();
   }

   public ServerRegistrationOnLoadBalancerRequestBuilder addServerId(String serverId) {
      this.serverIds.add(checkNotNull(serverId));
      return this;
   }

   public ServerRegistrationOnLoadBalancerRequestBuilder addServerIds(Collection<? extends String> serverIds) {
      this.serverIds.addAll(serverIds);
      return this;
   }

   public ServerRegistrationOnLoadBalancerRequestBuilder setLoadBalancerId(String loadBalancerId) {
      this.loadBalancerId = checkLoadBalancerId(loadBalancerId);
      return this;
   }

   public ServerRegistrationOnLoadBalancerRequest createRegisterServersOnLoadBalancer() {
      checkFields();
      return new ServerRegistrationOnLoadBalancerRequest(serverIds, loadBalancerId);
   }

   private void checkFields() {
      checkLoadBalancerId(loadBalancerId);
      checkServerIds(serverIds);
   }

   private String checkLoadBalancerId(String loadBalancerId) {
      return checkNotNull(loadBalancerId);
   }

   private List<String> checkServerIds(List<String> serverIds) {
      return checkNotNull(serverIds);
   }
}
