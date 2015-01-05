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
package org.jclouds.profitbricks;

import java.io.Closeable;

import org.jclouds.profitbricks.features.DataCenterApi;
import org.jclouds.profitbricks.features.FirewallApi;
import org.jclouds.profitbricks.features.ImageApi;
import org.jclouds.profitbricks.features.LoadBalancerApi;
import org.jclouds.profitbricks.features.NicApi;
import org.jclouds.profitbricks.features.PublicIpApi;
import org.jclouds.profitbricks.features.RomDriveApi;
import org.jclouds.profitbricks.features.ServerApi;
import org.jclouds.profitbricks.features.SnapshotApi;
import org.jclouds.profitbricks.features.StorageApi;
import org.jclouds.profitbricks.features.UserNotificationApi;
import org.jclouds.rest.annotations.Delegate;

/**
 * Provides access to ProfitBricks's Cloud Compute specific features.
 * <p/>
 * As for the current moment ProfitBricks has only SOAP based API and REST is coming soon. So, by the default all PB
 * communications are delegated to SOAP endpoints.
 *
 */
public interface ProfitBricksApi extends Closeable {

   @Delegate
   ServerApi getServersApi();

   @Delegate
   ImageApi getImageApi();

   @Delegate
   DataCenterApi getDataCenterApi();

   @Delegate
   StorageApi getStorageApi();

   @Delegate
   SnapshotApi getSnapshotApi();

   @Delegate
   UserNotificationApi getUserNotificationApi();

   @Delegate
   NicApi getNicApi();

   @Delegate
   PublicIpApi getPublicIpApi();

   @Delegate
   FirewallApi getFirewallApi();

   @Delegate
   LoadBalancerApi getLoadBalancerApi();

   @Delegate
   RomDriveApi getRomDriveApi();

}
