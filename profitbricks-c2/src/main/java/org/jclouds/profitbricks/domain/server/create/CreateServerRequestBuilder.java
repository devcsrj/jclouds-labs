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
package org.jclouds.profitbricks.domain.server.create;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;

public class CreateServerRequestBuilder {

   private String dataCenterId;
   private int cores;
   private int ram;
   private String serverName;
   private String bootFromStorageId;
   private String bootFromImageId;
   private boolean internetAccess;
   private Integer lanId;
   private OsType osType;
   private AvailabilityZone availabilityZone;
   private Boolean cpuHotPlug;
   private Boolean ramHotPlug;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;
   private Boolean discVirtioHotPlug;
   private Boolean discVirtioHotUnPlug;

   public CreateServerRequest build() {
      checkFields();
      return new CreateServerRequest(dataCenterId, cores, ram, serverName, bootFromStorageId, bootFromImageId,
              internetAccess, lanId, osType, availabilityZone, cpuHotPlug, ramHotPlug, nicHotPlug, nicHotUnPlug,
              discVirtioHotPlug, discVirtioHotUnPlug);
   }

   protected void checkFields() {
      checkCores(cores);
      checkRam(ram);
      checkDataCenter(dataCenterId);
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

   protected String checkDataCenter(String dataCenterId) {
      return checkNotNull(dataCenterId, "Data center ID is required.");
   }

   public CreateServerRequestBuilder() {
   }

   public CreateServerRequestBuilder dataCenterId(String dataCenterId) {
      this.dataCenterId = checkDataCenter(dataCenterId);
      return this;
   }

   public CreateServerRequestBuilder cores(int cores) {
      this.cores = checkCores(cores);
      return this;
   }

   public CreateServerRequestBuilder ram(int ram) {
      this.ram = checkRam(ram);
      return this;
   }

   public CreateServerRequestBuilder serverName(String serverName) {
      this.serverName = serverName;
      return this;
   }

   public CreateServerRequestBuilder bootFromStorageId(String bootFromStorageId) {
      this.bootFromStorageId = bootFromStorageId;
      return this;
   }

   public CreateServerRequestBuilder bootFromImageId(String bootFromImageId) {
      this.bootFromImageId = bootFromImageId;
      return this;
   }

   public CreateServerRequestBuilder internetAccess(boolean internetAccess) {
      this.internetAccess = internetAccess;
      return this;
   }

   public CreateServerRequestBuilder lanId(Integer lanId) {
      this.lanId = lanId;
      return this;
   }

   public CreateServerRequestBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public CreateServerRequestBuilder availabilityZone(AvailabilityZone availabilityZone) {
      this.availabilityZone = availabilityZone;
      return this;
   }

   public CreateServerRequestBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public CreateServerRequestBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public CreateServerRequestBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public CreateServerRequestBuilder nicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public CreateServerRequestBuilder discVirtioHotPlug(Boolean discVirtioHotPlug) {
      this.discVirtioHotPlug = discVirtioHotPlug;
      return this;
   }

   public CreateServerRequestBuilder setDiscVirtioHotUnPlug(Boolean discVirtioHotUnPlug) {
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      return this;
   }

}
