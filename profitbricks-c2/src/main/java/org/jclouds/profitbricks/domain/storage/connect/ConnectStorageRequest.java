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
package org.jclouds.profitbricks.domain.storage.connect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.storage.BusType;

/**
 * <p>
 * Java class for connectStorageRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="connectStorageRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="storageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="busType" type="{http://ws.api.profitbricks.com/}busType" minOccurs="0"/>
 *         &lt;element name="deviceNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectStorageRequest", propOrder = {
   "serverId",
   "storageId",
   "busType",
   "deviceNumber"
})
public class ConnectStorageRequest {

   @XmlElement(required = true)
   protected String serverId;
   @XmlElement(required = true)
   protected String storageId;
   protected BusType busType;
   protected Integer deviceNumber;

   public ConnectStorageRequest(String serverId, String storageId, BusType busType, Integer deviceNumber) {
      this.serverId = serverId;
      this.storageId = storageId;
      this.busType = busType;
      this.deviceNumber = deviceNumber;
   }

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

   /**
    * Gets the value of the storageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getStorageId() {
      return storageId;
   }

   /**
    * Sets the value of the storageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setStorageId(String value) {
      this.storageId = value;
   }

   /**
    * Gets the value of the busType property.
    *
    * @return possible object is {@link BusType }
    *
    */
   public BusType getBusType() {
      return busType;
   }

   /**
    * Sets the value of the busType property.
    *
    * @param value allowed object is {@link BusType }
    *
    */
   public void setBusType(BusType value) {
      this.busType = value;
   }

   /**
    * Gets the value of the deviceNumber property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getDeviceNumber() {
      return deviceNumber;
   }

   /**
    * Sets the value of the deviceNumber property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setDeviceNumber(Integer value) {
      this.deviceNumber = value;
   }

}
