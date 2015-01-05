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
import org.jclouds.profitbricks.domain.image.update.UpdateImageRequest;

public class UpdateImageRequestBinder extends BaseProfitBricksRequestBinder {

   protected final String PARAM = "image";

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Map<String, Object> postParams) {
      checkNotNull(request);

      Object obj = checkNotNull(postParams.get(PARAM));
      UpdateImageRequest image = UpdateImageRequest.class.cast(obj);

      return createRequest(request, generateRequestPayload(image));
   }

   private String generateRequestPayload(UpdateImageRequest image) {
      requestBuilder.append("<ws:updateImage>").
              append("<request>").
              append(format("<imageId>%s</imageId>", image.getImageId())).
              append(format("<imageName>%s</imageName>", image.getImageName())).
              append(ifNotEmpty("<description>%s</description>", image.getDescription())).
              append(ifNotEmpty("<osType>%s</osType>", ifNotNull(image.getOsType()))).
              append(ifNotEmpty("<cpuHotPlug>%b</cpuHotPlug>", image.isCpuHotPlug())).
              append(ifNotEmpty("<ramHotPlug>%b</ramHotPlug>", image.isRamHotPlug())).
              append(ifNotEmpty("<nicHotPlug>%b</nicHotPlug>", image.isNicHotPlug())).
              append(ifNotEmpty("<nicHotUnPlug>%b</nicHotUnPlug>", image.isNicHotUnPlug())).
              append(ifNotEmpty("<discVirtioHotPlug>%b</discVirtioHotPlug>", image.isDiscVirtioHotPlug())).
              append(ifNotEmpty("<discVirtioHotUnPlug>%b</discVirtioHotUnPlug>", image.isDiscVirtioHotUnPlug())).
              append("</request>").
              append("</ws:updateImage>");

      return requestBuilder.toString();
   }
}
