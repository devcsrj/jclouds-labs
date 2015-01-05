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
package org.jclouds.profitbricks.domain.server.create;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.VersionResponse;

/**
 * <p>
 * Java class for createServerResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createServerResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(namespace = "http://ws.api.profitbricks.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createServerResponse", propOrder = {
   "serverId"
})
public class CreateServerResponse
        extends VersionResponse {

   protected String serverId;

   /**
    * Gets the value of the serverId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getServerId() {
      return serverId;
   }

   /**
    * Sets the value of the serverId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setServerId(String value) {
      this.serverId = value;
   }

}
