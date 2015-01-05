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

import org.jclouds.profitbricks.domain.ProvisioningState;

public class StorageBuilder {

   protected String storageId;
   protected Long size;
   protected String storageName;
   protected ProvisioningState provisioningState;

   StorageBuilder() {
   }

   /**
    *
    * @param storageId Identifier of the virtual storage
    * @return
    */
   public StorageBuilder storageId(String storageId) {
      this.storageId = storageId;
      return self();
   }

   /**
    *
    * @param size Storage size (in GiB)
    * @return
    */
   public StorageBuilder size(Long size) {
      this.size = size;
      return self();
   }

   public StorageBuilder storageName(String storageName) {
      this.storageName = storageName;
      return self();
   }

   /**
    * Current provisioning state of the specified virtual storage (INACTIVE, INPROCESS, AVAILABLE, DELETED, ERROR)
    *
    * @param provisioningState
    * @return
    */
   public StorageBuilder provisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
      return self();
   }

   public StorageBuilder self() {
      return this;
   }

   public Storage build() {
      return new Storage(storageId, size, storageName, null, null, provisioningState, null, null);
   }
}
