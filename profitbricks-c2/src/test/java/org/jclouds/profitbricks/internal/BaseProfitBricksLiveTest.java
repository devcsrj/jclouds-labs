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
package org.jclouds.profitbricks.internal;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jclouds.apis.BaseApiLiveTest;
import org.jclouds.profitbricks.ProfitBricksApi;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.datacenter.DataCenterIdentifier;
import org.jclouds.util.Predicates2;

/**
 *
 * Base class for ProfitBricks live tests
 */
public class BaseProfitBricksLiveTest extends BaseApiLiveTest<ProfitBricksApi> {

   protected DataCenterIdentifier vdc;
   protected Predicate<String> vdcWaitingPredicate;

   public BaseProfitBricksLiveTest() {
      provider = "profitbricks";
   }

   protected void initializeVDC() {
      if (vdc != null)
         return;
      List<DataCenterIdentifier> dataCenters = api.getDataCenterApi().getAllDataCenters().getReturn();
      for (DataCenterIdentifier vdc : dataCenters) {
         this.vdc = vdc;
         break;
      }
      this.vdcWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.DATACENTER), 2l * 60l, 2l, TimeUnit.SECONDS);
   }
}
