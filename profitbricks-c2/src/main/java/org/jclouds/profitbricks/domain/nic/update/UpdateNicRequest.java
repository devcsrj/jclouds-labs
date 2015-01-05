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
package org.jclouds.profitbricks.domain.nic.update;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for updateNicRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="updateNicRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nicId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lanId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dhcpActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateNicRequest", propOrder = {
   "nicId",
   "lanId",
   "nicName",
   "ip",
   "dhcpActive"
})
public class UpdateNicRequest {

   @XmlElement(required = true)
   protected String nicId;
   protected Integer lanId;
   protected String nicName;
   protected String ip;
   protected Boolean dhcpActive;

   public UpdateNicRequest() {
   }

   public UpdateNicRequest(String nicId, Integer lanId, String nicName, String ip, Boolean dhcpActive) {
      this.nicId = nicId;
      this.lanId = lanId;
      this.nicName = nicName;
      this.ip = ip;
      this.dhcpActive = dhcpActive;
   }

   /**
    * Gets the value of the nicId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getNicId() {
      return nicId;
   }

   /**
    * Sets the value of the nicId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setNicId(String value) {
      this.nicId = value;
   }

   /**
    * Gets the value of the lanId property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getLanId() {
      return lanId;
   }

   /**
    * Sets the value of the lanId property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setLanId(Integer value) {
      this.lanId = value;
   }

   /**
    * Gets the value of the nicName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getNicName() {
      return nicName;
   }

   /**
    * Sets the value of the nicName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setNicName(String value) {
      this.nicName = value;
   }

   /**
    * Gets the value of the ip property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getIp() {
      return ip;
   }

   /**
    * Sets the value of the ip property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setIp(String value) {
      this.ip = value;
   }

   /**
    * Gets the value of the dhcpActive property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isDhcpActive() {
      return dhcpActive;
   }

   /**
    * Sets the value of the dhcpActive property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setDhcpActive(Boolean value) {
      this.dhcpActive = value;
   }

}
