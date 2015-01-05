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

import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.OperatingSystem;
import org.jclouds.compute.domain.OsFamily;
import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.VirtualMachineState;

import com.google.common.collect.ImmutableSet;

public class PBEnumMapper {
   
   static Location mapPhysicalLocation(org.jclouds.profitbricks.domain.Location location) {
      if (location == null)
          return new LocationBuilder()
                    .id("unknown")
                    .iso3166Codes(ImmutableSet.of("unknown"))
                    .scope(LocationScope.PROVIDER)
                    .description("Unknown")
                    .build();
      switch (location) {
         case DE_FKB:
            return new LocationBuilder()
                    .id("de/fkb")
                    .iso3166Codes(ImmutableSet.of("de-fkb"))
                    .scope(LocationScope.PROVIDER)
                    .description("Germany, Karlsruhe")
                    .build();
         case DE_FRA:
            return new LocationBuilder()
                    .id("de/fra")
                    .iso3166Codes(ImmutableSet.of("de-fra"))
                    .scope(LocationScope.PROVIDER)
                    .description("Germany, Frankfurt (M)")
                    .build();

         case US_LAS:
            return new LocationBuilder()
                    .id("us/las")
                    .iso3166Codes(ImmutableSet.of("us-las"))
                    .scope(LocationScope.PROVIDER)
                    .description("USA, Las Vegas")
                    .build();
         case US_LASDEV:
            return new LocationBuilder()
                    .id("us/lasdev")
                    .iso3166Codes(ImmutableSet.of("us-lasdev"))
                    .scope(LocationScope.PROVIDER)
                    .description("USA, Developer cluster")
                    .build();
         default:
            return new LocationBuilder()
                    .id("unknown")
                    .iso3166Codes(ImmutableSet.of("unknown"))
                    .scope(LocationScope.PROVIDER)
                    .description("Unknown")
                    .build();
      }
   }

   static OperatingSystem mapOS(OsType osType) {
      if (osType == null)
         return OperatingSystem.builder()
                 .description(OsFamily.UNRECOGNIZED.value())
                 .family(OsFamily.UNRECOGNIZED)
                 .build();

      switch (osType) {
         case WINDOWS:
            return OperatingSystem.builder()
                    .description(OsFamily.WINDOWS.value())
                    .family(OsFamily.WINDOWS)
                    .build();
         case LINUX:
            return OperatingSystem.builder()
                    .description(OsFamily.LINUX.value())
                    .family(OsFamily.LINUX)
                    .build();
         default:
            return OperatingSystem.builder()
                    .description(OsFamily.UNRECOGNIZED.value())
                    .family(OsFamily.UNRECOGNIZED)
                    .build();
      }
   }

   static NodeMetadata.Status mapStatus(VirtualMachineState state) {
      if (state == null)
         return NodeMetadata.Status.UNRECOGNIZED;

      switch (state) {
         case SHUTDOWN:
         case SHUTOFF:
         case PAUSED:
            return NodeMetadata.Status.SUSPENDED;
         case RUNNING:
            return NodeMetadata.Status.RUNNING;
         case BLOCKED:
            return NodeMetadata.Status.PENDING;
         case CRASHED:
            return NodeMetadata.Status.ERROR;
         default:
            return NodeMetadata.Status.UNRECOGNIZED;
      }
   }

}
