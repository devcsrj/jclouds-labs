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
import org.jclouds.profitbricks.binders.romdrive.AddRomDriveToServerRequestBinder;
import org.jclouds.profitbricks.domain.romdrive.RomDriveRequest;
import org.jclouds.profitbricks.domain.romdrive.add.AddRomDriveToServerResponse;
import org.jclouds.profitbricks.domain.romdrive.remove.RemoveRomDriveFromServerResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface RomDriveApi {

   /**
    * Adds a CD-ROM/DVD drive to an existing virtual server. Maximum CD-ROM/DVD Drives are currently 2
    *
    * A CD-ROM/DVD drive is identified by its CD-ROM/DVD (ISO) image and therefore have the same ID. Before a CD-ROM/DVD
    * (ISO) image can be assigned to a server , it must be uploa- ded on the associated FTP server
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("AddRomDriveToServer")
   @MapBinder(AddRomDriveToServerRequestBinder.class)
   @JAXBResponseParser
   AddRomDriveToServerResponse addRomDriveToServer(
           @PayloadParam("romdrive") RomDriveRequest request) throws HttpResponseException;

   /**
    * Removes a CD-ROM/DVD drive from an existing virtual server.
    *
    * A CD-ROM/DVD drive is always identified by its CD-ROM/DVD (ISO) image ID.
    *
    * @param imageId
    * @param serverId
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("RemoveRomDriveFromServer")
   @Payload("<ws:removeRomDriveFromServer><imageId>{imageId}</imageId><serverId>{serverId}</serverId></ws:removeRomDriveFromServer>")
   @JAXBResponseParser
   RemoveRomDriveFromServerResponse removeRomDriveToServer(
           @PayloadParam("imageId") String imageId, @PayloadParam("serverId") String serverId) throws HttpResponseException;

}
