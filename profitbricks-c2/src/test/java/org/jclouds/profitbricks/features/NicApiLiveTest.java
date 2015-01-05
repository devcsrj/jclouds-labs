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
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.nic.Nic;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.internal.BaseProfitBricksLiveTest;
import org.jclouds.util.Predicates2;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

@Test(groups = "live", testName = "NicApiLiveTest")
public class NicApiLiveTest extends BaseProfitBricksLiveTest {

   private final int lanId = 1;
   private Server server;
   private String nicId;
   private Predicate<String> nicWaitingPredicate;

   @Override
   protected void initialize() {
      super.initialize();
      initializeVDC();
      this.nicWaitingPredicate = Predicates2.retry(new ProvisioningStatusPollingPredicate(
              api, ProvisioningStatusAware.NIC), 2l * 60l, 2l, TimeUnit.SECONDS);
      List<Server> servers = api.getServersApi().getAllServers().getReturn();
      for (Server server : servers)
         if (server.getNics().isEmpty()) {
            this.server = server;
            break;
         }
   }

   @Test
   public void testCreateNic() {
      assertNotNull(vdc);
      vdcWaitingPredicate.apply(vdc.getDataCenterId());
      assertNotNull(server, "There were no available servers where a NIC can be attached.");
      String nicId = api.getNicApi().createNic(Nic.creatingBuilder()
              .serverId(server.getServerId())
              .lanId(lanId)
              .build()).getReturn().getNicId();

      assertNotNull(nicId);
      this.nicId = nicId;
   }

   @Test(dependsOnMethods = "testCreateNic")
   public void testGetNic() {
      Nic nic = api.getNicApi().getNic(nicId).getReturn();

      assertNotNull(nic);
   }

   @Test(dependsOnMethods = "testGetNic")
   public void testGetAllNic() {
      nicWaitingPredicate.apply(nicId);
      assertTrue(api.getNicApi().getNic(nicId).getReturn().getProvisioningState() == ProvisioningState.AVAILABLE,
              "NIC was not ready.");

      assertFalse(api.getNicApi().getAllNic().getReturn().isEmpty());
   }

   @Test(dependsOnMethods = "testGetAllNic")
   public void testSetInternetAccess() {
      vdcWaitingPredicate.apply(server.getDataCenterId());
      VersionResponse response = api.getNicApi().setInternetAccess(server.getDataCenterId(), lanId, true).getReturn();

      assertNotNull(response);

      nicWaitingPredicate.apply(nicId);
      Nic nic = api.getNicApi().getNic(nicId).getReturn();
      assertTrue(nic.isInternetAccess(), "NIC didn't have internet access.");
   }

   @Test(dependsOnMethods = "testSetInternetAccess")
   public void testUpdateNic() {
      VersionResponse response = api.getNicApi().updateNic(
              Nic.updatingBuilder()
              .nicId(nicId)
              .nicName("Nick")
              .setDhcpActive(Boolean.FALSE)
              .build()).getReturn();

      assertNotNull(response);

      nicWaitingPredicate.apply(nicId);
      Nic nic = api.getNicApi().getNic(nicId).getReturn();
      assertTrue(nic.getNicName().equals("Nick") && !nic.isDhcpActive(),
              "Expects NIC name to be 'Nick' and DHCP to be inactive after update.");
   }

   @Test(alwaysRun = true, dependsOnMethods = "testUpdateNic")
   public void testDeleteNic() {
      assertNotNull(nicId, "There was no NIC to delete.");
      nicWaitingPredicate.apply(nicId);
      VersionResponse response = api.getNicApi().deleteNic(nicId).getReturn();

      assertNotNull(response);
   }

}
