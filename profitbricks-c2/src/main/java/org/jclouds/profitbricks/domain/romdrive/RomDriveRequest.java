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
package org.jclouds.profitbricks.domain.romdrive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for romDriveRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="romDriveRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "romDriveRequest", propOrder = {
   "imageId",
   "serverId",
   "deviceNumber"
})
public class RomDriveRequest {

   @XmlElement(required = true)
   protected String imageId;
   @XmlElement(required = true)
   protected String serverId;
   protected Integer deviceNumber;

   public RomDriveRequest(String imageId, String serverId, Integer deviceNumber) {
      this.imageId = imageId;
      this.serverId = serverId;
      this.deviceNumber = deviceNumber;
   }

   public RomDriveRequest() {
   }

   /**
    * Gets the value of the imageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getImageId() {
      return imageId;
   }

   /**
    * Sets the value of the imageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setImageId(String value) {
      this.imageId = value;
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
