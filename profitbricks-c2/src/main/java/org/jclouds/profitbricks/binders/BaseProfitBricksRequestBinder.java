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
package org.jclouds.profitbricks.binders;

import javax.ws.rs.core.MediaType;

import org.jclouds.http.HttpRequest;
import org.jclouds.rest.MapBinder;

import com.google.common.base.Strings;

public abstract class BaseProfitBricksRequestBinder implements MapBinder {

   protected final StringBuilder requestBuilder;

   public BaseProfitBricksRequestBinder() {
      this.requestBuilder = new StringBuilder(255);
   }

   protected String ifNotEmpty(String pattern, Object param) {
      try {
         return Strings.isNullOrEmpty((String) param) ? "" : String.format(pattern, param);
      } catch (ClassCastException ex) {
         return Strings.isNullOrEmpty(param.toString()) ? "" : String.format(pattern, param);
      }
   }

   protected String ifNotNull(Object object) {
      return object == null ? "" : object.toString();
   }

   protected <R extends HttpRequest> R createRequest(R fromRequest, String payload) {
      fromRequest.setPayload(payload);
      fromRequest.getPayload().getContentMetadata().setContentType(MediaType.TEXT_XML);
      return fromRequest;
   }

   @Override
   public <R extends HttpRequest> R bindToRequest(R request, Object input) {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}
