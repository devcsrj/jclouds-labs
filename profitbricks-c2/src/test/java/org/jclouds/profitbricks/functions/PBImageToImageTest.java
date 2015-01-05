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

import org.jclouds.compute.domain.ImageBuilder;
import org.jclouds.compute.domain.OperatingSystem;
import org.jclouds.compute.domain.OsFamily;
import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.image.Image;
import org.jclouds.profitbricks.domain.image.ImageType;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapPhysicalLocation;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Unit test for the {@link PBImageToImage} class
 */
@Test(groups = "unit", testName = "PBImageToImageTest")
public class PBImageToImageTest {

   @Test
   public void testConvert() {
      Image image = Image.builder()
              .imageId("asdfghjkl")
              .imageName("random-os")
              .imageType(ImageType.HDD)
              .osType(OsType.LINUX)
              .writeable(true)
              .imageSize(2l)
              .location(Location.DE_FKB)
              .build();

      org.jclouds.compute.domain.Image expected = new ImageBuilder()
              .ids("asdfghjkl")
              .name("random-os")
              .operatingSystem(
                      new OperatingSystem.Builder()
                      .family(OsFamily.LINUX)
                      .is64Bit(true)
                      .name("random-os")
                      .description("LINUX")
                      .build())
              .status(org.jclouds.compute.domain.Image.Status.AVAILABLE)
              .location(mapPhysicalLocation(Location.DE_FKB))
              .build();

      PBImageToImage function = new PBImageToImage();
      assertEquals(function.apply(image), expected);

   }

}
