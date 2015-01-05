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

import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.HardwareBuilder;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.ImageBuilder;
import org.jclouds.compute.domain.OperatingSystem;
import org.jclouds.compute.domain.OsFamily;
import org.jclouds.compute.domain.Processor;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.internal.TemplateImpl;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequest;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Unit test for {@link TemplateToNewServer} class
 */
@Test(groups = "unit", testName = "TemplateToNewServerTest")
public class TemplateToNewServerTest {

   @Test
   public void testConvert() {
      Image image = new ImageBuilder()
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
              .build();
      Hardware hardware = new HardwareBuilder()
              .ids("hardware111")
              .name("super")
              .ram(2048)
              .processor(new Processor(2, 0))
              .build();
      Location location = new LocationBuilder()
              .id("qazwsxedc1234567890")
              .description("qazwsxedc1234567890")
              .scope(LocationScope.REGION)
              .build();

      Template template = new TemplateImpl(image, hardware, location, TemplateOptions.NONE);

      CreateServerRequest server = Server.creationBuilder()
              .dataCenterId("qazwsxedc1234567890")
              .serverName("super")
              .cores(2)
              .ram(2048)
              .internetAccess(true)
              .availabilityZone(AvailabilityZone.AUTO)
              .osType(OsType.LINUX)
              .build();

      TemplateToNewServer function = new TemplateToNewServer();
      assertEquals(function.apply(template), server);
   }
}
