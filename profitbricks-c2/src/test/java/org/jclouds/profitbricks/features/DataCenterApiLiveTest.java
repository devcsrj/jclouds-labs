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
import java.util.concurrent.TimeUnit;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.datacenter.DataCenter;
import org.jclouds.profitbricks.domain.datacenter.DataCenterIdentifier;
import org.jclouds.profitbricks.domain.datacenter.create.CreateDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.get.GetDataCenterResponse;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.util.Predicates2;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 * Test for the {@link DataCenterApi} class
 */
@Test(groups = "live", testName = "DataCenterApiLiveTest")
public class DataCenterApiLiveTest extends BaseProfitBricksLiveTest {

   String vdcId;

   @Override
   protected void initialize() {
      super.initialize();
      this.vdcWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.DATACENTER), 2l * 60l, 2l, TimeUnit.SECONDS);
   }

   @Test
   public void testCreateDataCenter() {
      CreateDataCenterResponse response = api.getDataCenterApi().createDataCenter(
              DataCenter.creatingBuilder()
              .dataCenterName("Random DC")
              .location(Location.US_LAS)
              .build());
      assertNotNull(response);
      vdcId = response.getReturn().getDataCenterId();
   }

   @Test(expectedExceptions = IllegalArgumentException.class)
   public void testCreateDataCenterExceptionOnInvalidName() {
      CreateDataCenterResponse response = api.getDataCenterApi().createDataCenter(
              DataCenter.creatingBuilder()
              .dataCenterName("R@ndom DC")
              .location(Location.DE_FKB)
              .build());
   }

   @Test(dependsOnMethods = "testCreateDataCenter")
   public void testGetDataCenter() {
      GetDataCenterResponse dataCenter = api.getDataCenterApi().getDataCenter(vdcId);

      assertNotNull(dataCenter);
   }

   @Test(dependsOnMethods = "testCreateDataCenter")
   public void testGetAllDataCenters() {
      vdcWaitingPredicate.apply(vdcId);
      List<DataCenterIdentifier> vdcs = api.getDataCenterApi().getAllDataCenters().getReturn();

      assertFalse(vdcs.isEmpty(), "No VDC found.");
   }

   @Test(dependsOnMethods = "testGetDataCenter")
   public void testClearDataCenter() {
      vdcWaitingPredicate.apply(vdcId);
      ProvisioningState state = api.getDataCenterApi().getDataCenterState(vdcId).getReturn();
      if (state == ProvisioningState.AVAILABLE) {
         VersionResponse response = api.getDataCenterApi().clearDataCenter(vdcId).getReturn();

         assertNotNull(response);
      } else
         assertTrue(false, "Data center was not available before 'Clear' test.");

   }

   @Test(dependsOnMethods = "testClearDataCenter")
   public void testDeleteDataCenter() {
      vdcWaitingPredicate.apply(vdcId);
      ProvisioningState state = api.getDataCenterApi().getDataCenterState(vdcId).getReturn();
      if (state == ProvisioningState.AVAILABLE) {
         String requestId = api.getDataCenterApi().deleteDataCenter(vdcId).getReturn().getRequestId();

         assertNotNull(requestId);
      } else
         assertTrue(false, "Data center was not available before 'Delete' test.");
   }
}
