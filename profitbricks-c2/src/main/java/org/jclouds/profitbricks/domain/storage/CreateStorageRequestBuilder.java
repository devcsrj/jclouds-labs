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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jclouds.profitbricks.domain.storage.create.CreateStorageRequest;

public class CreateStorageRequestBuilder {

   protected String dataCenterId;
   protected String storageName;
   protected long size;
   protected String mountImageId;
   protected String profitBricksImagePassword;

   CreateStorageRequestBuilder() {
   }

   public CreateStorageRequestBuilder storageName(String name) {
      this.storageName = name;
      return self();
   }

   /**
    * Storage in GiB
    *
    * @param size
    * @return
    */
   public CreateStorageRequestBuilder size(long size) {
      this.size = checkSize(size);
      return self();
   }

   /**
    * Defines the data center wherein the storage is to be created. If left empty, the storage will be created in a new
    * data center
    *
    * @param dataCenterId
    * @return
    */
   public CreateStorageRequestBuilder dataCenterId(String dataCenterId) {
      this.dataCenterId = checkDataCenter(dataCenterId);
      return self();
   }

   /**
    * Specifies the HDD image to be assigned to the storage by its ID
    *
    * @param mountImageId
    * @return
    */
   public CreateStorageRequestBuilder mountImageId(String mountImageId) {
      this.mountImageId = mountImageId;
      return self();
   }

   /**
    * Sets the VM image root login password to the specified value. Only supported for generic Profitbricks HDD images.
    * User images are expected to be preconfigured with a password. If no password is supplied, one is automatically
    * created.
    *
    * @param profitBricksImagePassword Password must be between 8 and 50 characters, only a-z, A-Z, 0-9 without
    * characters i, I, l, o, O, w, W, y, Y, z, Z and 1, 0
    * @return
    */
   public CreateStorageRequestBuilder imagePassword(String profitBricksImagePassword) {
      this.profitBricksImagePassword = checkPassword(profitBricksImagePassword);
      return self();
   }

   public CreateStorageRequest build() {
      checkFields();
      return new CreateStorageRequest(dataCenterId, storageName, size, mountImageId, profitBricksImagePassword);
   }

   public CreateStorageRequestBuilder self() {
      return this;
   }

   void checkFields() {
      checkSize(size);
      checkPassword(profitBricksImagePassword);
      checkDataCenter(dataCenterId);
   }

   private long checkSize(long size) {
      checkNotNull(size);
      checkArgument(size >= 1);
      return size;
   }

   private String checkDataCenter(String dataCenterId) {
      return checkNotNull(dataCenterId);
   }

   private String checkPassword(String password) {
      if (password != null && !password.isEmpty()) {
         Matcher matcher = Pattern.compile("[A-Za-z2-9&&[^iIloOwWyYzZ]]{8,50}").matcher(password);
         checkArgument(matcher.matches(),
                 "Password must be between 8 to 50 characters, only a-z, A-Z, 0-9 without characters i, I, l, o, O, w, W, y, Y, z, Z and 1, 0");
      }
      return password;
   }
}
