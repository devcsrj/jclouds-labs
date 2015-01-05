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
package org.jclouds.profitbricks.domain.publicip.reserve;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.Location;

public class CreateReservePublicIpBlockRequestBuilder {

   private int blockSize;
   private Location location;

   public CreateReservePublicIpBlockRequestBuilder() {
   }

   public CreateReservePublicIpBlockRequestBuilder blockSize(int blockSize) {
      this.blockSize = checkBlockSize(blockSize);
      return this;
   }

   public CreateReservePublicIpBlockRequestBuilder setLocation(Location location) {
      this.location = checkLocation(location);
      return this;
   }

   public CreateReservePublicIpBlockRequest build() {
      checkFields();
      return new CreateReservePublicIpBlockRequest(blockSize, location);
   }

   private void checkFields() {
      checkLocation(location);
      checkBlockSize(blockSize);
   }

   private Location checkLocation(Location location) {
      return checkNotNull(location);
   }

   private int checkBlockSize(int blockSize) {
      checkArgument(blockSize > 0);
      return blockSize;
   }

}
