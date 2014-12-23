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
package org.jclouds.profitbricks.http;

import static org.jclouds.util.Closeables2.closeQuietly;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.core.Response;

import org.jclouds.http.HttpResponse;
import org.jclouds.http.HttpUtils;
import org.jclouds.http.IOExceptionRetryHandler;
import org.jclouds.http.functions.ParseSax;
import org.jclouds.http.handlers.DelegatingErrorHandler;
import org.jclouds.http.handlers.DelegatingRetryHandler;
import org.jclouds.http.internal.HttpWire;
import org.jclouds.http.internal.JavaUrlHttpCommandExecutorService;
import org.jclouds.io.ContentMetadataCodec;
import org.jclouds.io.Payload;
import org.jclouds.io.Payloads;
import org.jclouds.profitbricks.domain.ServiceFault;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;

/**
 * Custom implementation of the HTTP driver to read actual http status and message from SOAP Fault.
 * <br/>
 * ProfitBricks API errors are always returned with 500 HTTP code. This class parses and reads the SOAP response to map
 * the actual http code and message
 */
@Singleton
public class ResponseStatusFromPayloadHttpCommandExecutorService extends JavaUrlHttpCommandExecutorService {

   private final ParseSax<ServiceFault> faultHandler;

   @Inject
   ResponseStatusFromPayloadHttpCommandExecutorService(HttpUtils utils, ContentMetadataCodec contentMetadataCodec,
	   DelegatingRetryHandler retryHandler, IOExceptionRetryHandler ioRetryHandler,
	   DelegatingErrorHandler errorHandler, HttpWire wire, @Named("untrusted") HostnameVerifier verifier,
	   @Named("untrusted") Supplier<SSLContext> untrustedSSLContextProvider, Function<URI, Proxy> proxyForURI,
	   ParseSax<ServiceFault> faultHandler) {
      super(utils, contentMetadataCodec, retryHandler, ioRetryHandler, errorHandler, wire, verifier, untrustedSSLContextProvider, proxyForURI);
      this.faultHandler = faultHandler;
   }

   @Override
   protected HttpResponse invoke(HttpURLConnection connection) throws IOException, InterruptedException {
      HttpResponse originalResponse = super.invoke(connection);
      HttpResponse.Builder<?> responseBuilder = originalResponse.toBuilder();

      if (hasPayload(originalResponse) && hasServerError(originalResponse)) {
	 InputStream in = null;
	 InputStream originalInputStream = originalResponse.getPayload().openStream();
	 if (originalInputStream instanceof ByteArrayInputStream)
	    in = originalInputStream;
	 else
	    try {
	       in = new ByteArrayInputStream(ByteStreams.toByteArray(originalInputStream));
	    } finally {
	       closeQuietly(originalInputStream);
	    }

	 try {
	    ServiceFault fault = faultHandler.parse(in);
	    if (fault != null)
	       responseBuilder
		       .statusCode(fault.httpCode())
		       .message(fault.message());
	 } catch (Exception ex) {
	    // ignore
	 } finally {
	    if (in != null) {
	       in.reset();
	       Payload payload = Payloads.newInputStreamPayload(in);
	       contentMetadataCodec.fromHeaders(payload.getContentMetadata(), originalResponse.getHeaders());
	       responseBuilder.payload(payload);
	    }
	 }
      }

      return responseBuilder.build();
   }

   private static boolean hasServerError(final HttpResponse response) {
      return Response.Status.fromStatusCode(response.getStatusCode()) == Response.Status.INTERNAL_SERVER_ERROR;
   }

   private static boolean hasPayload(final HttpResponse response) {
      return response.getPayload() != null && response.getPayload().getRawContent() != null;
   }

}
