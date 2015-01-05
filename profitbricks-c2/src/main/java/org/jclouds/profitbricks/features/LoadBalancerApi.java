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
import org.jclouds.profitbricks.binders.loadbalancer.CreateLoadBalancerRequestBinder;
import org.jclouds.profitbricks.binders.loadbalancer.DeregisterServersOnLoadBalancerRequestBinder;
import org.jclouds.profitbricks.binders.loadbalancer.RegisterServersOnLoadBalancerRequestBinder;
import org.jclouds.profitbricks.binders.loadbalancer.UpdateLoadBalancerRequestBinder;
import org.jclouds.profitbricks.domain.loadbalancer.create.CreateLbRequest;
import org.jclouds.profitbricks.domain.loadbalancer.create.CreateLoadBalancerResponse;
import org.jclouds.profitbricks.domain.loadbalancer.delete.DeleteLoadBalancerResponse;
import org.jclouds.profitbricks.domain.loadbalancer.deregister.DeregisterServersOnLoadBalancerResponse;
import org.jclouds.profitbricks.domain.loadbalancer.get.GetLoadBalancerResponse;
import org.jclouds.profitbricks.domain.loadbalancer.getall.GetAllLoadBalancersResponse;
import org.jclouds.profitbricks.domain.loadbalancer.register.RegisterServersOnLoadBalancerResponse;
import org.jclouds.profitbricks.domain.loadbalancer.register.ServerRegistrationOnLoadBalancerRequest;
import org.jclouds.profitbricks.domain.loadbalancer.update.UpdateLbRequest;
import org.jclouds.profitbricks.domain.loadbalancer.update.UpdateLoadBalancerResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * A Load Balancer connected to a LAN will not distribute traffic to any server, until it is specified to do so. In the
 * current version, a Load Balancer cannot distribute traffic across multiple data centers or LANs. Load Balancer and
 * servers must always be in the same LAN.
 *
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface LoadBalancerApi {

   /**
    * Creates a virtual Load Balancer within an existing virtual data center .
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("CreateLoadBalancer")
   @MapBinder(CreateLoadBalancerRequestBinder.class)
   @JAXBResponseParser
   CreateLoadBalancerResponse createLoadBalancer(
           @PayloadParam("loadbalancer") CreateLbRequest request) throws HttpResponseException;

   /**
    * Returns information about a virtual load balancer.
    *
    * @param id
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetLoadBalancer")
   @Payload("<ws:getLoadBalancer><loadBalancerId>{id}</loadBalancerId></ws:getLoadBalancer>")
   @JAXBResponseParser
   GetLoadBalancerResponse getLoadBalancer(@PayloadParam("id") String id) throws HttpResponseException;

   /**
    * Returns information about all virtual load balancer.
    *
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetAllLoadBalancers")
   @Payload("<ws:getAllLoadBalancers/>")
   @JAXBResponseParser
   GetAllLoadBalancersResponse getLoadBalancers() throws HttpResponseException;

   /**
    * Changes the settings of an existing virtual load balancer.
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("UpdateLoadBalancer")
   @MapBinder(UpdateLoadBalancerRequestBinder.class)
   @JAXBResponseParser
   UpdateLoadBalancerResponse updateLoadBalancer(
           @PayloadParam("loadbalancer") UpdateLbRequest request) throws HttpResponseException;

   /**
    * Adds new servers to an existing Load Balancer within the respective LAN. If the server is not yet a member of the
    * LAN, a new NIC is created, connected to the LAN and registered with the Load Balancer. The load balancer will
    * distribute traffic to the server through this balanced NIC. If the server is already a member of the LAN, the
    * appropriate NIC is used as balanced NIC. A server can be registered to more than one Load Balancer
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("RegisterServersOnLoadBalancer")
   @MapBinder(RegisterServersOnLoadBalancerRequestBinder.class)
   @JAXBResponseParser
   RegisterServersOnLoadBalancerResponse registerServersOnLoadBalancer(
           @PayloadParam("loadbalancer") ServerRegistrationOnLoadBalancerRequest request) throws HttpResponseException;

   /**
    * By deregistering a server, the server is being removed from the load balancer but still remains connected to the
    * same LAN. The primary IP address of the NIC, through which the load balancer distributed traffic to the server
    * before, is reset and replaced by a ProfitBricks assigned IP address.
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeregisterServersOnLoadBalancer")
   @MapBinder(DeregisterServersOnLoadBalancerRequestBinder.class)
   @JAXBResponseParser
   DeregisterServersOnLoadBalancerResponse deregisterServersOnLoadBalancer(
           @PayloadParam("loadbalancer") ServerRegistrationOnLoadBalancerRequest request) throws HttpResponseException;

   /**
    * Deletes an existing load balancer. Primary IP addresses of the server’s previously balanced NICs are reset and
    * replaced with ProfitBricks assigned IP address. If a load balancer has been deleted, all servers will still be
    * connected to the same LAN though.
    *
    * @param id
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeleteLoadBalancer")
   @Payload("<ws:deleteLoadBalancer><loadBalancerId>{id}</loadBalancerId></ws:deleteLoadBalancer>")
   @JAXBResponseParser
   DeleteLoadBalancerResponse deleteLoadBalancer(@PayloadParam("id") String id) throws HttpResponseException;
}
