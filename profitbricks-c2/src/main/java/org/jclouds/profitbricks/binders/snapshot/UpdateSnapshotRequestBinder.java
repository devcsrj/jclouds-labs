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
package org.jclouds.profitbricks.binders.snapshot;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.domain.snapshot.update.UpdateSnapshotRequest;

public class UpdateSnapshotRequestBinder extends CreateSnapshotRequestBinder {

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request, "request");

      Object storageObj = checkNotNull(postParams.get(PARAM));
      UpdateSnapshotRequest storage = UpdateSnapshotRequest.class.cast(storageObj);

      return createRequest(request, generateRequestPayload(storage));
   }

   private String generateRequestPayload(UpdateSnapshotRequest snapshot) {
      requestBuilder.append("<ws:updateSnapshot>")
              .append("<request>")
              .append(format("<snapshotId>%s</snapshotId>", snapshot.getSnapshotId()))
              .append(ifNotEmpty("<description>%s</description>", snapshot.getDescription()))
              .append(ifNotEmpty("<snapshotName>%s</snapshotName>", snapshot.getSnapshotName()))
              .append(ifNotEmpty("<osType>%s</osType>", snapshot.getOsType()))
              .append(ifNotEmpty("<cpuHotPlug>%b</cpuHotPlug>", snapshot.isCpuHotPlug()))
              .append(ifNotEmpty("<ramHotPlug>%b</ramHotPlug>", snapshot.isRamHotPlug()))
              .append(ifNotEmpty("<nicHotPlug>%b</nicHotPlug>", snapshot.isNicHotPlug()))
              .append(ifNotEmpty("<nicHotUnPlug>%b</nicHotUnPlug>", snapshot.isNicHotUnPlug()))
              .append("</request>")
              .append("</ws:updateSnapshot>");
      return requestBuilder.toString();
   }
}
