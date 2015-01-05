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
import org.jclouds.profitbricks.binders.server.CreateServerRequestBinder;
import org.jclouds.profitbricks.binders.server.UpdateServerRequestBinder;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequest;
import org.jclouds.profitbricks.domain.server.create.CreateServerReturn;
import org.jclouds.profitbricks.domain.server.delete.DeleteServerResponse;
import org.jclouds.profitbricks.domain.server.get.GetServerResponse;
import org.jclouds.profitbricks.domain.server.getall.GetAllServersResponse;
import org.jclouds.profitbricks.domain.server.reset.ResetServerResponse;
import org.jclouds.profitbricks.domain.server.start.StartServerResponse;
import org.jclouds.profitbricks.domain.server.stop.StopServerResponse;
import org.jclouds.profitbricks.domain.server.update.UpdateServerRequest;
import org.jclouds.profitbricks.domain.server.update.UpdateServerResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Provides synchronous access to ProfitBricks's Server Operations API.
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface ServerApi {

   /**
    * Returns information about all virtual server, such as configuration, provisioning status, power status, etc.
    *
    * @return servers in your cloud data centers or empty if there are none
    */
   @POST
   @Named("GetAllServers")
   @Payload("<ws:getAllServers/>")
   @JAXBResponseParser
   GetAllServersResponse getAllServers() throws HttpResponseException;

   /**
    * Returns information about a virtual server, such as configuration, provisioning status, power status, etc.
    *
    * @param serverId server identificator
    * @return an existing {@link Server} or {@code null}
    */
   @POST
   @Named("GetServer")
   @Payload("<ws:getServer><serverId>{id}</serverId></ws:getServer>")
   @JAXBResponseParser
   GetServerResponse getServer(@PayloadParam("id") String serverId) throws HttpResponseException;

   /**
    * Creates a Virtual Server.
    *
    * @param server server entity to create
    * @return server identifier or {@code null} if creation is failed
    */
   @POST
   @Named("CreateServer")
   @MapBinder(CreateServerRequestBinder.class)
   @JAXBResponseParser
   CreateServerReturn createServer(@PayloadParam("server") CreateServerRequest server) throws HttpResponseException;

   /**
    * Updates parameters of an existing virtual server device.
    *
    * @param server Server entity to update, using existing server id
    * @return Data center version response, if success
    */
   @POST
   @Named("UpdateServer")
   @MapBinder(UpdateServerRequestBinder.class)
   @JAXBResponseParser
   UpdateServerResponse updateServer(@PayloadParam("server") UpdateServerRequest server) throws HttpResponseException;

   /**
    * Deletes an existing Virtual Server.
    *
    * @param serverId Identifier of the target virtual server
    * @return Data center version response, if success
    */
   @POST
   @Named("DeleteServer")
   @Payload("<ws:deleteServer><serverId>{id}</serverId></ws:deleteServer>")
   @JAXBResponseParser
   DeleteServerResponse deleteServer(@PayloadParam("id") String serverId) throws HttpResponseException;

   /**
    * Resets an existing virtual server (POWER CYCLE).
    * <ul>
    * <li>Server will be forcefully powered off and restarted immediately. Any unsaved data may be lost! </li>
    * <li>Billing will continue</li>
    * </ul>
    *
    * @param serverId Identifier of the target virtual server
    * @return Request identifier of server reset request
    */
   @POST
   @Named("ResetServer")
   @Payload("<ws:resetServer><serverId>{id}</serverId></ws:resetServer>")
   @JAXBResponseParser
   ResetServerResponse resetServer(@PayloadParam("id") String serverId) throws HttpResponseException;

   /**
    * Starts an existing virtual server.
    * <ul>
    * <li>Server may receive new public IP addresses if necessary</li>
    * <li>Billing will continue</li>
    * </ul>
    *
    * @param serverId Identifier of the target virtual server
    * @return Request identifier of server start request
    */
   @POST
   @Named("StartServer")
   @Payload("<ws:startServer><serverId>{id}</serverId></ws:startServer>")
   @JAXBResponseParser
   StartServerResponse startServer(@PayloadParam("id") String serverId) throws HttpResponseException;

   /**
    * Stops an existing virtual server forcefully (HARD stop)
    * <ul>
    * <li>Server will be forcefully powered off. Any unsaved data may be lost!</li>
    * <li>Billing for this server will be stopped</li>
    * <li>When restarting the server a new public IP gets assigned, alternatively, you can reserve IP addresses, see
    * {@link PublicIPApi#reservePublicIpBlock(int) reservePublicIpBlock} </li>
    * </ul>
    *
    * @param serverId
    * @return
    */
   @POST
   @Named("StopServer")
   @Payload("<ws:stopServer><serverId>{id}</serverId></ws:stopServer>")
   @JAXBResponseParser
   StopServerResponse stopServer(@PayloadParam("id") String serverId) throws HttpResponseException;

}
