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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.jclouds.profitbricks.ProfitBricksApi;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.Snapshot;
import org.jclouds.profitbricks.internal.BaseProfitBricksMockTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Mock tests for the {@link org.jclouds.profitbricks.features.DataCenterApi} class
 */
@Test(groups = "unit", testName = "DataCenterApiMockTest")
public class SnapshotApiMockTest extends BaseProfitBricksMockTest {

    @Test
    public void testGetAllSnapshots() throws Exception{
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/snapshot/snapshots.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        SnapshotApi api = pbApi.snapshotApi();

        try {
            List<Snapshot> snapshots = api.getAllSnapshots();
            assertRequestHasCommonProperties(server.takeRequest(), "<ws:getAllSnapshots/>");
            assertNotNull(snapshots);
            assertEquals(snapshots.size(), 2);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testGetAllSnapshotsReturning404() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        SnapshotApi api = pbApi.snapshotApi();

        try {
            List<Snapshot> snapshots= api.getAllSnapshots();
            assertRequestHasCommonProperties(server.takeRequest());
            assertTrue(snapshots.isEmpty());
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testGetSnapshot() throws Exception{
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setBody(payloadFromResource("/snapshot/snapshot.xml")));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        SnapshotApi api = pbApi.snapshotApi();

        String id = "qswdefrg-qaws-qaws-defe-rgrgdsvcxbrh";

        String content = "<ws:getSnapshot><snapshotId>"+id+"</snapshotId></ws:getSnapshot>";

        try{
            Snapshot snapshot = api.getSnapshot(id);
            assertRequestHasCommonProperties(server.takeRequest(),content);
            assertNotNull(snapshot);
            assertEquals(snapshot.id(),id);
        }finally {
            pbApi.close();
            server.shutdown();
        }
    }

    @Test
    public void testGetNonExistingSnapshot() throws Exception {
        MockWebServer server = mockWebServer();
        server.enqueue(new MockResponse().setResponseCode(404));

        ProfitBricksApi pbApi = api(server.getUrl(rootUrl));
        SnapshotApi api = pbApi.snapshotApi();

        String id = "random-non-existing-id";
        try {
            Snapshot snapshot = api.getSnapshot(id);
            assertRequestHasCommonProperties(server.takeRequest());
            assertNull(snapshot);
        } finally {
            pbApi.close();
            server.shutdown();
        }
    }
}
