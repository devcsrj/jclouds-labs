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
package org.jclouds.profitbricks.http.parser.datacenter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import javax.xml.parsers.ParserConfigurationException;

import org.jclouds.http.functions.ParseSax;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseResponseHandlerTest;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "DataCenterInfoResponseHandlerTest")
public class DataCenterInfoResponseHandlerTest extends BaseResponseHandlerTest<DataCenter> {

   @Override
   protected ParseSax<DataCenter> createParser() {
      return factory.create(injector.getInstance(DataCenterInfoResponseHandler.class));
   }

   @Test
   public void testParseResponseFromGetDataCenter() throws ParserConfigurationException {
      ParseSax<DataCenter> parser = createParser();
      DataCenter actual = parser.parse(sampleResponse);
      assertNotNull(actual, "Parsed content returned null");

      DataCenter expected = DataCenter.builder()
	      .id("12345678-abcd-efgh-ijkl-987654321000")
	      .version(10)
	      .name("JClouds-DC")
	      .state(ProvisioningState.AVAILABLE)
	      .location(Location.US_LAS)
	      .build();
      assertEquals(expected, actual);
   }

   private final String sampleResponse 
	   = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
	   + "   <S:Body>\n"
	   + "      <ns2:getDataCenterResponse xmlns:ns2=\"http://ws.api.profitbricks.com/\">\n"
	   + "         <return>\n"
	   + "            <requestId>10933055</requestId>\n"
	   + "            <dataCenterId>12345678-abcd-efgh-ijkl-987654321000</dataCenterId>\n"
	   + "            <dataCenterVersion>10</dataCenterVersion>\n"
	   + "            <dataCenterName>JClouds-DC</dataCenterName>\n"
	   + "            <servers>\n"
	   + "               <dataCenterId>12345678-abcd-efgh-ijkl-987654321000</dataCenterId>\n"
	   + "               <dataCenterVersion>10</dataCenterVersion>\n"
	   + "               <serverId>qqqqqqqq-wwww-eeee-rrrr-tttttttttttt</serverId>\n"
	   + "               <serverName>jnode1</serverName>\n"
	   + "               <cores>4</cores>\n"
	   + "               <ram>4096</ram>\n"
	   + "               <internetAccess>true</internetAccess>\n"
	   + "               <ips>202.94.38.12</ips>\n"
	   + "               <connectedStorages>\n"
	   + "                  <bootDevice>true</bootDevice>\n"
	   + "                  <busType>VIRTIO</busType>\n"
	   + "                  <deviceNumber>1</deviceNumber>\n"
	   + "                  <size>40</size>\n"
	   + "                  <storageId>ssssssss-aaaa-ffff-gggg-hhhhhhhhhhhh</storageId>\n"
	   + "                  <storageName>jnode1-disk1</storageName>\n"
	   + "               </connectedStorages>\n"
	   + "               <nics>\n"
	   + "                  <dataCenterId>12345678-abcd-efgh-ijkl-987654321000</dataCenterId>\n"
	   + "                  <dataCenterVersion>10</dataCenterVersion>\n"
	   + "                  <nicId>zzzzzzzz-xxxx-cccc-vvvv-bbbbbbbbbbbb</nicId>\n"
	   + "                  <lanId>1</lanId>\n"
	   + "                  <internetAccess>true</internetAccess>\n"
	   + "                  <serverId>12345678-abcd-efgh-ijkl-987654321000</serverId>\n"
	   + "                  <ips>202.94.38.12</ips>\n"
	   + "                  <macAddress>02:01:09:cd:f0:b0</macAddress>\n"
	   + "                  <firewall>\n"
	   + "                     <active>false</active>\n"
	   + "                     <firewallId>llllllll-kkkk-jjjj-hhhh-gggggggggggg</firewallId>\n"
	   + "                     <firewallId>62383ec1-38c8-486b-8fa2-a3bb0a5edd97</firewallId>\n"
	   + "                     <nicId>zzzzzzzz-xxxx-cccc-vvvv-bbbbbbbbbbbb</nicId>\n"
	   + "                     <provisioningState>AVAILABLE</provisioningState>\n"
	   + "                  </firewall>\n"
	   + "                  <dhcpActive>true</dhcpActive>\n"
	   + "                  <gatewayIp>202.94.38.1</gatewayIp>\n"
	   + "                  <provisioningState>AVAILABLE</provisioningState>\n"
	   + "               </nics>\n"
	   + "               <provisioningState>AVAILABLE</provisioningState>\n"
	   + "               <virtualMachineState>RUNNING</virtualMachineState>\n"
	   + "               <creationTime>2014-12-04T07:09:23.138Z</creationTime>\n"
	   + "               <lastModificationTime>2014-12-12T03:08:35.629Z</lastModificationTime>\n"
	   + "               <osType>LINUX</osType>\n"
	   + "               <availabilityZone>AUTO</availabilityZone>\n"
	   + "               <cpuHotPlug>true</cpuHotPlug>\n"
	   + "               <ramHotPlug>true</ramHotPlug>\n"
	   + "               <nicHotPlug>true</nicHotPlug>\n"
	   + "               <nicHotUnPlug>true</nicHotUnPlug>\n"
	   + "               <discVirtioHotPlug>true</discVirtioHotPlug>\n"
	   + "               <discVirtioHotUnPlug>true</discVirtioHotUnPlug>\n"
	   + "            </servers>\n"
	   + "            <storages>\n"
	   + "               <dataCenterId>12345678-abcd-efgh-ijkl-987654321000</dataCenterId>\n"
	   + "               <dataCenterVersion>10</dataCenterVersion>\n"
	   + "               <storageId>ssssssss-aaaa-ffff-gggg-hhhhhhhhhhhh</storageId>\n"
	   + "               <size>40</size>\n"
	   + "               <storageName>jnode1-disk1</storageName>\n"
	   + "               <mountImage>\n"
	   + "                  <imageId>f0a59a5c-7940-11e4-8053-52540066fee9</imageId>\n"
	   + "                  <imageName>Ubuntu-14.04-LTS-server-2014-12-01</imageName>\n"
	   + "               </mountImage>\n"
	   + "               <serverIds>qqqqqqqq-wwww-eeee-rrrr-tttttttttttt</serverIds>\n"
	   + "               <provisioningState>AVAILABLE</provisioningState>\n"
	   + "               <creationTime>2014-12-04T07:09:23.138Z</creationTime>\n"
	   + "               <lastModificationTime>2014-12-12T03:14:48.316Z</lastModificationTime>\n"
	   + "            </storages>\n"
	   + "            <provisioningState>AVAILABLE</provisioningState>\n"
	   + "            <location>us/las</location>\n"
	   + "         </return>\n"
	   + "      </ns2:getDataCenterResponse>\n"
	   + "   </S:Body>\n"
	   + "</S:Envelope>";
}
