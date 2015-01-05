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
package org.jclouds.profitbricks.config;

import org.jclouds.compute.ComputeServiceAdapter;
import org.jclouds.compute.config.ComputeServiceAdapterContextModule;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.domain.Volume;
import org.jclouds.domain.Location;
import org.jclouds.functions.IdentityFunction;
import org.jclouds.profitbricks.compute.PBComputeServiceAdapter;
import org.jclouds.profitbricks.domain.datacenter.DataCenter;
import org.jclouds.profitbricks.domain.image.Image;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequest;
import org.jclouds.profitbricks.domain.storage.connect.ConnectedStorage;
import org.jclouds.profitbricks.functions.ConnectedStorageToVolume;
import org.jclouds.profitbricks.functions.DcToLocation;
import org.jclouds.profitbricks.functions.PBImageToImage;
import org.jclouds.profitbricks.functions.ServerToNodeMetadata;
import org.jclouds.profitbricks.functions.TemplateToNewServer;

import com.google.common.base.Function;
import com.google.inject.TypeLiteral;

/**
 * Configuration module with bindings to setup ProfitBricks {@link ComputeServiceAdapter}.
 */
public class PBComputeServiceAdapterContextModule
        extends ComputeServiceAdapterContextModule<Server, Hardware, Image, DataCenter> {

   @SuppressWarnings("unchecked")
   @Override
   protected void configure() {
      super.configure();

      bind(new TypeLiteral<ComputeServiceAdapter<Server, Hardware, Image, DataCenter>>() {
      }).to(PBComputeServiceAdapter.class);

      bind(new TypeLiteral<Function<Server, NodeMetadata>>() {
      }).to(Class.class.cast(ServerToNodeMetadata.class));

      bind(new TypeLiteral<Function<ConnectedStorage, Volume>>() {
      }).to(Class.class.cast(ConnectedStorageToVolume.class));

      bind(new TypeLiteral<Function<Template, CreateServerRequest>>() {
      }).to(Class.class.cast(TemplateToNewServer.class));

      bind(new TypeLiteral<Function<Image, org.jclouds.compute.domain.Image>>() {
      }).to(Class.class.cast(PBImageToImage.class));

      bind(new TypeLiteral<Function<Hardware, Hardware>>() {
      }).to(Class.class.cast(IdentityFunction.class));

      bind(new TypeLiteral<Function<DataCenter, Location>>() {
      }).to(Class.class.cast(DcToLocation.class));

      install(new LocationsFromComputeServiceAdapterModule<Server, Hardware, Image, DataCenter>() {
      });
   }
}
