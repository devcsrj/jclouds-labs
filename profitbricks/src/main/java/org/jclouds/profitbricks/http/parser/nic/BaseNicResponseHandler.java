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

package org.jclouds.profitbricks.http.parser.nic;

import org.jclouds.profitbricks.domain.Nic;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.http.parser.BaseProfitBricksResponseHandler;

public abstract class BaseNicResponseHandler<T> extends BaseProfitBricksResponseHandler<T> {
    protected Nic.Builder builder;

    BaseNicResponseHandler() {
        this.builder = Nic.builder();
    }

    @Override
    protected void setPropertyOnEndTag(String qName) {
        if ("dataCenterId".equals(qName))
            builder.dataCenterId(textToStringValue());
        else if ("dataCenterVersion".equals(qName))
            builder.dataCenterVersion(textToIntValue());
        else if ("nicId".equals(qName))
            builder.nicId(textToStringValue());
        else if ("lanId".equals(qName))
            builder.lanId(textToStringValue());
        else if ("internetAccess".equals(qName))
            builder.internetAccess(textToBooleanValue());
        else if ("serverId".equals(qName))
            builder.serverId(textToStringValue());
        else if ("ips".equals(qName))
            builder.ips(textToStringValue());
        else if ("macAddress".equals(qName))
            builder.macAddress(textToStringValue());
        else if ("dhcpActive".equals(qName))
            builder.dhcpActive(textToBooleanValue());
        else if ("gatewayIp".equals(qName))
            builder.gatewayIp(textToStringValue());
        else if ("provisioningState".equals(qName))
            builder.provisioningState(ProvisioningState.fromValue(textToStringValue()));

    }
}
