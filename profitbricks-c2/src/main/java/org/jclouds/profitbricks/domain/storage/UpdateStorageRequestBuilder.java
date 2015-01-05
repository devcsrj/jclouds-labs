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
package org.jclouds.profitbricks.domain.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.storage.update.UpdateStorageRequest;

public class UpdateStorageRequestBuilder {

   protected String storageId;
   protected Long size;
   protected String storageName;
   protected String mountImageId;

   UpdateStorageRequestBuilder() {
   }

   public UpdateStorageRequestBuilder storageId(String storageId) {
      this.storageId = storageId;
      checkStorageId();
      return self();
   }

   public UpdateStorageRequestBuilder size(Long size) {
      this.size = size;
      checkSize();
      return self();
   }

   public UpdateStorageRequestBuilder mountImageId(String mountImageId) {
      this.mountImageId = mountImageId;
      return self();
   }

   public UpdateStorageRequest build() {
      checkFields();
      return new UpdateStorageRequest(storageId, size, storageName, mountImageId);
   }

   public UpdateStorageRequestBuilder self() {
      return this;
   }

   private void checkStorageId() {
      checkNotNull(storageId);
   }

   void checkFields() {
      checkSize();
      checkStorageId();
   }

   void checkSize() {
      checkNotNull(size);
      checkArgument(size >= 1);
   }
}
