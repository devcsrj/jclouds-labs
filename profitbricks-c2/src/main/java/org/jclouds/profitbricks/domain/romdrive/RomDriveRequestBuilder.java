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
package org.jclouds.profitbricks.domain.romdrive;

import static com.google.common.base.Preconditions.checkNotNull;

public class RomDriveRequestBuilder {

   private String imageId;
   private String serverId;
   private Integer deviceNumber;

   public RomDriveRequestBuilder() {
   }

   public RomDriveRequestBuilder imageId(String imageId) {
      this.imageId = checkImageId(imageId);
      return this;
   }

   public RomDriveRequestBuilder serverId(String serverId) {
      this.serverId = checkServerId(serverId);
      return this;
   }

   public RomDriveRequestBuilder setDeviceNumber(Integer deviceNumber) {
      this.deviceNumber = deviceNumber;
      return this;
   }

   public RomDriveRequest build() {
      checkFields();
      return new RomDriveRequest(imageId, serverId, deviceNumber);
   }

   private void checkFields() {
      checkImageId(imageId);
      checkServerId(serverId);
   }

   private String checkImageId(String imageId) {
      return checkNotNull(imageId);
   }

   private String checkServerId(String serverId) {
      return checkNotNull(serverId);
   }
}
