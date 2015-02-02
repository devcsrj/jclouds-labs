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

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.jclouds.profitbricks.ProfitBricksApi;
import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.internal.BaseProfitBricksMockTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test(groups = "unit", testName = "NicApiMockTest")

public class NicApiMockTest extends BaseProfitBricksMockTest {

    @Test
    public void testGetNic() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/nic/nic.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        NicApi api = pbApi.nicApi();

        String id = "nic-id";

        String content = "<ws:getNic><nicId>" + id + "</nicId></ws:getNic>";
        try {
            Nic nic = api.getNic(id);
            assertRequestHasCommonProperties(server.takeRequest(), content);
            assertNotNull(nic);
            assertEquals(nic.nicId(), id);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testGetAllNic() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/nic/nic.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        NicApi api = pbApi.nicApi();
        try {
            List<Nic> nics = api.getAllNics();
            assertRequestHasCommonProperties(server.takeRequest(), "<ws:getAllNic/>");
            assertNotNull(nics);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testCreateSnapshot() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/nic/nic-create.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        NicApi api = pbApi.nicApi();

        String content = "<ws:createNic>" +
                "<request>" +
                "<ip>ip</ip>" +
                "<nicName>nic-name</nicName>" +
                "<dhcpActive>true</dhcpActive>" +
                "<serverId>server-id</serverId>" +
                "<lanId>lan-id</lanId>" +
                "</request>" +
                "</ws:createNic>";

        try {
            Nic nic = api.createNic(
                    Nic.Request.create()
                            .ip("ip")
                            .nicName("nic-name")
                            .dhcpActive(true)
                            .lanId("lan-id")
                            .serverId("server-id")
                            .build());

            assertRequestHasCommonProperties(server.takeRequest(), content);
            assertNotNull(nic.nicId());

        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testUpdateNic() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/nic/nic-update.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        NicApi api = pbApi.nicApi();

        String content = "<ws:updateNic>" +
                "<request>" +
                "<nicId>nic-id</nicId>" +
                "<ip>ip</ip>" +
                "<nicName>nic-name</nicName>" +
                "<dhcpActive>true</dhcpActive>" +
                "<lanId>lan-id</lanId>" +
                "</request>" +
                "</ws:updateNic>";
        try {
            Nic nic = api.updateNic(Nic.Request.UpdatePayload.create("nic-id", "ip", "nic-name", true, "lan-id"));
            assertRequestHasCommonProperties(server.takeRequest(), content);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testSetInternetAccess() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/nic/nic-internetaccess.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        NicApi api = pbApi.nicApi();

        String content = "<ws:setInternetAccess>" +
                "<dataCenterId>datacenter-id</dataCenterId>" +
                "<lanId>lan-id</lanId>" +
                "<internetAccess>true</internetAccess>" +
                "</ws:setInternetAccess>";
        try {
            Nic nic = api.setInternetAccess(Nic.Request.SetInternetAccessPayload.create("datacenter-id", "lan-id", true));
            assertRequestHasCommonProperties(server.takeRequest(),content);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }
}
