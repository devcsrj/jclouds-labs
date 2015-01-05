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
package org.jclouds.profitbricks.functions;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.jclouds.compute.domain.HardwareBuilder;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.NodeMetadataBuilder;
import org.jclouds.compute.domain.Processor;
import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.VirtualMachineState;
import static org.jclouds.profitbricks.functions.PBEnumMapper.mapPhysicalLocation;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/**
 * Unit test for {@link ServerToNodeMetadata} class
 */
@Test(groups = "unit", testName = "ServerToNodeMetadataTest")
public class ServerToNodeMetadataTest {

   @Test
   public void testConvert() {
      Server server = Server.describingBuilder()
              .dataCenterId("qazwsxedc1234567890")
              .serverId("qwertyuiop")
              .serverName("random-server")
              .cores(2)
              .ram(2048)
              .internetAccess(true)
              .availabilityZone(AvailabilityZone.AUTO)
              .virtualMachineState(VirtualMachineState.RUNNING)
              .provisioningState(ProvisioningState.AVAILABLE)
              .build();

      NodeMetadata node = new NodeMetadataBuilder()
              .ids("qwertyuiop")
              .name("random-server")
              .status(NodeMetadata.Status.RUNNING)
              .location(
                      new LocationBuilder()
                      .id("qazwsxedc1234567890")
                      .description("qazwsxedc1234567890")
                      .scope(LocationScope.REGION)
                      .parent(mapPhysicalLocation(org.jclouds.profitbricks.domain.Location.US_LAS))
                      .build())
              .hardware(
                      new HardwareBuilder()
                      .ids("hardware111")
                      .name("super")
                      .ram(2048)
                      .processor(new Processor(2, 0))
                      .build())
              .build();

      Supplier<Set<? extends Location>> supplier = new Supplier<Set<? extends Location>>() {

         @Override
         public Set<? extends Location> get() {
            return ImmutableSet.of(
                    new LocationBuilder()
                    .id("qazwsxedc1234567890")
                    .description("qazwsxedc1234567890")
                    .scope(LocationScope.REGION)
                    .parent(mapPhysicalLocation(org.jclouds.profitbricks.domain.Location.US_LAS))
                    .build()
            );
         }
      };

      ServerToNodeMetadata function = new ServerToNodeMetadata(new ConnectedStorageToVolume(), supplier);
      assertEquals(function.apply(server), node);
   }
}
