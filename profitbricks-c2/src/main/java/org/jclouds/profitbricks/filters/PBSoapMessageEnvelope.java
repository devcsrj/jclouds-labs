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
package org.jclouds.profitbricks.filters;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;

import org.jclouds.http.HttpRequest;
import org.jclouds.http.HttpRequestFilter;
import org.jclouds.io.Payload;
import org.jclouds.io.Payloads;
import org.jclouds.logging.Logger;

/**
 * Filters {@link HttpRequest} request and wraps request body into SOAP envelope.
 */
@Singleton
public class PBSoapMessageEnvelope implements HttpRequestFilter {

   @Resource
   private Logger logger = Logger.NULL;

   private static final String SOAP_MSG_PREFIX
           = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://ws.api.profitbricks.com/\">"
           + "<soapenv:Header/>"
           + "<soapenv:Body>";

   private static final String SOAP_MSG_SUFFIX = "</soapenv:Body></soapenv:Envelope>";

   @Override
   public HttpRequest filter(HttpRequest request) {
      checkNotNull(request.getPayload(), "HTTP Request must contain payload message");
      return createSoapRequest(request);
   }

   private HttpRequest createSoapRequest(HttpRequest request) {
      String body = request.getPayload().getRawContent().toString();
      logger.trace("wrapping request payload [%s] into SOAP envelope", body);
      Payload soapPayload = Payloads.newStringPayload(SOAP_MSG_PREFIX + body + SOAP_MSG_SUFFIX);
      soapPayload.getContentMetadata().setContentType(MediaType.TEXT_XML);
      return request.toBuilder().payload(soapPayload).build();
   }

}
