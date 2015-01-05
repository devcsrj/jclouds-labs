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

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jclouds.http.HttpResponseException;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.profitbricks.binders.firewall.ActivateFirewallsRequestBinder;
import org.jclouds.profitbricks.binders.firewall.AddFirewallRulesToNicRequestBinder;
import org.jclouds.profitbricks.binders.firewall.DeactivateFirewallsRequestBinder;
import org.jclouds.profitbricks.binders.firewall.DeleteFirewallsRequestBinder;
import org.jclouds.profitbricks.binders.firewall.RemoveFirewallRulesRequestBinder;
import org.jclouds.profitbricks.domain.firewall.activate.ActivateFirewallsResponse;
import org.jclouds.profitbricks.domain.firewall.add.AddFirewallRulesToNic;
import org.jclouds.profitbricks.domain.firewall.add.AddFirewallRulesToNicResponse;
import org.jclouds.profitbricks.domain.firewall.deactivate.DeactivateFirewallsResponse;
import org.jclouds.profitbricks.domain.firewall.delete.DeleteFirewallsResponse;
import org.jclouds.profitbricks.domain.firewall.get.GetFirewallResponse;
import org.jclouds.profitbricks.domain.firewall.getall.GetAllFirewallsResponse;
import org.jclouds.profitbricks.domain.firewall.remove.RemoveFirewallRulesResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Provides synchronous access to ProfitBricks's PublicIp Operations API.
 *
 * All firewall rules are accept-rules. An active firewall will only allow traffic following the user defined rules. An
 * active firewall with no accept-rules, will drop all traffic. An inactive firewall will allow all traffic.
 *
 * ARP packets are always accepted.
 *
 * Incoming packets replied to outgoing packets are always accepted.
 *
 * <em>IMPORTANT:</em> No firewall rules should be placed between a load balancer and its load balanced servers.
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface FirewallApi {

   /**
    * Adds accept-rules to the firewall of a given NIC. If no firewall exists, a new inactive firewall is created.
    * Firewalls can be activated / deactivated; additional accept-rules can be added anytime
    *
    * @param rules
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("AddFirewallRulesToNic")
   @MapBinder(AddFirewallRulesToNicRequestBinder.class)
   @JAXBResponseParser
   AddFirewallRulesToNicResponse addFirewallRulesToNic(
           @PayloadParam("firewall") AddFirewallRulesToNic rules) throws HttpResponseException;

   /**
    * Returns information about the respective firewall. Each rule has an identifier for later modification. To get fi -
    * rewall of a given NIC, see also Get NIC
    *
    * @param firewallId
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetFirewall")
   @Payload("<ws:getFirewall><firewallId>{id}</firewallId></ws:getFirewall>")
   @JAXBResponseParser
   GetFirewallResponse getFirewall(@PayloadParam("id") String firewallId) throws HttpResponseException;

   /**
    * Returns information about all configured firewall. Each rule has an identifier for later modification. To get fi -
    * rewall of a given NIC, see also Get NIC
    *
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("GetAllFirewalls")
   @Payload("<ws:getAllFirewalls/>")
   @JAXBResponseParser
   GetAllFirewallsResponse getAllFirewalls() throws HttpResponseException;

   /**
    * Removes firewall rule(s) by specifying their identifiers. See also getFirewall() or getNic() to retrieve
    * identifiers of firewall rules.
    *
    * @param firewallRuleIds
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("RemoveFirewallRules")
   @MapBinder(RemoveFirewallRulesRequestBinder.class)
   @JAXBResponseParser
   RemoveFirewallRulesResponse removeFirewallRules(
           @PayloadParam("firewall") List<String> firewallRuleIds) throws HttpResponseException;

   /**
    * Activates one or several firewall(s) of a given data center
    *
    * @param firewallIds
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("ActivateFirewalls")
   @MapBinder(ActivateFirewallsRequestBinder.class)
   @JAXBResponseParser
   ActivateFirewallsResponse activateFirewalls(
           @PayloadParam("firewall") List<String> firewallIds) throws HttpResponseException;

   /**
    * Deactivates one or several firewall(s) of a given data center
    *
    * @param firewallIds
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeactivateFirewalls")
   @MapBinder(DeactivateFirewallsRequestBinder.class)
   @JAXBResponseParser
   DeactivateFirewallsResponse deactivateFirewalls(
           @PayloadParam("firewall") List<String> firewallIds) throws HttpResponseException;

   /**
    * Deletes one or several firewall(s) of a given data center
    *
    * @param firewallIds
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeleteFirewalls")
   @MapBinder(DeleteFirewallsRequestBinder.class)
   @JAXBResponseParser
   DeleteFirewallsResponse deleteFirewalls(
           @PayloadParam("firewall") List<String> firewallIds) throws HttpResponseException;
}
