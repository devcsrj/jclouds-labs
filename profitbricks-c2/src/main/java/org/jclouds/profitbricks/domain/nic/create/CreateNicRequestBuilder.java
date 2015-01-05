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
package org.jclouds.profitbricks.domain.nic.create;

import static com.google.common.base.Preconditions.checkNotNull;

public class CreateNicRequestBuilder {

   private String serverId;
   private int lanId;
   private String nicName;
   private String ip;
   private Boolean dhcpActive;

   private String checkServerId(String serverId) {
      return checkNotNull(serverId);
   }

   private int checkLanId(int lanId) {
      return checkNotNull(lanId);
   }

   private void checkFields() {
      checkServerId(serverId);
      checkLanId(lanId);
   }

   public CreateNicRequestBuilder() {
   }

   public CreateNicRequestBuilder serverId(String serverId) {
      this.serverId = checkServerId(serverId);
      return this;
   }

   public CreateNicRequestBuilder lanId(int lanId) {
      this.lanId = checkLanId(lanId);
      return this;
   }

   public CreateNicRequestBuilder nicName(String nicName) {
      this.nicName = nicName;
      return this;
   }

   public CreateNicRequestBuilder ip(String ip) {
      this.ip = ip;
      return this;
   }

   public CreateNicRequestBuilder setDhcpActive(Boolean dhcpActive) {
      this.dhcpActive = dhcpActive;
      return this;
   }

   public CreateNicRequest build() {
      checkFields();
      return new CreateNicRequest(serverId, lanId, nicName, ip, dhcpActive);
   }

}
