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
import org.jclouds.profitbricks.binders.snapshot.CreateSnapshotRequestBinder;
import org.jclouds.profitbricks.binders.snapshot.RollbackSnapshotRequestBinder;
import org.jclouds.profitbricks.binders.snapshot.UpdateSnapshotRequestBinder;
import org.jclouds.profitbricks.domain.snapshot.create.CreateSnapshotRequest;
import org.jclouds.profitbricks.domain.snapshot.create.CreateSnapshotReturn;
import org.jclouds.profitbricks.domain.snapshot.delete.DeleteSnapshotResponse;
import org.jclouds.profitbricks.domain.snapshot.get.GetSnapshotResponse;
import org.jclouds.profitbricks.domain.snapshot.getall.GetAllSnapshotsResponse;
import org.jclouds.profitbricks.domain.snapshot.rollback.RollbackSnapshotRequest;
import org.jclouds.profitbricks.domain.snapshot.rollback.RollbackSnapshotResponse;
import org.jclouds.profitbricks.domain.snapshot.update.UpdateSnapshotRequest;
import org.jclouds.profitbricks.domain.snapshot.update.UpdateSnapshotResponse;
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
public interface SnapshotApi {

   /**
    * Provides a list of all snapshots available to this account
    *
    * @return Set of snapshots
    */
   @POST
   @Named("GetAllSnapshots")
   @Payload("<ws:getAllSnapshots/>")
   @JAXBResponseParser
   GetAllSnapshotsResponse getAllSnapshots() throws HttpResponseException;

   /**
    * Returns information about a particular Snapshot
    *
    * @param snapshotId
    * @return Snapshot information
    */
   @POST
   @Named("GetSnapshot")
   @Payload("<ws:getSnapshot><snapshotId>{id}</snapshotId></ws:getSnapshot>")
   @JAXBResponseParser
   GetSnapshotResponse getSnapshot(@PayloadParam("id") String snapshotId) throws HttpResponseException;

   /**
    * Creates a snapshot of an existing storage device. The size of the snapshot will be the same as the size of the
    * storage it was taken from independent of how much of it is in use. Any snapshot will be charged to your account
    * and billed like an HD storage of the same size.
    *
    * Attention: A snapshot only includes the contents of the storage but not the state of the VM connected to it.
    *
    * @param snapshot payload containing storageId(required), snapshotName, description
    * @return Snapshot identifier
    */
   @POST
   @Named("CreateSnapshot")
   @MapBinder(CreateSnapshotRequestBinder.class)
   @JAXBResponseParser
   CreateSnapshotReturn createSnapshot(
           @PayloadParam("snapshot") CreateSnapshotRequest snapshot) throws HttpResponseException;

   /**
    * Updates meta data of a snapshot. This meta data can be relevant as they trigger other features like Live Vertical
    * Scaling of CPU or RAM.
    *
    * @param snapshot payload containing snapshotId(required), description, etc
    * @return Request identifier
    */
   @POST
   @Named("UpdateSnapshot")
   @MapBinder(UpdateSnapshotRequestBinder.class)
   @JAXBResponseParser
   UpdateSnapshotResponse updateSnapshot(
           @PayloadParam("snapshot") UpdateSnapshotRequest snapshot) throws HttpResponseException;

   /**
    * Deletes a snapshot. Please be aware that deleted snapshots and related data in this snapshot cannot be recovered
    * anymore.
    *
    * @param snapshotId Identifier of the snapshot that shall get deleted
    * @return Request identifier
    */
   @POST
   @Named("DeleteSnapshot")
   @Payload("<ws:deleteSnapshot><snapshotId>{id}</snapshotId></ws:deleteSnapshot>")
   @JAXBResponseParser
   DeleteSnapshotResponse deleteSnapshot(@PayloadParam("id") String snapshotId) throws HttpResponseException;

   /**
    * Using the rollback option you may redeploy the snapshotted state on a storage.
    *
    * Attention: The current state of the storage will be lost unless you create another snapshot before rolling back.
    *
    * @param snapshot payload containing storageId, snapshotId (both required)
    * @return Version response
    */
   @POST
   @Named("RollbackSnapshot")
   @MapBinder(RollbackSnapshotRequestBinder.class)
   @JAXBResponseParser
   RollbackSnapshotResponse rollbackSnapshot(@PayloadParam("snapshot") RollbackSnapshotRequest snapshot) throws HttpResponseException;
}
