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
package org.jclouds.profitbricks.binders.image;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

import java.util.Map;

import org.jclouds.http.HttpRequest;
import org.jclouds.profitbricks.binders.BaseProfitBricksRequestBinder;
import org.jclouds.profitbricks.domain.image.setostype.ImageOsTypeRequest;

public class SetImageOsTypeRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "image";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request);

      Object obj = checkNotNull(postParams.get(PARAM));
      ImageOsTypeRequest os = ImageOsTypeRequest.class.cast(obj);

      return createRequest(request, generateRequestPayload(os));
   }

   private String generateRequestPayload(ImageOsTypeRequest os) {
      requestBuilder.append("<ws:setImageOsType>")
              .append("<request>")
              .append(format("<imageId>%s</imageId>", os.getImageId()))
              .append(format("<osType>%s</osType>", ifNotNull(os.getOsType())))
              .append("</request>")
              .append("</ws:setImageOsType>");

      return requestBuilder.toString();
   }
}
