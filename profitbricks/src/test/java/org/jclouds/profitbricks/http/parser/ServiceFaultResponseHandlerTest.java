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
package org.jclouds.profitbricks.http.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.jclouds.http.functions.ParseSax;
import org.jclouds.profitbricks.domain.ServiceFault;
import org.testng.annotations.Test;

@Test(groups = "unit", testName = "ServiceFaultResponseHandlerTest")
public class ServiceFaultResponseHandlerTest extends BaseResponseHandlerTest<ServiceFault> {

   @Override
   protected ParseSax<ServiceFault> createParser() {
      return factory.create(injector.getInstance(ServiceFaultResponseHandler.class));
   }

   @Test
   public void testParseSoapServiceFault() {
      ParseSax<ServiceFault> parser = createParser();
      ServiceFault actual = parser.parse(sampleResponse);
      assertNotNull(actual, "Parsed content returned null");

      ServiceFault expected = ServiceFault.builder()
	      .faultCode(ServiceFault.FaultCode.RESOURCE_NOT_FOUND)
	      .httpCode(404)
	      .message("The requested resource could not be found. Please refer to Request Id : 11122416. [VDC-6-404] The requested data center does not exist or already deleted by the users. ResourceId 123123")
	      .requestId(11122416)
	      .build();

      assertEquals(expected, actual);
   }

   private final String sampleResponse
	   = "<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
	   + "   <S:Body>\n"
	   + "      <S:Fault xmlns:ns4=\"http://www.w3.org/2003/05/soap-envelope\">\n"
	   + "         <faultcode>S:Server</faultcode>\n"
	   + "         <faultstring>The requested resource could not be found. Please refer to Request Id : 11122416. [VDC-6-404] The requested data center does not exist or already deleted by the users. ResourceId 123123</faultstring>\n"
	   + "         <detail>\n"
	   + "            <ns2:ProfitbricksServiceFault xmlns:ns2=\"http://ws.api.profitbricks.com/\">\n"
	   + "               <faultCode>RESOURCE_NOT_FOUND</faultCode>\n"
	   + "               <httpCode>404</httpCode>\n"
	   + "               <message>The requested resource could not be found. Please refer to Request Id : 11122416. [VDC-6-404] The requested data center does not exist or already deleted by the users. ResourceId 123123</message>\n"
	   + "               <requestId>11122416</requestId>\n"
	   + "            </ns2:ProfitbricksServiceFault>\n"
	   + "         </detail>\n"
	   + "      </S:Fault>\n"
	   + "   </S:Body>\n"
	   + "</S:Envelope>";
}
