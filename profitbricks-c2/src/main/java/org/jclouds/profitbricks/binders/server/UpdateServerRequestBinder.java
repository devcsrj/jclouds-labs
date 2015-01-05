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
package org.jclouds.profitbricks.binders.server;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.domain.server.update.UpdateServerRequest;

public class UpdateServerRequestBinder extends CreateServerRequestBinder {

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request, "request");

      Object serverObj = checkNotNull(postParams.get(PARAM));
      UpdateServerRequest server = UpdateServerRequest.class.cast(serverObj);

      return createRequest(request, generateRequestPayload(server));
   }

   private String generateRequestPayload(UpdateServerRequest server) {
      requestBuilder.append("<ws:updateServer>").
              append("<request>").
              append(format("<serverId>%s</serverId>", server.getServerId())).
              append(ifNotEmpty("<cores>%d</cores>", server.getCores())).
              append(ifNotEmpty("<ram>%d</ram>", server.getRam())).
              append(ifNotEmpty("<serverName>%s</serverName>", server.getServerName())).
              append(ifNotEmpty("<bootFromStorageId>%s</bootFromStorageId>", server.getBootFromStorageId())).
              append(ifNotEmpty("<bootFromImageId>%s</bootFromImageId>", server.getBootFromImageId())).
              append(ifNotEmpty("<osType>%s</osType>", ifNotNull(server.getOsType()))).
              append(ifNotEmpty("<availabilityZone>%s</availabilityZone>", ifNotNull(server.getAvailabilityZone()))).
              append(ifNotEmpty("<cpuHotPlug>%b</cpuHotPlug>", server.isCpuHotPlug())).
              append(ifNotEmpty("<ramHotPlug>%b</ramHotPlug>", server.isRamHotPlug())).
              append(ifNotEmpty("<nicHotPlug>%b</nicHotPlug>", server.isNicHotPlug())).
              append(ifNotEmpty("<nicHotUnPlug>%b</nicHotUnPlug>", server.isNicHotUnPlug())).
              append(ifNotEmpty("<discVirtioHotPlug>%b</discVirtioHotPlug>", server.isDiscVirtioHotPlug())).
              append(ifNotEmpty("<discVirtioHotUnPlug>%b</discVirtioHotUnPlug>", server.isDiscVirtioHotUnPlug())).
              append("</request>").
              append("</ws:updateServer>");
      return requestBuilder.toString();
   }
}
