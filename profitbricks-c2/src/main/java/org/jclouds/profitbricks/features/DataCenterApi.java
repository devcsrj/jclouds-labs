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

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.http.HttpResponseException;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.profitbricks.binders.datacenter.CreateDataCenterRequestBinder;
import org.jclouds.profitbricks.binders.datacenter.UpdateDataCenterRequestBinder;
import org.jclouds.profitbricks.domain.datacenter.clear.ClearDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.create.CreateDataCenterRequest;
import org.jclouds.profitbricks.domain.datacenter.create.CreateDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.delete.DeleteDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.get.GetDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.getall.GetAllDataCentersResponse;
import org.jclouds.profitbricks.domain.datacenter.state.GetDataCenterStateResponse;
import org.jclouds.profitbricks.domain.datacenter.update.UpdateDataCenterResponse;
import org.jclouds.profitbricks.domain.datacenter.update.UpdateDcRequest;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Provides synchronous access to ProfitBricks's Virtual Data Center Operations API.
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface DataCenterApi {

   /**
    *
    * @return Returns a list of all Virtual Data Centers created by the user, including ID, name and version number.
    */
   @POST
   @Named("GetAllDataCenters")
   @Payload("<ws:getAllDataCenters/>")
   @JAXBResponseParser
   GetAllDataCentersResponse getAllDataCenters() throws HttpResponseException;

   /**
    *
    * @param identifier Virtual Data Center identifier
    * @return Returns information about an existing virtual data center's state and configuration.
    */
   @POST
   @Named("GetDataCenter")
   @Payload("<ws:getDataCenter><dataCenterId>{id}</dataCenterId></ws:getDataCenter>")
   @JAXBResponseParser
   GetDataCenterResponse getDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * This is a lightweight function for polling the current provisioning state of the Virtual Data Center. It is
    * recommended to use this function for large Virtual Data Centers to query request results.
    *
    * @param identifier
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetDataCenterState")
   @Payload("<ws:getDataCenterState><dataCenterId>{id}</dataCenterId></ws:getDataCenterState>")
   @JAXBResponseParser
   GetDataCenterStateResponse getDataCenterState(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * Creates and saves a new, empty Virtual Data Center. Returns its identifier for further reference.
    *
    * @param vdc VDC payload containing dataCenterName, region (both optional)
    * @return Version response
    */
   @POST
   @Named("CreateDataCenter")
   @MapBinder(CreateDataCenterRequestBinder.class)
   @JAXBResponseParser
   CreateDataCenterResponse createDataCenter(
           @PayloadParam("datacenter") CreateDataCenterRequest vdc) throws HttpResponseException;

   /**
    * Updates the information associated to an existing Virtual Data Center.
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("UpdateDataCenter")
   @MapBinder(UpdateDataCenterRequestBinder.class)
   @JAXBResponseParser
   UpdateDataCenterResponse updateDataCenter(
           @PayloadParam("datacenter") UpdateDcRequest request) throws HttpResponseException;

   /**
    * Removes all components from an existing Virtual Data Center.
    *
    * @param identifier Identifier of the virtual data center
    * @return Version response
    */
   @POST
   @Named("ClearDataCenter")
   @Payload("<ws:clearDataCenter><dataCenterId>{id}</dataCenterId></ws:clearDataCenter>")
   @JAXBResponseParser
   ClearDataCenterResponse clearDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * Deletes an Virtual Data Center. If a previous request on the target data center is still in progress, the data
    * center is going to be deleted after this request has been completed. Once a Data Center has been deleted, no
    * further request can be performed on it.
    *
    * @param identifier Identifier of the virtual data center
    * @return Version response
    */
   @POST
   @Named("DeleteDataCenter")
   @Payload("<ws:deleteDataCenter><dataCenterId>{id}</dataCenterId></ws:deleteDataCenter>")
   @JAXBResponseParser
   DeleteDataCenterResponse deleteDataCenter(@PayloadParam("id") String identifier) throws HttpResponseException;
}
