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
package org.jclouds.profitbricks.domain.snapshot.create;

import static com.google.common.base.Preconditions.checkNotNull;

public class CreateSnapshotRequestBuilder {

   private String storageId;
   private String snapshotName;
   private String description;

   public CreateSnapshotRequestBuilder() {
   }

   /**
    * Identifier of the virtual storage for which a snapshot shall be created
    *
    * @param storageId
    * @return
    */
   public CreateSnapshotRequestBuilder storageId(String storageId) {
      this.storageId = checkStorageId(storageId);
      return this;
   }

   /**
    * Name of the snapshot to be created
    *
    * @param snapshotName
    * @return
    */
   public CreateSnapshotRequestBuilder snapshotName(String snapshotName) {
      this.snapshotName = snapshotName;
      return this;
   }

   /**
    * Additional field to provide customized information about the data in this snapshot
    *
    * @param description
    * @return
    */
   public CreateSnapshotRequestBuilder description(String description) {
      this.description = description;
      return this;
   }

   public CreateSnapshotRequestBuilder self() {
      return this;
   }

   public CreateSnapshotRequest build() {
      checkStorageId(storageId);
      return new CreateSnapshotRequest(storageId, description, snapshotName);
   }

   private String checkStorageId(String storageId) {
      return checkNotNull(storageId);
   }

}
