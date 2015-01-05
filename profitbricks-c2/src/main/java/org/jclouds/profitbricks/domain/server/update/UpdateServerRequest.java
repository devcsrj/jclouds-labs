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
package org.jclouds.profitbricks.domain.server.update;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.server.AvailabilityZone;

/**
 * <p>
 * Java class for updateServerRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="updateServerRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="serverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ram" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bootFromStorageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bootFromImageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://ws.api.profitbricks.com/}osType" minOccurs="0"/>
 *         &lt;element name="availabilityZone" type="{http://ws.api.profitbricks.com/}availabilityZone" minOccurs="0"/>
 *         &lt;element name="cpuHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateServerRequest", propOrder = {
   "serverId",
   "serverName",
   "cores",
   "ram",
   "bootFromStorageId",
   "bootFromImageId",
   "osType",
   "availabilityZone",
   "cpuHotPlug",
   "ramHotPlug",
   "nicHotPlug",
   "nicHotUnPlug",
   "discVirtioHotPlug",
   "discVirtioHotUnPlug"
})
public class UpdateServerRequest {

   @XmlElement(required = true)
   protected String serverId;
   protected String serverName;
   protected Integer cores;
   protected Integer ram;
   protected String bootFromStorageId;
   protected String bootFromImageId;
   protected OsType osType;
   protected AvailabilityZone availabilityZone;
   protected Boolean cpuHotPlug;
   protected Boolean ramHotPlug;
   protected Boolean nicHotPlug;
   protected Boolean nicHotUnPlug;
   protected Boolean discVirtioHotPlug;
   protected Boolean discVirtioHotUnPlug;

   public UpdateServerRequest() {
   }

   public UpdateServerRequest(String serverId, String serverName, Integer cores, Integer ram, String bootFromStorageId,
           String bootFromImageId, OsType osType, AvailabilityZone availabilityZone, Boolean cpuHotPlug, Boolean ramHotPlug,
           Boolean nicHotPlug, Boolean nicHotUnPlug, Boolean discVirtioHotPlug, Boolean discVirtioHotUnPlug) {
      this.serverId = serverId;
      this.serverName = serverName;
      this.cores = cores;
      this.ram = ram;
      this.bootFromStorageId = bootFromStorageId;
      this.bootFromImageId = bootFromImageId;
      this.osType = osType;
      this.availabilityZone = availabilityZone;
      this.cpuHotPlug = cpuHotPlug;
      this.ramHotPlug = ramHotPlug;
      this.nicHotPlug = nicHotPlug;
      this.nicHotUnPlug = nicHotUnPlug;
      this.discVirtioHotPlug = discVirtioHotPlug;
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
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
    * Gets the value of the serverName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getServerName() {
      return serverName;
   }

   /**
    * Sets the value of the serverName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setServerName(String value) {
      this.serverName = value;
   }

   /**
    * Gets the value of the cores property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getCores() {
      return cores;
   }

   /**
    * Sets the value of the cores property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setCores(Integer value) {
      this.cores = value;
   }

   /**
    * Gets the value of the ram property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getRam() {
      return ram;
   }

   /**
    * Sets the value of the ram property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setRam(Integer value) {
      this.ram = value;
   }

   /**
    * Gets the value of the bootFromStorageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getBootFromStorageId() {
      return bootFromStorageId;
   }

   /**
    * Sets the value of the bootFromStorageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setBootFromStorageId(String value) {
      this.bootFromStorageId = value;
   }

   /**
    * Gets the value of the bootFromImageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getBootFromImageId() {
      return bootFromImageId;
   }

   /**
    * Sets the value of the bootFromImageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setBootFromImageId(String value) {
      this.bootFromImageId = value;
   }

   /**
    * Gets the value of the osType property.
    *
    * @return possible object is {@link OsType }
    *
    */
   public OsType getOsType() {
      return osType;
   }

   /**
    * Sets the value of the osType property.
    *
    * @param value allowed object is {@link OsType }
    *
    */
   public void setOsType(OsType value) {
      this.osType = value;
   }

   /**
    * Gets the value of the availabilityZone property.
    *
    * @return possible object is {@link AvailabilityZone }
    *
    */
   public AvailabilityZone getAvailabilityZone() {
      return availabilityZone;
   }

   /**
    * Sets the value of the availabilityZone property.
    *
    * @param value allowed object is {@link AvailabilityZone }
    *
    */
   public void setAvailabilityZone(AvailabilityZone value) {
      this.availabilityZone = value;
   }

   /**
    * Gets the value of the cpuHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isCpuHotPlug() {
      return cpuHotPlug;
   }

   /**
    * Sets the value of the cpuHotPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setCpuHotPlug(Boolean value) {
      this.cpuHotPlug = value;
   }

   /**
    * Gets the value of the ramHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isRamHotPlug() {
      return ramHotPlug;
   }

   /**
    * Sets the value of the ramHotPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setRamHotPlug(Boolean value) {
      this.ramHotPlug = value;
   }

   /**
    * Gets the value of the nicHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isNicHotPlug() {
      return nicHotPlug;
   }

   /**
    * Sets the value of the nicHotPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setNicHotPlug(Boolean value) {
      this.nicHotPlug = value;
   }

   /**
    * Gets the value of the nicHotUnPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isNicHotUnPlug() {
      return nicHotUnPlug;
   }

   /**
    * Sets the value of the nicHotUnPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setNicHotUnPlug(Boolean value) {
      this.nicHotUnPlug = value;
   }

   /**
    * Gets the value of the discVirtioHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isDiscVirtioHotPlug() {
      return discVirtioHotPlug;
   }

   /**
    * Sets the value of the discVirtioHotPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setDiscVirtioHotPlug(Boolean value) {
      this.discVirtioHotPlug = value;
   }

   /**
    * Gets the value of the discVirtioHotUnPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isDiscVirtioHotUnPlug() {
      return discVirtioHotUnPlug;
   }

   /**
    * Sets the value of the discVirtioHotUnPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setDiscVirtioHotUnPlug(Boolean value) {
      this.discVirtioHotUnPlug = value;
   }

}
