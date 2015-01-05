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
import org.jclouds.profitbricks.domain.storage.create.CreateStorageRequest;

public class CreateStorageRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "storage";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request, "request");

      Object storageObj = checkNotNull(postParams.get(PARAM));
      CreateStorageRequest storage = CreateStorageRequest.class.cast(storageObj);

      return createRequest(request, generateRequestPayload(storage));
   }

   private String generateRequestPayload(CreateStorageRequest storage) {
      requestBuilder.append("<ws:createStorage>")
              .append("<request>")
              .append(format("<dataCenterId>%s</dataCenterId>", storage.getDataCenterId()))
              .append(ifNotEmpty("<storageName>%s</storageName>", storage.getStorageName()))
              .append(format("<size>%d</size>", storage.getSize()))
              .append(ifNotEmpty("<mountImageId>%s</mountImageId>", storage.getMountImageId()))
              .append(ifNotEmpty("<profitBricksImagePassword>%s</profitBricksImagePassword>", storage.getProfitBricksImagePassword()))
              .append("</request>")
              .append("</ws:createStorage>");
      return requestBuilder.toString();
   }

}
