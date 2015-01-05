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
package org.jclouds.profitbricks.domain.snapshot.update;

import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.OsType;

public class UpdateSnapshotRequestBuilder {

   private String snapshotId;
   private String description;
   private Boolean bootable;
   private OsType osType;
   private Boolean cpuHotPlug;
   private Boolean ramHotPlug;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;

   public UpdateSnapshotRequestBuilder() {
   }

   public UpdateSnapshotRequestBuilder snapshotId(String snapshotId) {
      checkRequired();
      this.snapshotId = snapshotId;
      return this;
   }

   public UpdateSnapshotRequestBuilder description(String description) {
      this.description = description;
      return this;
   }

   public UpdateSnapshotRequestBuilder bootable(Boolean bootable) {
      this.bootable = bootable;
      return this;
   }

   public UpdateSnapshotRequestBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public UpdateSnapshotRequestBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public UpdateSnapshotRequestBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public UpdateSnapshotRequestBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public UpdateSnapshotRequestBuilder nicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public UpdateSnapshotRequest build() {
      checkRequired();
      return new UpdateSnapshotRequest(snapshotId, description, snapshotId, bootable, osType, cpuHotPlug, cpuHotPlug,
              ramHotPlug, ramHotPlug, nicHotPlug, nicHotUnPlug, nicHotPlug, nicHotUnPlug);
   }

   private void checkRequired() {
      checkNotNull(snapshotId);
   }
}
