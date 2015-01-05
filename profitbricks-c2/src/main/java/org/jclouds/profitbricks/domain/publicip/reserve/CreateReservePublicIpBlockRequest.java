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
package org.jclouds.profitbricks.domain.publicip.reserve;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.Location;

/**
 * <p>
 * Java class for createReservePublicIpBlockRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createReservePublicIpBlockRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blockSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createReservePublicIpBlockRequest", propOrder = {
   "blockSize",
   "location"
})
public class CreateReservePublicIpBlockRequest {

   protected int blockSize;
   @XmlElement(required = true)
   protected Location location;

   public CreateReservePublicIpBlockRequest() {
   }

   public CreateReservePublicIpBlockRequest(int blockSize, Location location) {
      this.blockSize = blockSize;
      this.location = location;
   }

   /**
    * Gets the value of the blockSize property.
    *
    */
   public int getBlockSize() {
      return blockSize;
   }

   /**
    * Sets the value of the blockSize property.
    *
    */
   public void setBlockSize(int value) {
      this.blockSize = value;
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
