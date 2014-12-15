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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.rest.ResourceNotFoundException;
import org.testng.annotations.Test;

@Test(groups = "live", testName = "DataCenterApiLiveTest")
public class DataCenterApiLiveTest extends BaseProfitBricksLiveTest {

   private String dcId;

   @Test
   public void testCreateDataCenter() {
      DataCenter dc = api.getDataCenterApi().createDataCenter(
	      DataCenter.Request.CreatePayload.create("JClouds", Location.DE_FKB)
      );

      assertNotNull(dc);
      dcWaitingPredicate.apply(dc.id());

      dcId = dc.id();
   }

   @Test(dependsOnMethods = "testCreateDataCenter")
   public void testGetDataCenter() {
      assertNotNull(dcId, "No available datacenter found.");

      DataCenter dataCenter = api.getDataCenterApi().getDataCenter(dcId);

      assertNotNull(dataCenter);
      assertEquals(dataCenter.id(), dcId);
   }

   @Test(dependsOnMethods = "testCreateDataCenter")
   public void testGetAllDataCenters() {
      List<DataCenter> dataCenters = api.getDataCenterApi().getAllDataCenters();

      assertNotNull(dataCenters);
      assertFalse(dataCenters.isEmpty(), "No datacenter found.");
   }

   @Test(dependsOnMethods = "testCreateDataCenter")
   public void testGetDataCenterState() {
      assertNotNull(dcId, "No available datacenter found.");

      ProvisioningState state = api.getDataCenterApi().getDataCenterState(dcId);

      assertNotNull(state);
   }

   // FIXME Fails. see ProfitBricksHttpErrorHandler line 42
   @Test(dependsOnMethods = "testGetDataCenter", expectedExceptions = ResourceNotFoundException.class)
   public void testDeleteDataCenter() {
      assertNotNull(dcId, "No available datacenter found.");

      api.getDataCenterApi().deleteDataCenter(dcId);

      api.getDataCenterApi().getDataCenter(dcId);
   }
}
