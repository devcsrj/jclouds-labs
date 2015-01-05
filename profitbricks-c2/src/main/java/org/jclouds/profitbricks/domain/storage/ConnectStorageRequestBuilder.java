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

import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.storage.connect.ConnectStorageRequest;

public class ConnectStorageRequestBuilder {

   protected String serverId;
   protected String storageId;
   protected BusType busType;
   protected Integer deviceNumber;

   public ConnectStorageRequestBuilder busType(BusType busType) {
      this.busType = busType;
      return self();
   }

   public ConnectStorageRequestBuilder deviceNumber(Integer deviceNumber) {
      this.deviceNumber = deviceNumber;
      return self();

   }

   public ConnectStorageRequestBuilder serverId(String serverId) {
      this.serverId = serverId;
      checkServerId();
      return self();

   }

   public ConnectStorageRequestBuilder storageId(String storageId) {
      this.storageId = storageId;
      checkStorageId();
      return self();
   }

   public ConnectStorageRequestBuilder self() {
      return this;
   }

   public ConnectStorageRequest build() {
      checkServerId();
      checkStorageId();
      return new ConnectStorageRequest(serverId, storageId, busType, deviceNumber);
   }

   private void checkServerId() {
      checkNotNull(serverId);
   }

   private void checkStorageId() {
      checkNotNull(storageId);
   }
}
