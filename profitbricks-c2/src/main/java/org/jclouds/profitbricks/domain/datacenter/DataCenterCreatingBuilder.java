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
package org.jclouds.profitbricks.domain.datacenter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.datacenter.create.CreateDataCenterRequest;

public class DataCenterCreatingBuilder {

   protected String dataCenterName;
   protected Location location;

   DataCenterCreatingBuilder() {
   }

   public DataCenterCreatingBuilder location(Location location) {
      this.location = checkLocation(location);
      return this;

   }

   public DataCenterCreatingBuilder dataCenterName(String dataCenterName) {
      this.dataCenterName = checkDataCenterName(dataCenterName);
      return this;
   }

   public CreateDataCenterRequest build() {
      checkFields();
      return new CreateDataCenterRequest(dataCenterName, location);
   }

   private void checkFields() {
      checkLocation(location);
      checkDataCenterName(dataCenterName);
   }

   private Location checkLocation(Location location) {
      checkNotNull(location);
      checkArgument(location != Location.UNRECOGNIZED);
      return location;
   }

   private String checkDataCenterName(String name) {
      checkNotNull(name);
      checkArgument(
              !(name.contains("@") || name.contains("/")
              || name.contains("\\") || name.contains("|")
              || name.contains("'") || name.contains("`")),
              "Data center names cannot start with or contain (@, /, \\, |, ‘’, ‘)");
      return name;
   }
}
