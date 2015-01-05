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
package org.jclouds.profitbricks.binders.datacenter;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.binders.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.datacenter.create.CreateDataCenterRequest;

public class CreateDataCenterRequestBinder extends BaseProfitBricksRequestBinder {

   private final String PARAM = "datacenter";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request, "request");

      Object vdcObj = checkNotNull(postParams.get(PARAM));
      CreateDataCenterRequest vdc = CreateDataCenterRequest.class.cast(vdcObj);

      return createRequest(request, generateRequestPayload(vdc));
   }

   private String generateRequestPayload(CreateDataCenterRequest vdc) {
      requestBuilder.append("<ws:createDataCenter>")
              .append("<request>")
              .append(format("<dataCenterName>%s</dataCenterName>", vdc.getDataCenterName()))
              .append(format("<location>%s</location>", vdc.getLocation().value()))
              .append("</request>")
              .append("</ws:createDataCenter>");
      return requestBuilder.toString();
   }
}
