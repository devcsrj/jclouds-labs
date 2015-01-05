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
package org.jclouds.profitbricks.functions;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.valueOf;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapOS;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapPhysicalLocation;

import java.util.HashMap;
import java.util.Map;

import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.ImageBuilder;

import com.google.common.base.Function;

public class PBImageToImage implements Function<org.jclouds.profitbricks.domain.image.Image, Image> {

   @Override
   public Image apply(final org.jclouds.profitbricks.domain.image.Image i) {
      checkNotNull(i);

      return new ImageBuilder()
              .ids(i.getImageId())
              .name(i.getImageName())
              .description(i.getDescription())
              .operatingSystem(mapOS(i.getOsType()))
              .status(mapBackendStatus(i.isWriteable()))
              .userMetadata(buildImageMetadata(i))
              .location(mapPhysicalLocation(i.getLocation()))
              .build();
   }

   private Image.Status mapBackendStatus(Boolean writeable) {
      return writeable ? Image.Status.AVAILABLE : Image.Status.UNRECOGNIZED;
   }

   private Map<String, String> buildImageMetadata(final org.jclouds.profitbricks.domain.image.Image image) {
      return new HashMap<String, String>() {
         {
            put("size", valueOf(image.getImageSize() / 1024));
            put("cpuHotPlug", valueOf(image.isCpuHotPlug()));
            put("memoryRamHotPlug", valueOf(image.isRamHotPlug()));
            put("writeable", valueOf(image.isWriteable()));
            put("imageType", image.getImageType().toString());
         }
      };
   }

}
