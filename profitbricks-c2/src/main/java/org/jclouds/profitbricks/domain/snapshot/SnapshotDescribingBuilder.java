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
package org.jclouds.profitbricks.domain.snapshot;

import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.ProvisioningState;

public class SnapshotDescribingBuilder {

   private String snapshotId;
   private String description;
   private long snapshotSize;
   private String snapshotName;
   private ProvisioningState provisioningState;
   private Boolean bootable;
   private OsType osType;
   private Boolean cpuHotPlug;
   private Boolean ramHotPlug;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;
   private XMLGregorianCalendar creationTimestamp;
   private XMLGregorianCalendar modificationTimestamp;
   private Location location;

   SnapshotDescribingBuilder() {
   }

   public SnapshotDescribingBuilder snapshotId(String snapshotId) {
      this.snapshotId = snapshotId;
      return this;
   }

   public SnapshotDescribingBuilder description(String description) {
      this.description = description;
      return this;
   }

   public SnapshotDescribingBuilder snapshotSize(long snapshotSize) {
      this.snapshotSize = snapshotSize;
      return this;
   }

   public SnapshotDescribingBuilder snapshotName(String snapshotName) {
      this.snapshotName = snapshotName;
      return this;
   }

   public SnapshotDescribingBuilder provisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
      return this;
   }

   public SnapshotDescribingBuilder bootable(Boolean bootable) {
      this.bootable = bootable;
      return this;
   }

   public SnapshotDescribingBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public SnapshotDescribingBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public SnapshotDescribingBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public SnapshotDescribingBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public SnapshotDescribingBuilder nicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public SnapshotDescribingBuilder creationTimestamp(XMLGregorianCalendar creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
   }

   public SnapshotDescribingBuilder modificationTimestamp(XMLGregorianCalendar modificationTimestamp) {
      this.modificationTimestamp = modificationTimestamp;
      return this;
   }

   public SnapshotDescribingBuilder location(Location location) {
      this.location = location;
      return this;
   }

   public Snapshot build() {
      return new Snapshot(snapshotId, description, snapshotSize, snapshotName, provisioningState, bootable, osType,
              cpuHotPlug, cpuHotPlug, nicHotPlug, nicHotUnPlug, ramHotPlug, ramHotPlug, nicHotPlug, nicHotUnPlug,
              creationTimestamp, modificationTimestamp, location);
   }

}
