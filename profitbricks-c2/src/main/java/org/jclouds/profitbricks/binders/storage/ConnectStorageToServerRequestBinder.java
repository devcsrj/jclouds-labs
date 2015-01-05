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
package org.jclouds.profitbricks.binders.storage;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.binders.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.storage.connect.ConnectStorageRequest;

public class ConnectStorageToServerRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "storage";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request, "request");

      Object storageObj = checkNotNull(postParams.get(PARAM));
      ConnectStorageRequest storage = ConnectStorageRequest.class.cast(storageObj);

      return createRequest(request, generateRequestPayload(storage));
   }

   private String generateRequestPayload(ConnectStorageRequest storage) {
      requestBuilder.append("<ws:connectStorageToServer>")
              .append("<request>")
              .append(format("<serverId>%s</serverId>", storage.getServerId()))
              .append(format("<storageId>%s</storageId>", storage.getStorageId()))
              .append(ifNotEmpty("<busType>%s</busType>", storage.getBusType()))
              .append(ifNotEmpty("<deviceNumber>%d</deviceNumber>", storage.getDeviceNumber()))
              .append("</request>")
              .append("</ws:connectStorageToServer>");
      return requestBuilder.toString();
   }
}
