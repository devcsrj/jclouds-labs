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
import org.jclouds.profitbricks.binders.publicip.CreateReservePublicIpBlockRequestBinder;
import org.jclouds.profitbricks.domain.publicip.add.AddPublicIpToNicResponse;
import org.jclouds.profitbricks.domain.publicip.get.GetPublicIpBlockResponse;
import org.jclouds.profitbricks.domain.publicip.getall.GetAllPublicIpBlocksResponse;
import org.jclouds.profitbricks.domain.publicip.release.ReleasePublicIpBlockResponse;
import org.jclouds.profitbricks.domain.publicip.remove.RemovePublicIpFromNicResponse;
import org.jclouds.profitbricks.domain.publicip.reserve.CreateReservePublicIpBlockRequest;
import org.jclouds.profitbricks.domain.publicip.reserve.ReservePublicIpBlockResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Provides synchronous access to ProfitBricks's PublicIp Operations API.
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface PublicIpApi {

   /**
    * Reserves a specific amount of public IPs which can be manually assigned to a NIC by the user
    *
    * @param reservation
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("ReservePublicIpBlock")
   @MapBinder(CreateReservePublicIpBlockRequestBinder.class)
   @JAXBResponseParser
   ReservePublicIpBlockResponse reservePublicIpBlock(
           @PayloadParam("publicip") CreateReservePublicIpBlockRequest reservation) throws HttpResponseException;

   /**
    * Adds an existing reserved public IP to a NIC. This operation is required, when dealing with reserved public IPs to
    * ensure proper routing by the ProfitBricks cloud networking layer .
    *
    * As Load Balancer and the balanced NIC of the server are only allowed to share one single IP address, this
    * operation is disabled for the NICs of all balanced servers. To assign additional IP Address(es) to a balanced
    * server, an additional NIC can be created on the respective server, to which the Public IP(s) can then be added
    *
    * @param ip Reserved IP
    * @param nic Identifier of the target NIC
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("AddPublicIpToNic")
   @Payload("<ws:addPublicIpToNic><ip>{ip}</ip><nicId>{nic}</nicId></ws:addPublicIpToNic>")
   @JAXBResponseParser
   AddPublicIpToNicResponse addPublicIpToNic(
           @PayloadParam("ip") String ip, @PayloadParam("nic") String nic) throws HttpResponseException;

   /**
    * Returns reserved IPs and connected NICs of a particular public IP block
    *
    * @param blockId Identifier of the IP block
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetPublicIpBlock")
   @Payload("<ws:getPublicIpBlock><blockId>{id}</blockId></ws:getPublicIpBlock>")
   @JAXBResponseParser
   GetPublicIpBlockResponse getPublicIpBlock(@PayloadParam("id") String blockId) throws HttpResponseException;

   /**
    * Returns a list of all public IP blocks reserved by the user, including the reserved IPs and connected NICs
    *
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetAllPublicIpBlocks")
   @Payload("<ws:getAllPublicIpBlocks/>")
   @JAXBResponseParser
   GetAllPublicIpBlocksResponse getAllPublicIpBlock() throws HttpResponseException;

   /**
    * Removes a reserved public IP from a NIC. This operation is required, when dealing with reserved public IPs to
    * ensure proper routing by the ProfitBricks cloud networking layer.
    *
    * @param ip IP address
    * @param nic Identifier of the target NIC
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("RemovePublicIpFromNic")
   @Payload("<ws:removePublicIpFromNic><ip>{ip}</ip><nicId>{nic}</nicId></ws:removePublicIpFromNic>")
   @JAXBResponseParser
   RemovePublicIpFromNicResponse removePublicIpFromNic(
           @PayloadParam("ip") String ip, @PayloadParam("nic") String nic) throws HttpResponseException;

   /**
    * Releases an existing block of reserved public IPs
    *
    * <em>IMPORTANT!</em> Before releasing an IP block, please ensure that no IP address in the respective IP block is
    * assigned to a NIC anymore. Otherwise the operation will fail
    *
    * @param blockId Identifier of the reserved IP block
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("ReleasePublicIpBlock")
   @Payload("<ws:releasePublicIpBlock><blockId>{id}</blockId></ws:releasePublicIpBlock>")
   @JAXBResponseParser
   ReleasePublicIpBlockResponse releasePublicIpBlock(@PayloadParam("id") String blockId) throws HttpResponseException;

}
