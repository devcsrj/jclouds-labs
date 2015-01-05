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
package org.jclouds.profitbricks.domain.image.update;

import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.OsType;

public class UpdateImageRequestBuilder {

   private String imageId;
   private String imageName;
   private String description;
   private OsType osType;
   private Boolean cpuHotPlug;
   private Boolean cpuHotUnPlug;
   private Boolean ramHotPlug;
   private Boolean ramHotUnPlug;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;
   private Boolean discVirtioHotPlug;
   private Boolean discVirtioHotUnPlug;
   private Boolean bootable;

   private String checkImageId(String imageId) {
      return checkNotNull(imageId);
   }

   private String checkImageName(String imageName) {
      return checkNotNull(imageName);
   }

   private void checkFields() {
      checkImageId(imageId);
      checkImageName(imageName);
   }

   public UpdateImageRequestBuilder() {
   }

   public UpdateImageRequestBuilder imageId(String imageId) {
      this.imageId = checkImageId(imageId);
      return this;
   }

   public UpdateImageRequestBuilder imageName(String imageName) {
      this.imageName = checkImageName(imageName);
      return this;
   }

   public UpdateImageRequestBuilder description(String description) {
      this.description = description;
      return this;
   }

   public UpdateImageRequestBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public UpdateImageRequestBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public UpdateImageRequestBuilder cpuHotUnPlug(Boolean cpuHotUnPlug) {
      this.cpuHotUnPlug = cpuHotUnPlug;
      return this;
   }

   public UpdateImageRequestBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public UpdateImageRequestBuilder ramHotUnPlug(Boolean ramHotUnPlug) {
      this.ramHotUnPlug = ramHotUnPlug;
      return this;
   }

   public UpdateImageRequestBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public UpdateImageRequestBuilder nicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public UpdateImageRequestBuilder discVirtioHotPlug(Boolean discVirtioHotPlug) {
      this.discVirtioHotPlug = discVirtioHotPlug;
      return this;
   }

   public UpdateImageRequestBuilder discVirtioHotUnPlug(Boolean discVirtioHotUnPlug) {
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      return this;
   }

   public UpdateImageRequestBuilder setBootable(Boolean bootable) {
      this.bootable = bootable;
      return this;
   }

   public UpdateImageRequest build() {
      checkFields();
      return new UpdateImageRequest(imageId, imageName, description, osType, cpuHotPlug, cpuHotUnPlug, ramHotPlug,
              ramHotUnPlug, nicHotPlug, nicHotUnPlug, discVirtioHotPlug, discVirtioHotUnPlug, bootable);
   }

}
