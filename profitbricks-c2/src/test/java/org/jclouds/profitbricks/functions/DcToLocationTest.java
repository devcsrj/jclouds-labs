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

import java.util.HashMap;
import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;
import org.jclouds.profitbricks.domain.datacenter.DataCenter;
import org.jclouds.profitbricks.domain.ProvisioningState;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapPhysicalLocation;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Unit test for {@link DcToLocation} class
 */
@Test(groups = "unit", testName = "DcToLocationTest")
public class DcToLocationTest {

   @Test
   public void testConvert() {
      DataCenter vdc = DataCenter.builder()
              .dataCenterId("qazwsxedc1234567890")
              .dataCenterName("Test DC")
              .provisioningState(ProvisioningState.AVAILABLE)
              .dataCenterVersion(1)
              .location(org.jclouds.profitbricks.domain.Location.US_LAS)
              .build();

      Location location = new LocationBuilder()
              .id("qazwsxedc1234567890")
              .description("TestDC")
              .metadata(new HashMap<String, Object>() {
                 {
                    put("dataCenterVersion", 1);
                 }
              })
              .scope(LocationScope.REGION)
              .parent(mapPhysicalLocation(org.jclouds.profitbricks.domain.Location.US_LAS))
              .build();

      DcToLocation function = new DcToLocation();
      assertEquals(function.apply(vdc), location);
   }
}
