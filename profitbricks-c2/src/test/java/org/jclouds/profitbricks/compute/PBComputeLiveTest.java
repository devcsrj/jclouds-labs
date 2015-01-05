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
package org.jclouds.profitbricks.compute;

import com.google.common.collect.Lists;

import java.util.Set;

import org.jclouds.apis.BaseApiLiveTest;
import org.jclouds.compute.ComputeService;
import org.jclouds.compute.ComputeServiceContext;
import org.jclouds.compute.RunNodesException;
import org.jclouds.compute.domain.ComputeMetadata;
import org.jclouds.compute.domain.Hardware;
import org.jclouds.compute.domain.Image;
import org.jclouds.compute.domain.NodeMetadata;
import org.jclouds.compute.domain.Template;
import org.jclouds.compute.options.TemplateOptions;
import org.jclouds.domain.Location;
import org.jclouds.profitbricks.ProfitBricksApi;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.sshj.config.SshjSshClientModule;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Module;

@Test(groups = "live", testName = "PBComputeLiveTest")
public class PBComputeLiveTest extends BaseApiLiveTest<ProfitBricksApi> {

   protected final ComputeService computeService;

   private String serverId;

   public PBComputeLiveTest() {
      provider = "profitbricks";
      computeService = newBuilder()
              .modules(ImmutableSet.<Module>of(
                              new SshjSshClientModule(),
                              new SLF4JLoggingModule()))
              .buildView(ComputeServiceContext.class)
              .getComputeService();
   }

   @Test
   public void testListImages() {
      Set<? extends Image> images = computeService.listImages();

      assertNotNull(images);
      assertTrue(images.size() > 1);
   }

   @Test
   public void testListHardwareProfiles() {
      Set<? extends Hardware> profiles = computeService.listHardwareProfiles();

      assertNotNull(profiles);
      assertTrue(profiles.size() > 1);
   }

   @Test
   public void testListLocations() {
      Set<? extends Location> locations = computeService.listAssignableLocations();

      assertNotNull(locations);
   }

   @Test
   public void testListNodes() {
      Set<? extends ComputeMetadata> nodes = computeService.listNodes();

      assertNotNull(nodes);
   }

   @Test
   public void testCreateNode() throws RunNodesException {
      Map<String, String> meta = new HashMap<String, String>(3);
      meta.put("storage[0].size", "5");
      meta.put("storage[0].name", "jcloud-store");
      meta.put("storage[0].boot", "y");

      Template template = computeService.templateBuilder()
              .minRam(2048)
              .minCores(1)
              .minDisk(5d)
              .imageNameMatches("Ubuntu")
              .options(
                      new TemplateOptions()
                      .nodeNames(Lists.newArrayList("jclouds-node"))
                      .userMetadata(meta)
              )
              .build();

      Set<? extends NodeMetadata> nodes = computeService.createNodesInGroup("jclouds", 1, template);
      assertNotNull(nodes);
      for (NodeMetadata node : nodes) {
         serverId = node.getId();
         System.out.println(node);
         break;
      }
   }

}
