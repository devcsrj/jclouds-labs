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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.Fallbacks;
import org.jclouds.http.HttpResponseException;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.profitbricks.binder.datacenter.CreateDataCenterRequestBinder;
import org.jclouds.profitbricks.binder.datacenter.UpdateDataCenterRequestBinder;
import org.jclouds.profitbricks.domain.DataCenter;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.filters.ProfitBricksSoapMessageEnvelope;
import org.jclouds.profitbricks.http.parser.datacenter.DataCenterInfoResponseHandler;
import org.jclouds.profitbricks.http.parser.datacenter.DataCenterListResponseHandler;
import org.jclouds.profitbricks.http.parser.state.GetProvisioningStateResponseHandler;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.XMLResponseParser;

@RequestFilters({BasicAuthentication.class, ProfitBricksSoapMessageEnvelope.class})
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface DataCenterApi {

   /**
    * @return Returns a list of all Virtual Data Centers created by the user, including ID, name and version number.
    */
   @POST
   @Payload("<ws:getAllDataCenters/>")
   @XMLResponseParser(DataCenterListResponseHandler.class)
   @Fallback(Fallbacks.EmptyListOnNotFoundOr404.class)
   List<DataCenter> getAllDataCenters();

   /**
    * @param identifier Virtual Data Center identifier
    * @return Returns information about an existing virtual data center's state and configuration.
    */
   @POST
   @Payload("<ws:getDataCenter><dataCenterId>{id}</dataCenterId></ws:getDataCenter>")
   @XMLResponseParser(DataCenterInfoResponseHandler.class)
   DataCenter getDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * This is a lightweight function for polling the current provisioning state of the Virtual Data Center. It is
    * recommended to use this function for large Virtual Data Centers to query request results.
    *
    * @param identifier
    * @return Provisioning state
    * @throws HttpResponseException
    */
   @POST
   @Payload("<ws:getDataCenterState><dataCenterId>{id}</dataCenterId></ws:getDataCenterState>")
   @XMLResponseParser(GetProvisioningStateResponseHandler.class)
   ProvisioningState getDataCenterState(@PayloadParam("id") String identifier);

   /**
    * Creates and saves a new, empty Virtual Data Center. Returns its identifier for further reference.
    *
    * @param createRequest VDC payload containing dataCenterName, region (both optional)
    * @return Version response
    */
   @POST
   @MapBinder(CreateDataCenterRequestBinder.class)
   @XMLResponseParser(DataCenterInfoResponseHandler.class)
   DataCenter createDataCenter(@PayloadParam("dataCenter") DataCenter.Request.CreatePayload createRequest) throws HttpResponseException;

   /**
    * Updates the information associated to an existing Virtual Data Center.
    *
    * @param updateRequest
    * @return
    * @throws HttpResponseException
    */
   @POST
   @MapBinder(UpdateDataCenterRequestBinder.class)
   @XMLResponseParser(DataCenterInfoResponseHandler.class)
   DataCenter updateDataCenter(@PayloadParam("dataCenter") DataCenter.Request.UpdatePayload updateRequest) throws HttpResponseException;

   /**
    * Removes all components from an existing Virtual Data Center.
    *
    * @param identifier Identifier of the virtual data center
    * @return Version response
    */
   @POST
   @Payload("<ws:clearDataCenter><dataCenterId>{id}</dataCenterId></ws:clearDataCenter>")
   @XMLResponseParser(DataCenterInfoResponseHandler.class)
   DataCenter clearDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * Deletes an Virtual Data Center. If a previous request on the target data center is still in progress, the data
    * center is going to be deleted after this request has been completed. Once a Data Center has been deleted, no
    * further request can be performed on it.
    *
    * @param identifier Identifier of the virtual data center
    */
   @POST
   @Payload("<ws:deleteDataCenter><dataCenterId>{id}</dataCenterId></ws:deleteDataCenter>")
   void deleteDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;

   public void updateDataCenter();
}
