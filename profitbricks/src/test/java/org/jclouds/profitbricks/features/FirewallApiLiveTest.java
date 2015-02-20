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

import com.google.common.collect.Iterables;
import java.util.List;
import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.domain.Protocol;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Test(groups = "live", testName = "FirewallApiLiveTest", singleThreaded = true)
public class FirewallApiLiveTest extends BaseProfitBricksLiveTest {

   Nic nic;
   String firewallId;
   String firewallRuleId;

   @Override
   protected void initialize() {
      super.initialize();
      List<Nic> nics = api.nicApi().getAllNics();
      assertFalse(nics.isEmpty(),"Must atleast have 1 NIC available for firewall testing.");

      this.nic = Iterables.getFirst(nics, null);
   }

   @Test
   public void testGetAllFirewalls() {
      List<Firewall> firewalls = api.firewallApi().getAllFirewalls();

      assertFalse(firewalls.isEmpty());
   }

   @Test
   public void testAddFirewallRuleToNic() {
      Firewall firewall = api.firewallApi().addFirewallRuleToNic(Firewall.Request.addFirewallRuleBuilder()
	      .nicid(nic.id())
	      .name("TCP")
	      .protocol(Protocol.ICMP)
	      .build());

      assertNotNull(firewall);
      assertNotNull(firewall.firewallRules());

      firewallId = firewall.id();
      firewallRuleId = firewall.firewallRules().get(firewall.firewallRules().size() - 1).id();
   }

   @Test(dependsOnMethods = "testAddFirewallRuleToNic")
   public void testGetFirewall() {
      Firewall firewall = api.firewallApi().getFirewall(firewallId);

      assertNotNull(firewall);
      assertEquals(firewallId, firewall.id());
   }

   @Test
   public void testActivateFirewall() {
      boolean result = api.firewallApi().activateFirewall(firewallId);

      assertTrue(result);
   }

   @Test
   void testDeactivateFirewall() {
      boolean result = api.firewallApi().deactivateFirewall(firewallRuleId);

      assertTrue(result);
   }

   @Test
   void testRemoveFirewallRule() {
      boolean result = api.firewallApi().removeFirewall(firewallRuleId);

      assertTrue(result);
   }

   @Test
   @AfterClass(alwaysRun = true)
   public void testDeleteFirewall() {
      boolean result = api.firewallApi().deleteFirewall(firewallId);

      assertTrue(result);
   }
}
