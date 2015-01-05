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

import com.google.common.base.Predicate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusAware;
import org.jclouds.profitbricks.compute.domain.internal.ProvisioningStatusPollingPredicate;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.rest.InsufficientResourcesException;
import org.jclouds.rest.ResourceNotFoundException;
import org.jclouds.util.Predicates2;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

/**
 *
 * Test for the {@link ServerApi} class
 */
@Test(groups = "live", testName = "ServerApiLiveTest")
public class ServerApiLiveTest extends BaseProfitBricksLiveTest {

   Predicate<String> serverWaitingPredicate;
   String serverId;

   @Override
   protected void initialize() {
      super.initialize();
      initializeVDC();
      this.serverWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.SERVER), 2l * 60l, 2l, TimeUnit.SECONDS);
   }

   @Test
   public void testCreateServer() {
      assertNotNull(vdc);
      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      serverId = api.getServersApi().createServer(Server.creationBuilder()
              .serverName("Test Server")
              .ram(1024)
              .cores(1)
              .dataCenterId(vdc.getDataCenterId())
              .build()).getReturn().getServerId();

      assertNotNull(serverId);
   }

   @Test(expectedExceptions = ResourceNotFoundException.class)
   public void testGetNonExistingServer() {
      api.getServersApi().getServer("some-random-non-existing-server");
   }

   @Test(expectedExceptions = InsufficientResourcesException.class)
   public void testCreateUberServer() {
      api.getServersApi().createServer(Server.creationBuilder()
              .serverName("Uber Server")
              .ram(1024)
              .cores(10000)
              .dataCenterId(vdc.getDataCenterId())
              .build()).getReturn().getServerId();
   }

   @Test(dependsOnMethods = {"testCreateServer"})
   public void testGetServer() {
      Server server = api.getServersApi().getServer(serverId).getReturn();

      assertNotNull(server);
   }

   @Test(alwaysRun = true, dependsOnMethods = {"testGetServer"})
   public void testGetAllServers() {
      serverWaitingPredicate.apply(serverId);
      List<Server> allServers = api.getServersApi().getAllServers().getReturn();

      assertFalse(allServers.isEmpty(), "Server list should not be empty.");
   }

   @Test(dependsOnMethods = "testGetServer")
   public void testStopServer() {
      serverWaitingPredicate.apply(serverId);
      Server server = api.getServersApi().getServer(serverId).getReturn();
      assertTrue(server.getProvisioningState() == ProvisioningState.AVAILABLE,
              "Server was not available before 'Stop' test.");

      String requestId = api.getServersApi().stopServer(serverId).getReturn().getRequestId();
      assertNotNull(requestId, "Request Id must not be null.");
   }

   @Test(dependsOnMethods = "testStopServer")
   public void testStartServer() {
      Predicate<String> serverShutdownWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.SERVER, ProvisioningState.INACTIVE), 2l * 60l, 2l, TimeUnit.SECONDS);
      serverShutdownWaitingPredicate.apply(serverId);
      Server server = api.getServersApi().getServer(serverId).getReturn();
      assertTrue(server.getProvisioningState() == ProvisioningState.INACTIVE,
              "Server was at '" + server.getProvisioningState() + "' state before 'Start' test.");

      vdcWaitingPredicate.apply(server.getDataCenterId());
      String requestId = api.getServersApi().startServer(serverId).getReturn().getRequestId();
      assertNotNull(requestId, "Request Id must not be null.");

   }

   @Test(dependsOnMethods = {"testStartServer"})
   public void testDeleteServer() {
      serverWaitingPredicate.apply(serverId);
      Server server = api.getServersApi().getServer(serverId).getReturn();
      assertTrue(server.getProvisioningState() == ProvisioningState.AVAILABLE,
              "Server was not available before 'Delete' test.");

      vdcWaitingPredicate.apply(server.getDataCenterId());
      VersionResponse response = api.getServersApi().deleteServer(serverId).getReturn();
      assertNotNull(response);
   }
}
