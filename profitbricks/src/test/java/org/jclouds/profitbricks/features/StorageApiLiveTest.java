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

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.compute.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.util.Predicates2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@Test( groups = "live", testName = "StorageApiLiveTest", singleThreaded = true )
public class StorageApiLiveTest extends BaseProfitBricksLiveTest {

   private Predicate<String> waitUntilAvailable;
   private DataCenter dataCenter;
   private String createdStorageId;

   @Override
   protected void initialize() {
      super.initialize();
      List<DataCenter> dataCenters = api.dataCenterApi().getAllDataCenters();
      assertFalse( dataCenters.isEmpty(), "Must atleast have 1 datacenter available for storage testing." );

      this.dataCenter = Iterables.getFirst( dataCenters, null );

      this.waitUntilAvailable = Predicates2.retry(
              new ProvisioningStatusPollingPredicate( api, ProvisioningStatusAware.STORAGE, ProvisioningState.AVAILABLE ),
              2l * 60l, 2l, TimeUnit.SECONDS );
   }

   @AfterClass( alwaysRun = true )
   public void testDeleteStorage() {
      if ( createdStorageId != null ) {
         boolean result = api.storageApi().deleteStorage( createdStorageId );

         assertTrue( result, "Created test storage was not delete." );
      }
   }
}
