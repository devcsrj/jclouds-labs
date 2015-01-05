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
import org.jclouds.profitbricks.domain.notification.delete.DeleteNotificationsResponse;
import org.jclouds.profitbricks.domain.notification.get.GetNotificationsResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Used to access notifications the system sends to signal specific events. These event often require user interaction,
 * so the current notifications should be checked frequently .
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface UserNotificationApi {

   /**
    * Gets all current (not deleted) user notifications. User notifications are created by the system to inform users
    * about different events concerning e.g. their data centers. Notifications stay in the queue until deleted (see
    * deleteNotifications), so a notification may be read repeatedly with getNotifications
    *
    * @param networkUUID Uuid of the network the notification refers to
    * @return
    */
   @POST
   @Named("GetNotifications")
   @Payload("<ws:getNotifications><networkUUID>{id}</networkUUID></ws:getNotifications>")
   @JAXBResponseParser
   GetNotificationsResponse getNotifications(@PayloadParam("id") String networkUUID) throws HttpResponseException;

   /**
    * Deletes the notifications with the given ids. (TODO Zero or more repetition of Ids)
    *
    * @param notificationId Id of a notification to delete
    * @return
    */
   @POST
   @Named("DeleteNotifications")
   @Payload("<ws:deleteNotifications><notificationId>{id}</notificationId></ws:deleteNotifications>")
   @JAXBResponseParser
   DeleteNotificationsResponse deleteNotifications(@PayloadParam("id") String notificationId) throws HttpResponseException;

}
