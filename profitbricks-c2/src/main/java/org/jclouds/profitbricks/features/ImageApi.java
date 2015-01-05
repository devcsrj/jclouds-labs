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
import org.jclouds.profitbricks.binders.image.SetImageOsTypeRequestBinder;
import org.jclouds.profitbricks.binders.image.UpdateImageRequestBinder;
import org.jclouds.profitbricks.domain.image.delete.DeleteImageResponse;
import org.jclouds.profitbricks.domain.image.get.GetImageResponse;
import org.jclouds.profitbricks.domain.image.getall.GetAllImagesResponse;
import org.jclouds.profitbricks.domain.image.setostype.ImageOsTypeRequest;
import org.jclouds.profitbricks.domain.image.setostype.SetImageOsTypeResponse;
import org.jclouds.profitbricks.domain.image.update.UpdateImageRequest;
import org.jclouds.profitbricks.domain.image.update.UpdateImageResponse;
import org.jclouds.profitbricks.filters.PBSoapMessageEnvelope;
import org.jclouds.rest.annotations.JAXBResponseParser;
import org.jclouds.rest.annotations.MapBinder;
import org.jclouds.rest.annotations.Payload;
import org.jclouds.rest.annotations.PayloadParam;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.VirtualHost;

/**
 * Provides synchronous access to ProfitBricks's Image Operations API.
 */
@RequestFilters({BasicAuthentication.class, PBSoapMessageEnvelope.class})
@VirtualHost
@Consumes(MediaType.TEXT_XML)
@Produces(MediaType.TEXT_XML)
public interface ImageApi {

   /**
    *
    * @return A set of all HDD and/or CD-ROM/DVD images existing on or uploaded to the ProfitBricks FTP server.
    */
   @POST
   @Named("GetAllImages")
   @Payload("<ws:getAllImages/>")
   @JAXBResponseParser
   GetAllImagesResponse getAllImages() throws HttpResponseException;

   /**
    *
    * @param imageId Image identifier
    * @return Returns information about a HDD or CD-ROM/DVD (ISO) image.
    */
   @POST
   @Named("GetImage")
   @Payload("<ws:getImage><imageId>{id}</imageId></ws:getImage>")
   @JAXBResponseParser
   GetImageResponse getImage(@PayloadParam("id") String imageId) throws HttpResponseException;

   /**
    * Updates information about a HDD or CD-ROM/DVD (ISO) image.
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("UpdateImage")
   @MapBinder(UpdateImageRequestBinder.class)
   @JAXBResponseParser
   UpdateImageResponse updateImage(@PayloadParam("image") UpdateImageRequest request) throws HttpResponseException;

   /**
    * Sets the OS Type of an individual HDD and/or CD-ROM/DVD image that has been uploaded on the Profit - Bricks FTP
    * server.
    *
    * The default OS Type of an uploaded image is UNKNOWN. Due to Microsoft’s terms and conditions, the user has to set
    * the OS Type of an uploaded Windows image to WINDOWS and therewith accepts the terms and conditions as well as the
    * pricing. Any server that is booted from the image will inherit the OS Type of the image automatically.
    *
    * @param request
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("SetImageOsType")
   @MapBinder(SetImageOsTypeRequestBinder.class)
   @JAXBResponseParser
   SetImageOsTypeResponse setImageOsType(@PayloadParam("image") ImageOsTypeRequest request) throws HttpResponseException;

   /**
    * Deletes an image. Please be aware that deleted images and related data in this image cannot be recovered anymore.
    *
    * @param imageId
    * @return
    * @throws HttpResponseException
    */
   @POST
   @Named("DeleteImage")
   @Payload("<ws:deleteImage><imageId>{id}</imageId></ws:deleteImage>")
   @JAXBResponseParser
   DeleteImageResponse deleteImage(@PayloadParam("id") String imageId) throws HttpResponseException;
}
