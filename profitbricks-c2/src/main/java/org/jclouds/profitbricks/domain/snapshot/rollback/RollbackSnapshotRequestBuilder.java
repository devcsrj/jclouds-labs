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
package org.jclouds.profitbricks.domain.snapshot.rollback;

import static com.google.common.base.Preconditions.checkNotNull;

public class RollbackSnapshotRequestBuilder {

   private String storageId;
   private String snapshotId;

   public RollbackSnapshotRequestBuilder() {
   }

   public RollbackSnapshotRequestBuilder storageId(String storageId) {
      this.storageId = checkStorageId(storageId);
      return this;
   }

   public RollbackSnapshotRequestBuilder snapshotId(String snapshotId) {
      this.snapshotId = checkSnapshotId(snapshotId);
      return this;
   }

   public RollbackSnapshotRequest build() {
      checkFields();
      return new RollbackSnapshotRequest(storageId, snapshotId);
   }

   private void checkFields() {
      checkSnapshotId(snapshotId);
      checkStorageId(storageId);
   }

   private String checkStorageId(String storageId) {
      return checkNotNull(storageId);
   }

   private String checkSnapshotId(String snapshotId) {
      return checkNotNull(snapshotId);
   }

}
