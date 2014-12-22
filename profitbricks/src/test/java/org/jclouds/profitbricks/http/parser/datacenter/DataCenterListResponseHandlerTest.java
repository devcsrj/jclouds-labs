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

import java.util.List;

import org.jclouds.http.functions.ParseSax;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseResponseHandlerTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

@Test(groups = "unit", testName = "DataCenterListResponseHandlerTest")
public class DataCenterListResponseHandlerTest extends BaseResponseHandlerTest<List<DataCenter>> {

   @Override
   protected ParseSax<List<DataCenter>> createParser() {
      return factory.create(injector.getInstance(DataCenterListResponseHandler.class));
   }

   @Test
   public void testParseResponseFromGetAllDataCenter() {
      ParseSax<List<DataCenter>> parser = createParser();

      List<DataCenter> actual = parser.parse(sampleResponse);
      assertNotNull(actual, "Parsed content returned null");

      List<DataCenter> expected = ImmutableList.<DataCenter>of(
	      DataCenter.builder().id("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee").name("JClouds-DC").version(10).state(ProvisioningState.AVAILABLE).build(),
	      DataCenter.builder().id("qqqqqqqq-wwww-rrrr-tttt-yyyyyyyyyyyy").name("Random DC").version(238).state(ProvisioningState.INPROCESS).build()
      );
      assertEquals(expected, actual);
   }

   private final String sampleResponse = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
	   + "   <S:Body>\n"
	   + "      <ns2:getAllDataCentersResponse xmlns:ns2=\"http://ws.api.profitbricks.com/\">\n"
	   + "         <return>\n"
	   + "            <dataCenterId>aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee</dataCenterId>\n"
	   + "            <dataCenterName>JClouds-DC</dataCenterName>\n"
	   + "            <dataCenterVersion>10</dataCenterVersion>\n"
	   + "            <provisioningState>AVAILABLE</provisioningState>\n"
	   + "         </return>\n"
	   + "         <return>\n"
	   + "            <dataCenterId>qqqqqqqq-wwww-rrrr-tttt-yyyyyyyyyyyy</dataCenterId>\n"
	   + "            <dataCenterName>Random DC</dataCenterName>\n"
	   + "            <dataCenterVersion>238</dataCenterVersion>\n"
	   + "            <provisioningState>INPROCESS</provisioningState>\n"
	   + "         </return>\n"
	   + "      </ns2:getAllDataCentersResponse>\n"
	   + "   </S:Body>\n"
	   + "</S:Envelope>";

}
