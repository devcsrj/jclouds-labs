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
package org.jclouds.profitbricks.binder.firewall;

import org.jclouds.profitbricks.binder.snapshot.CreateSnapshotRequestBinder;
import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.domain.Protocol;
import org.jclouds.profitbricks.domain.Snapshot;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "AddFirewallRuleToNicRequestBinderTest")
public class AddFirewallRuleToNicRequestBinderTest {

    @Test
    public void testCreatePayload() {
        AddFirewallRuleToNicRequestBinder binder = new AddFirewallRuleToNicRequestBinder();

        Firewall.Request.AddFirewallRulePayload payload = Firewall.Request.addFirewallRuleBuilder()
                .nicid("nic-id")
                .icmpCode("icmp-code")
                .icmpType("icmp-type")
                .name("name")
                .portRangeEnd("port-range-end")
                .portRangeStart("port-range-start")
                .protocol(Protocol.TCP)
                .sourceIp("source-ip")
                .sourceMac("source-mac")
                .targetIp("target-ip")
                .build();

        String actual = binder.createPayload(payload);
        assertNotNull(actual, "Binder returned null payload");
        assertEquals(expectedPayload, actual);
    }

    private final String expectedPayload = ("  <ws:addFirewallRulesToNic>\n"
            + "        <nicId>nic-id</nicId>\n"
            + "            <request>\n"
            + "                <icmpCode>icmp-code</icmpCode>\n"
            + "                <icmpType>icmp-type</icmpType>\n"
            + "                <name>name</name>\n"
            + "                <portRangeEnd>port-range-end</portRangeEnd>\n"
            + "                <portRangeStart>port-range-start</portRangeStart>\n"
            + "                <protocol>TCP</protocol>\n"
            + "                <sourceIp>source-ip</sourceIp>\n"
            + "                <sourceMac>source-mac</sourceMac>\n"
            + "                <targetIp>target-ip</targetIp>\n"
            + "            </request>\n"
            + "        </ws:addFirewallRulesToNic>").replaceAll("\\s+", "");
}
