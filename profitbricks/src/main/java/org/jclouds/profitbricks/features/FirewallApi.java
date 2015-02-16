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
import org.jclouds.Fallbacks;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.profitbricks.binder.firewall.AddFirewallRuleToNicRequestBinder;
import org.jclouds.profitbricks.domain.Firewall;
import org.jclouds.profitbricks.http.filters.ProfitBricksSoapMessageEnvelope;
import org.jclouds.profitbricks.http.parser.firewall.FirewallListResponseHandler;
import org.jclouds.profitbricks.http.parser.firewall.FirewallResponseHandler;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.XMLResponseParser;
import org.jclouds.rest.annotations.Fallback;

@RequestFilters({BasicAuthentication.class, ProfitBricksSoapMessageEnvelope.class})
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface FirewallApi {

    @POST
    @Named("firewall:get")
    @Payload("<ws:getFirewall><firewallId>{id}</firewallId></ws:getFirewall>")
    @XMLResponseParser(FirewallResponseHandler.class)
    @Fallback(Fallbacks.NullOnNotFoundOr404.class)
    Firewall getFirewall(@PayloadParam("id") String identifier);

    @POST
    @Named("firewall:getall")
    @Payload("<ws:getAllFirewalls/>")
    @XMLResponseParser(FirewallListResponseHandler.class)
    @Fallback(Fallbacks.EmptyListOnNotFoundOr404.class)
    List<Firewall> getAllFirewalls();

    @POST
    @Named("firewall:create")
    @MapBinder(AddFirewallRuleToNicRequestBinder.class)
    @XMLResponseParser(FirewallResponseHandler.class)
    Firewall addFirewallRuleToNic(@PayloadParam("firewall") Firewall.Request.AddFirewallRulePayload payload);

    @POST
    @Named("firewall:remove")
    @Payload("<ws:removeFirewallRules><firewallRuleIds>{id}</firewallRuleIds></ws:removeFirewallRules>")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean removeFirewall(@PayloadParam("id") String id);

    @POST
    @Named("firewall:activate")
    @Payload("<ws:activateFirewalls><firewallIds>{id}</firewallIds></ws:activateFirewalls>")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean activateFirewall(@PayloadParam("id") String id);

    @POST
    @Named("firewall:activate")
    @Payload("<ws:deactivateFirewalls><firewallIds>{id}</firewallIds></ws:deactivateFirewalls>")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean deactivateFirewall(@PayloadParam("id") String id);

    @POST
    @Named("firewall:activate")
    @Payload("<ws:deleteFirewalls><firewallIds>{id}</firewallIds></ws:deleteFirewalls>")
    @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
    boolean deleteFirewall(@PayloadParam("id") String id);
}
