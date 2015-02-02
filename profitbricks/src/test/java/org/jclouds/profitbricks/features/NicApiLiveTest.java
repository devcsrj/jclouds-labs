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

import org.jclouds.profitbricks.BaseProfitBricksLiveTest;
import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

@Test(groups = "live", testName = "NicApiLiveTest", singleThreaded = true)
public class NicApiLiveTest extends BaseProfitBricksLiveTest {

    @Test
    public void testGetAllNics() {
        List<Nic> nics = api.nicApi().getAllNics();
        System.out.println("*****NICS*****");
        for (Nic nic : nics) {

            System.out.println("NIC");

            System.out.println(nic.nicId());
            System.out.println(nic.dataCenterId());
            System.out.println(nic.internetAccess());
            System.out.println(nic.provisioningState().toString());
        }

        assertNotNull(nics);
    }

    @Test
    public void testGetNic() {
        List<Nic> nics = api.nicApi().getAllNics();

        Nic nic = api.nicApi().getNic(nics.get(0).nicId());

        System.out.println(nic.lanId());
        assertNotNull(nic);
    }

    @Test
    public void testCreateNic() {
        Nic.Request.CreatePayload toCreate = Nic.Request
                .CreatePayload.create("123.123.123.123", "test name", true, "565fe4c3-12fe-4bcd-a629-aa1f973bd279", "1");

        Nic nic = api.nicApi().createNic(toCreate);

        assertNotNull(nic);
    }

    @Test
    public void testUpdateNic() {
        System.out.println("Getting all nics");
        List<Nic> nics = api.nicApi().getAllNics();

        System.out.println("Getting one specific to update, its id is " + (nics.size() - 2));
        Nic originalnic = nics.get(nics.size() - 2);

        System.out.println("provisioningState " + originalnic.provisioningState().toString());

        Nic.Request.UpdatePayload toUpdate = Nic.Request.UpdatePayload.create(originalnic.nicId(), "192.168.1.138", "new name", originalnic.dhcpActive(), "0");

        System.out.println("Updating one with id " + originalnic.nicId());

        System.out.println("Done updating");

        Nic newNic = api.nicApi().getNic(toUpdate.nicId());

        System.out.println("nicId " + newNic.nicId());
        System.out.println("dataCenterId " + newNic.dataCenterId());
        System.out.println("dataCenterVersion " + newNic.dataCenterVersion());
        System.out.println("ips " + newNic.ips());
        System.out.println("lanId " + newNic.lanId());
        System.out.println("provisioningState " + newNic.provisioningState().toString());
        assertEquals(newNic.provisioningState(), ProvisioningState.INPROCESS);
    }

    @Test
    void testSetInternetAccess() {
        List<Nic> nics = api.nicApi().getAllNics();

        System.out.println("Getting one specific to update, its id is " + nics.get(nics.size() - 2).nicId());
        Nic originalnic = Nic.create("", "", "", 0, "", true, "", "", "", true, "", ProvisioningState.UNRECOGNIZED);

        for (Nic n : nics) {
            if (!n.lanId().equals("0")) {
                originalnic = n;
                break;
            }
        }
        System.out.println("Original internet access " + originalnic.internetAccess());

        System.out.println("Updating one with id " + originalnic.nicId());

        Nic.Request.SetInternetAccessPayload toUpdate = Nic.Request.SetInternetAccessPayload.create(originalnic.dataCenterId(), "0", !originalnic.internetAccess());
        System.out.println("LANID " + toUpdate.lanId());
        System.out.println("origina LANID " + originalnic.lanId());

        api.nicApi().setInternetAccess(toUpdate);

        System.out.println("Done updating");

        Nic newNic = api.nicApi().getNic(originalnic.nicId());

        assertEquals(originalnic.internetAccess(), newNic.internetAccess());

    }
}
