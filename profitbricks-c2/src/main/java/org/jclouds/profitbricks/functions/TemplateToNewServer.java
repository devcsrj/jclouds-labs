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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Set;

import org.jclouds.compute.domain.Template;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequest;

import com.google.common.base.Function;

/**
 * Function for transforming user general node Template to ProfitBricks {@link org.jclouds.profitbricks.domain.Server}
 * spec to create new virtual server.
 */
public class TemplateToNewServer implements Function<Template, CreateServerRequest> {

   @Override
   public CreateServerRequest apply(Template template) {
      checkNotNull(template, "template");

      String serverName = "New Server";
      final Set<String> nodeNames = template.getOptions().getNodeNames();
      if (nodeNames != null)
         for (String name : nodeNames) {
            serverName = name;
            break;
         }

      return Server.creationBuilder()
              .dataCenterId(template.getLocation().getId()) // According to docs, this is not required. It IS required however, according to my last email [Aug.22.2014].
              .serverName(serverName)
              .cores((int) template.getHardware().getProcessors().get(0).getCores())
              .ram(template.getHardware().getRam())
              .availabilityZone(AvailabilityZone.AUTO)
              .osType(OsType.fromValue(template.getImage().getOperatingSystem().getFamily().name()))
              .build();
   }

}
