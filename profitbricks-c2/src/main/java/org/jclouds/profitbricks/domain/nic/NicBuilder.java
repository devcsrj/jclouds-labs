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
package org.jclouds.profitbricks.domain.nic;

import java.util.List;

import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.firewall.Firewall;

public class NicBuilder {

   private String nicId;
   private String nicName;
   private int lanId;
   private Boolean internetAccess;
   private String serverId;
   private List<String> ips;
   private String macAddress;
   private Firewall firewall;
   private Boolean dhcpActive;
   private String gatewayIp;
   private ProvisioningState provisioningState;

   public NicBuilder() {
   }

   public NicBuilder nicId(String nicId) {
      this.nicId = nicId;
      return this;
   }

   public NicBuilder nicName(String nicName) {
      this.nicName = nicName;
      return this;
   }

   public NicBuilder lanId(int lanId) {
      this.lanId = lanId;
      return this;
   }

   public NicBuilder internetAccess(Boolean internetAccess) {
      this.internetAccess = internetAccess;
      return this;
   }

   public NicBuilder serverId(String serverId) {
      this.serverId = serverId;
      return this;
   }

   public NicBuilder ips(List<String> ips) {
      this.ips = ips;
      return this;
   }

   public NicBuilder macAddress(String macAddress) {
      this.macAddress = macAddress;
      return this;
   }

   public NicBuilder firewall(Firewall firewall) {
      this.firewall = firewall;
      return this;
   }

   public NicBuilder dhcpActive(Boolean dhcpActive) {
      this.dhcpActive = dhcpActive;
      return this;
   }

   public NicBuilder gatewayIp(String gatewayIp) {
      this.gatewayIp = gatewayIp;
      return this;
   }

   public NicBuilder provisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
      return this;
   }

   public Nic build() {
      return new Nic(nicId, nicName, lanId, internetAccess, serverId, ips, macAddress, firewall, dhcpActive,
              gatewayIp, provisioningState);
   }

}
