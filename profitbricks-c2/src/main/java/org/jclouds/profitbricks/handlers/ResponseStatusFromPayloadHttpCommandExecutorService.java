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
package org.jclouds.profitbricks.handlers;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.io.Closeables.close;
import static org.jclouds.io.Payloads.newInputStreamPayload;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.jclouds.http.HttpResponse;
import org.jclouds.http.HttpUtils;
import org.jclouds.http.IOExceptionRetryHandler;
import org.jclouds.http.handlers.DelegatingErrorHandler;
import org.jclouds.http.handlers.DelegatingRetryHandler;
import org.jclouds.http.internal.HttpWire;
import org.jclouds.http.internal.JavaUrlHttpCommandExecutorService;
import org.jclouds.io.ContentMetadataCodec;
import org.jclouds.io.Payload;
import org.jclouds.profitbricks.binders.SOAPParser;
import org.w3c.dom.NodeList;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.io.ByteStreams;

@Singleton
public class ResponseStatusFromPayloadHttpCommandExecutorService extends JavaUrlHttpCommandExecutorService {

   protected final SOAPParser soapParser;

   @Inject
   ResponseStatusFromPayloadHttpCommandExecutorService(HttpUtils utils, ContentMetadataCodec contentMetadataCodec,
           DelegatingRetryHandler retryHandler, IOExceptionRetryHandler ioRetryHandler,
           DelegatingErrorHandler errorHandler, HttpWire wire, @Named("untrusted") HostnameVerifier verifier,
           @Named("untrusted") Supplier<SSLContext> untrustedSSLContextProvider, Function<URI, Proxy> proxyForURI,
           SOAPParser soapParser) throws SecurityException, NoSuchFieldException {
      super(utils, contentMetadataCodec, retryHandler, ioRetryHandler, errorHandler, wire, verifier,
              untrustedSSLContextProvider, proxyForURI);
      this.soapParser = checkNotNull(soapParser, "soapParser cannot be null");
   }

   @Override
   protected HttpResponse invoke(HttpURLConnection connection) throws IOException, InterruptedException {
      HttpResponse original = super.invoke(connection);
      HttpResponse.Builder<?> response = original.toBuilder();

      if (hasPayload(original)) {
         InputStream in = null;
         InputStream originalInputStream = original.getPayload().openStream();
         if (originalInputStream instanceof ByteArrayInputStream)
            in = originalInputStream;
         else
            try {
               in = new ByteArrayInputStream(ByteStreams.toByteArray(originalInputStream));
            } finally {
               close(originalInputStream, true);
            }
         try {
            SOAPMessage message = soapParser.parse(in);
            if (message.getSOAPBody().hasFault()) {
               SOAPFault fault = message.getSOAPBody().getFault();
               org.w3c.dom.Node node = fault.getDetail().getFirstChild();
               NodeList childNodes = node.getChildNodes();
               int len = childNodes.getLength();
               for (int i = 0; i < len; i++) {
                  org.w3c.dom.Node item = childNodes.item(i);
                  final String name = item.getNodeName();
                  if ("httpCode".equals(name))
                     response.statusCode(Integer.parseInt(item.getTextContent()));
                  else if ("message".equals(name))
                     response.message(item.getTextContent());
                  // also has 'faultCode', 'requestId'
               }
            }
         } catch (SOAPException ex) {
            // Ignore
         }

         in.reset();
         Payload payload = newInputStreamPayload(in);
         contentMetadataCodec.fromHeaders(payload.getContentMetadata(), original.getHeaders());
         response.payload(payload);
      }
      return response.build();
   }

   private boolean hasPayload(final HttpResponse response) {
      return response.getPayload() != null && response.getPayload().getRawContent() != null;
   }
}
