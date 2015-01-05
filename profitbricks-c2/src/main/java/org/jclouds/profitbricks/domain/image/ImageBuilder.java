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
package org.jclouds.profitbricks.domain.image;

import java.util.List;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;

public class ImageBuilder {

   private Boolean bootable;
   private Boolean cpuHotPlug;
   private Boolean cpuHotUnPlug;
   private String description;
   private Boolean discVirtioHotPlug;
   private Boolean discVirtioHotUnPlug;
   private String imageId;
   private String imageName;
   private Long imageSize;
   private ImageType imageType;
   private Location location;
   private Boolean nicHotPlug;
   private Boolean nicHotUnPlug;
   private OsType osType;
   private Boolean _public;
   private Boolean ramHotPlug;
   private Boolean ramHotUnPlug;
   private List<String> serverIds;
   private Boolean writeable;

   public ImageBuilder() {
   }

   public ImageBuilder bootable(Boolean bootable) {
      this.bootable = bootable;
      return this;
   }

   public ImageBuilder cpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
      return this;
   }

   public ImageBuilder cpuHotUnPlug(Boolean cpuHotUnPlug) {
      this.cpuHotUnPlug = cpuHotUnPlug;
      return this;
   }

   public ImageBuilder description(String description) {
      this.description = description;
      return this;
   }

   public ImageBuilder discVirtioHotPlug(Boolean discVirtioHotPlug) {
      this.discVirtioHotPlug = discVirtioHotPlug;
      return this;
   }

   public ImageBuilder discVirtioHotUnPlug(Boolean discVirtioHotUnPlug) {
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      return this;
   }

   public ImageBuilder imageId(String imageId) {
      this.imageId = imageId;
      return this;
   }

   public ImageBuilder imageName(String imageName) {
      this.imageName = imageName;
      return this;
   }

   public ImageBuilder imageSize(Long imageSize) {
      this.imageSize = imageSize;
      return this;
   }

   public ImageBuilder imageType(ImageType imageType) {
      this.imageType = imageType;
      return this;
   }

   public ImageBuilder location(Location location) {
      this.location = location;
      return this;
   }

   public ImageBuilder nicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
      return this;
   }

   public ImageBuilder micHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
      return this;
   }

   public ImageBuilder osType(OsType osType) {
      this.osType = osType;
      return this;
   }

   public ImageBuilder isPublic(Boolean _public) {
      this._public = _public;
      return this;
   }

   public ImageBuilder ramHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
      return this;
   }

   public ImageBuilder ramHotUnPlug(Boolean ramHotUnPlug) {
      this.ramHotUnPlug = ramHotUnPlug;
      return this;
   }

   public ImageBuilder serverIds(List<String> serverIds) {
      this.serverIds = serverIds;
      return this;
   }

   public ImageBuilder writeable(Boolean writeable) {
      this.writeable = writeable;
      return this;
   }

   public Image build() {
      return new Image(bootable, cpuHotPlug, cpuHotUnPlug, description, discVirtioHotPlug, discVirtioHotUnPlug,
              imageId, imageName, imageSize, imageType, location, nicHotPlug, nicHotUnPlug, osType, _public,
              ramHotPlug, ramHotUnPlug, serverIds, writeable);
   }

}
