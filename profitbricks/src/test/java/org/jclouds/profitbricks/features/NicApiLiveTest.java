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
import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.Nic;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

@Test(groups = "live", testName = "NicApiLiveTest", singleThreaded = true)
public class NicApiLiveTest extends BaseProfitBricksLiveTest {

    protected Predicate<String> nicWaitingPredicate;
    String nicId;
    String dataCenterId;
    String serverId = /*"e7427f92-0ccf-4061-83ea-2fbfe53c68d6";*/ "ce48c54a-3e61-482a-8345-988431893607";

    @Test
    public void testGetAllNics() {
        List<Nic> nics = api.nicApi().getAllNics();
        
        assertNotNull(nics);
    }

    @Test
    public void testGetNic() {
        Nic nic = api.nicApi().getNic(nicId);

        assertNotNull(nic);
    }

    @Test
    public void testCreateNic() {
        Nic.Request.CreatePayload payload = Nic.Request.creatingBuilder()
                .nicName("name nr1")
                .dhcpActive(true)
                .serverId(serverId)
                .lanId("1")
                .build();

        Nic nic = api.nicApi().createNic(payload);

        assertNotNull(nic.id());

        dataCenterId = nic.dataCenterId();
        nicId = nic.id();
    }

    @Test
    public void testUpdateNic() {
        Nic.Request.UpdatePayload toUpdate = Nic.Request.updatingBuilder()
                .nicName("name nr2")
                .id(nicId)
                .build();

        api.nicApi().updateNic(toUpdate);

        Nic updatedNic = api.nicApi().getNic(toUpdate.id());

        assertEquals(updatedNic.name(), toUpdate.nicName());
    }

    @Test
    void testSetInternetAccess() {

        Nic.Request.SetInternetAccessPayload toUpdate = Nic.Request.setInternetAccessBuilder()
                .dataCenterId(dataCenterId)
                .lanId("1")
                .internetAccess(true)
                .build();

        Nic result = api.nicApi().setInternetAccess(toUpdate);

        assertNotNull(result);
    }

    @AfterClass(alwaysRun = true)
    void testDeleteNic() {
        boolean result = api.nicApi().deleteNic(nicId);
        assertTrue(result);
    }
}
