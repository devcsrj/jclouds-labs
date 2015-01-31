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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Test(groups = "unit", testName = "NicApiMockTest")

public class NicApiMockTest extends BaseProfitBricksMockTest {

    @Test
    public void testGetNic() throws Exception{
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
}
