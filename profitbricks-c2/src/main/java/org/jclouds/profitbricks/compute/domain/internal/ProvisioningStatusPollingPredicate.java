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
package org.jclouds.profitbricks.compute.domain.internal;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware.DATACENTER;
import static org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware.SERVER;
import static org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware.SNAPSHOT;
import static org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware.STORAGE;
import static org.jclouds.profitbricks.domain.ProvisioningState.AVAILABLE;

import org.jclouds.profitbricks.ProfitBricksApi;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.util.Predicates2;

import com.google.common.base.Predicate;

/**
 * Used via {@link Predicates2#retry} for intentionally waiting a provisioned virtual item to be 'AVAILABLE' before
 * performing an action on. Performing an action to an unavailable virtual item causes the virtual data center be locked
 * out from further API calls.
 */
public class ProvisioningStatusPollingPredicate implements Predicate<String> {

   private final ProfitBricksApi api;
   private final ProvisioningStatusAware domain;
   private final ProvisioningState expect;

   public ProvisioningStatusPollingPredicate(ProfitBricksApi api, ProvisioningStatusAware domain) {
      this(api, domain, AVAILABLE);
   }

   public ProvisioningStatusPollingPredicate(ProfitBricksApi api, ProvisioningStatusAware domain, ProvisioningState expect) {
      this.api = checkNotNull(api);
      this.domain = checkNotNull(domain);
      this.expect = checkNotNull(expect);
   }

   @Override
   public boolean apply(String input) {
      checkNotNull(input);
      switch (domain) {
         case SERVER:
            return expect == api.getServersApi().getServer(input).getReturn().getProvisioningState();
         case STORAGE:
            return expect == api.getStorageApi().getStorage(input).getReturn().getProvisioningState();
         case SNAPSHOT:
            return expect == api.getSnapshotApi().getSnapshot(input).getReturn().getProvisioningState();
         case DATACENTER:
            return expect == api.getDataCenterApi().getDataCenterState(input).getReturn();
         case NIC:
            return expect == api.getNicApi().getNic(input).getReturn().getProvisioningState();
         default:
            throw new IllegalArgumentException("Domain '" + domain + "' does not contain property 'ProvisioningState'.");
      }
   }

}
