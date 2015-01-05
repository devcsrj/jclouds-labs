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
import org.jclouds.profitbricks.binders.nic.CreateNicRequestBinder;
import org.jclouds.profitbricks.binders.nic.UpdateNicRequestBinder;
import org.jclouds.profitbricks.domain.nic.create.CreateNicRequest;
import org.jclouds.profitbricks.domain.nic.create.CreateNicReturn;
import org.jclouds.profitbricks.domain.nic.delete.DeleteNicResponse;
import org.jclouds.profitbricks.domain.nic.get.GetNicResponse;
import org.jclouds.profitbricks.domain.nic.getall.GetAllNicResponse;
import org.jclouds.profitbricks.domain.nic.setinternet.SetInternetAccessResponse;
import org.jclouds.profitbricks.domain.nic.update.UpdateNicRequest;
import org.jclouds.profitbricks.domain.nic.update.UpdateNicResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * ProfitBricks currently only supports Internet Protocol Version 4 (IPv4).
 *
 * The user can specify and assign local IPs manually to a PARAM, which is connected to a Private LAN. Valid IP
 * addresses for Private LANs are 10.0.0.0/8, 172.16.0.0/12 or 192.168.0.0/16.
 *
 * In a Public LAN, a random DHCP IP address is assigned to each connected PARAM by default. This IP Address is
 * automatically generated and will change eventually, e.g. during a server reboot or while disconnecting and
 * reconnecting a LAN to the internet.
 *
 * For assigning a static IP to a PARAM, it is necessary to supply a reserved public IP address. Public IP Addresses can
 * be reserved block-wise and manually assigned to a PARAM by the user.
 *
 * @see ReserverPublicIPBlock
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface NicApi {

   /**
    * Creates a PARAM on an existing virtual server
    *
    * @param nic A PARAM with LAN ID = 0 can be created but will not be connected to any LANs.
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("CreateNic")
   @MapBinder(CreateNicRequestBinder.class)
   @JAXBResponseParser
   CreateNicReturn createNic(@PayloadParam("nic") CreateNicRequest nic) throws HttpResponseException;

   /**
    * Returns information about the state and configuration of an existing PARAM.
    *
    * @param identifier
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetNic")
   @Payload("<ws:getNic><nicId>{id}</nicId></ws:getNic>")
   @JAXBResponseParser
   GetNicResponse getNic(@PayloadParam("id") String identifier) throws HttpResponseException;

   /**
    * Returns information about the state and configuration of all existing NICs.
    *
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetAllNic")
   @Payload("<ws:getAllNic/>")
   @JAXBResponseParser
   GetAllNicResponse getAllNic() throws HttpResponseException;

   /**
    * Connects an existing PARAM to a public LAN to get internet access.
    *
    * @param dataCenterId
    * @param lanId
    * @param internetAccess
    * @return
    */
   @POST
   @Named("SetInternetAccess")
   @Payload("<ws:setInternetAccess><dataCenterId>{dcId}</dataCenterId><lanId>{lanId}</lanId><internetAccess>{hasInternet}</internetAccess></ws:setInternetAccess>")
   @JAXBResponseParser
   SetInternetAccessResponse setInternetAccess(@PayloadParam("dcId") String dataCenterId,
           @PayloadParam("lanId") int lanId, @PayloadParam("hasInternet") boolean internetAccess);

   /**
    * Changes the settings of an existing PARAM.
    *
    * @param nic
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("UpdateNic")
   @MapBinder(UpdateNicRequestBinder.class)
   @JAXBResponseParser
   UpdateNicResponse updateNic(@PayloadParam("nic") UpdateNicRequest nic) throws HttpResponseException;

   /**
    * Deletes an existing PARAM.
    *
    * @param identifier
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeleteNic")
   @Payload("<ws:deleteNic><nicId>{id}</nicId></ws:deleteNic>")
   @JAXBResponseParser
   DeleteNicResponse deleteNic(@PayloadParam("id") String identifier) throws HttpResponseException;
}
