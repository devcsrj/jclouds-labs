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
package org.jclouds.profitbricks.features;

import java.util.List;
import org.jclouds.profitbricks.domain.image.Image;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.rest.ResourceNotFoundException;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * Test for the {@link ImageApi} class
 */
@Test(groups = "live", testName = "ImageApiLiveTest")
public class ImageApiLiveTest extends BaseProfitBricksLiveTest {

   String imageId;

   @Test
   public void testGetAllImages() {
      List<Image> images = api.getImageApi().getAllImages().getReturn();

      assertTrue(images.size() > 1, "Provider must atleast have one available image.");

      for (Image image : images) {
         this.imageId = image.getImageId();
         break;
      }
   }

   @Test(dependsOnMethods = "testGetAllImages")
   public void testGetImage() {
      Image image = api.getImageApi().getImage(imageId).getReturn();

      assertNotNull(image, "Image with id '" + imageId + "' must not be null.");
   }

   @Test(expectedExceptions = ResourceNotFoundException.class)
   public void testGetNonExistingImage() {
      api.getImageApi().getImage("some-random-none-existing-image-id");
   }
}
