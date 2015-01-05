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
package org.jclouds.profitbricks.domain.server.update;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;

public class UpdateServerRequestBuilder {

   private String serverId;
   private String serverName;
   private Integer cores;
   private Integer ram;
   private String bootFromStorageId;
   private String bootFromImageId;
   private OsType osType;
   private AvailabilityZone availabilityZone;
   private Boolean cpuHotPlug;
   private Boolean ramHotPlug;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;
   private Boolean discVirtioHotPlug;
   private Boolean discVirtioHotUnPlug;

   protected void checkFields() {
      checkCores(cores);
      checkRam(ram);
      checkServerId(serverId);
   }

   protected int checkCores(int cores) {
      checkState(cores > 0, "Number of core must be >=1");
      return cores;
   }

   protected int checkRam(int ram) {
      checkState(ram >= 256, "Minimal RAM size is 256 MiB");
      checkState(ram % 256 == 0, "RAM size must be in multiples of 256 MiB");
      if (ramHotPlug != null && ramHotPlug.equals(Boolean.FALSE))
         checkState(ram >= 1024, "Minimal RAM size for RAM HotPlug capability is 1024 MiB");
      return ram;
   }

   protected String checkServerId(String serverId) {
      return checkNotNull(serverId, "Data center ID is required.");
   }

   public UpdateServerRequestBuilder() {
   }

   public UpdateServerRequestBuilder serverName(String serverName) {
      this.serverName = serverName;
      return this;
   }

   public UpdateServerRequestBuilder serverId(String serverId) {
      this.serverId = checkServerId(serverId);
      return this;
   }

   public UpdateServerRequestBuilder cores(int cores) {
      this.cores = checkCores(cores);
      return this;
   }

   public UpdateServerRequestBuilder ram(int ram) {
      this.ram = checkRam(ram);
      return this;
   }

   public UpdateServerRequestBuilder bootFromStorageId(String bootFromStorageId) {
      this.bootFromStorageId = bootFromStorageId;
      return this;
   }

   public UpdateServerRequestBuilder bootFromImageId(String bootFromImageId) {
      this.bootFromImageId = bootFromImageId;
      return this;
   }

   public UpdateServerRequestBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public UpdateServerRequestBuilder availabilityZone(AvailabilityZone availabilityZone) {
      this.availabilityZone = availabilityZone;
      return this;
   }

   public UpdateServerRequestBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public UpdateServerRequestBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public UpdateServerRequestBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public UpdateServerRequestBuilder nicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public UpdateServerRequestBuilder discVirtioHotPlug(Boolean discVirtioHotPlug) {
      this.discVirtioHotPlug = discVirtioHotPlug;
      return this;
   }

   public UpdateServerRequestBuilder discVirtioHotUnPlug(Boolean discVirtioHotUnPlug) {
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      return this;
   }

   public UpdateServerRequest build() {
      checkFields();
      return new UpdateServerRequest(serverId, serverName, cores, ram, bootFromStorageId, bootFromImageId, osType,
              availabilityZone, cpuHotPlug, ramHotPlug, nicHotPlug, nicHotUnPlug, discVirtioHotPlug, discVirtioHotUnPlug);
   }

}
