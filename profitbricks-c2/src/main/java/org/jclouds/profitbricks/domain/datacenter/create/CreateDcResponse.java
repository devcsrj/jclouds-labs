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
package org.jclouds.profitbricks.domain.datacenter.create;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.RequestResponse;

/**
 * <p>
 * Java class for createDcResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createDcResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}requestResponse">
 *       &lt;sequence>
 *         &lt;element name="dataCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCenterVersion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createDcResponse", propOrder = {
   "dataCenterId",
   "dataCenterVersion",
   "location"
})
public class CreateDcResponse
        extends RequestResponse {

   protected String dataCenterId;
   protected Integer dataCenterVersion;
   protected Location location;

   public CreateDcResponse() {
   }

   public CreateDcResponse(String dataCenterId, Integer dataCenterVersion, Location location) {
      this.dataCenterId = dataCenterId;
      this.dataCenterVersion = dataCenterVersion;
      this.location = location;
   }

   /**
    * Gets the value of the dataCenterId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getDataCenterId() {
      return dataCenterId;
   }

   /**
    * Sets the value of the dataCenterId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setDataCenterId(String value) {
      this.dataCenterId = value;
   }

   /**
    * Gets the value of the dataCenterVersion property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getDataCenterVersion() {
      return dataCenterVersion;
   }

   /**
    * Sets the value of the dataCenterVersion property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setDataCenterVersion(Integer value) {
      this.dataCenterVersion = value;
   }

   /**
    * Gets the value of the location property.
    *
    * @return possible object is {@link Location }
    *
    */
   public Location getLocation() {
      return location;
   }

   /**
    * Sets the value of the location property.
    *
    * @param value allowed object is {@link Location }
    *
    */
   public void setLocation(Location value) {
      this.location = value;
   }

}
