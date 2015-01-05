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
package org.jclouds.profitbricks.xml;

import org.jclouds.profitbricks.binders.SOAPParser;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.datacenter.DataCenterIdentifier;
import org.jclouds.profitbricks.domain.datacenter.getall.GetAllDataCentersResponse;
import org.jclouds.profitbricks.domain.storage.create.CreateStorageResponse;
import org.jclouds.profitbricks.domain.storage.create.CreateStorageReturn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "SOAPParserTest")
public class SOAPParserTest {

   protected final SOAPParser parser;
   protected final String[] soapPayloads = {
      "<?xml version='1.0' encoding='UTF-8'?>\n"
      + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
      + "	<soapenv:Body>\n"
      + "		<ns2:getAllDataCentersResponse xmlns:ns2=\"http://ws.api.profitbricks.com/\">\n"
      + "			<return>\n"
      + "				<dataCenterId>dac1cbb5-6e00-4a29-a68e-2823b811bfc4</dataCenterId>\n"
      + "				<dataCenterName>Test DC</dataCenterName>\n"
      + "				<dataCenterVersion>354</dataCenterVersion>\n"
      + "				<provisioningState>AVAILABLE</provisioningState>\n"
      + "			</return>\n"
      + "		</ns2:getAllDataCentersResponse>\n"
      + "	</soapenv:Body>\n"
      + "</soapenv:Envelope>",
      "<?xml version='1.0' encoding='UTF-8'?>\n"
      + "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
      + "	<S:Body>\n"
      + "		<ns2:createStorageReturn xmlns:ns2=\"http://ws.api.profitbricks.com/\">\n"
      + "			<return>\n"
      + "				<requestId>6423780</requestId>\n"
      + "				<dataCenterId>dac1cbb5-6e00-4a29-a68e-2823b811bfc4</dataCenterId>\n"
      + "				<dataCenterVersion>366</dataCenterVersion>\n"
      + "				<storageId>c069ebcf-a4b9-4422-8cc0-606b0604fb23</storageId>\n"
      + "			</return>\n"
      + "		</ns2:createStorageReturn>\n"
      + "	</S:Body>\n"
      + "</S:Envelope>"
   };

   public SOAPParserTest() {
      this.parser = new SOAPParser("false");
   }

   @Test
   public void testParseGetAllDataCentersResponse() {
      try {
         GetAllDataCentersResponse expected = new GetAllDataCentersResponse(ImmutableList.<DataCenterIdentifier>of(
                 new DataCenterIdentifier("dac1cbb5-6e00-4a29-a68e-2823b811bfc4", "Test DC", 354, ProvisioningState.AVAILABLE)
         ));
         GetAllDataCentersResponse actual = parser.fromXML(soapPayloads[0], GetAllDataCentersResponse.class);
         assertEquals(actual.getReturn(), expected.getReturn());
      } catch (IOException ex) {
         fail(ex.toString());
      }
   }

   @Test
   public void testParseCreateStorageReturn() {
      try {
         CreateStorageReturn expected = new CreateStorageReturn(
                 new CreateStorageResponse("c069ebcf-a4b9-4422-8cc0-606b0604fb23", "dac1cbb5-6e00-4a29-a68e-2823b811bfc4", 366, "6423780"));

         CreateStorageReturn actual = parser.fromXML(soapPayloads[1], CreateStorageReturn.class);
         assertEquals(actual.getReturn(), expected.getReturn());
      } catch (IOException ex) {
         fail(ex.toString());
      }
   }
}
