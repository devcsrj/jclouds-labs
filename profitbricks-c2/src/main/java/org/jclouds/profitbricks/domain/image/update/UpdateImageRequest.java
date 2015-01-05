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
package org.jclouds.profitbricks.domain.image.update;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.OsType;

/**
 * <p>
 * Java class for updateImageRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="updateImageRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://ws.api.profitbricks.com/}osType" minOccurs="0"/>
 *         &lt;element name="cpuHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="bootable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateImageRequest", propOrder = {
   "imageId",
   "imageName",
   "description",
   "osType",
   "cpuHotPlug",
   "cpuHotUnPlug",
   "ramHotPlug",
   "ramHotUnPlug",
   "nicHotPlug",
   "nicHotUnPlug",
   "discVirtioHotPlug",
   "discVirtioHotUnPlug",
   "bootable"
})
public class UpdateImageRequest {

   @XmlElement(required = true)
   protected String imageId;
   @XmlElement(required = true)
   protected String imageName;
   protected String description;
   protected OsType osType;
   protected Boolean cpuHotPlug;
   protected Boolean cpuHotUnPlug;
   protected Boolean ramHotPlug;
   protected Boolean ramHotUnPlug;
   protected Boolean nicHotPlug;
   protected Boolean nicHotUnPlug;
   protected Boolean discVirtioHotPlug;
   protected Boolean discVirtioHotUnPlug;
   protected Boolean bootable;

   public UpdateImageRequest() {
   }

   public UpdateImageRequest(String imageId, String imageName, String description, OsType osType, Boolean cpuHotPlug,
           Boolean cpuHotUnPlug, Boolean ramHotPlug, Boolean ramHotUnPlug, Boolean nicHotPlug, Boolean nicHotUnPlug,
           Boolean discVirtioHotPlug, Boolean discVirtioHotUnPlug, Boolean bootable) {
      this.imageId = imageId;
      this.imageName = imageName;
      this.description = description;
      this.osType = osType;
      this.cpuHotPlug = cpuHotPlug;
      this.cpuHotUnPlug = cpuHotUnPlug;
      this.ramHotPlug = ramHotPlug;
      this.ramHotUnPlug = ramHotUnPlug;
      this.nicHotPlug = nicHotPlug;
      this.nicHotUnPlug = nicHotUnPlug;
      this.discVirtioHotPlug = discVirtioHotPlug;
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      this.bootable = bootable;
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
    * Gets the value of the imageName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getImageName() {
      return imageName;
   }

   /**
    * Sets the value of the imageName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setImageName(String value) {
      this.imageName = value;
   }

   /**
    * Gets the value of the description property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getDescription() {
      return description;
   }

   /**
    * Sets the value of the description property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setDescription(String value) {
      this.description = value;
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
    * Gets the value of the cpuHotUnPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isCpuHotUnPlug() {
      return cpuHotUnPlug;
   }

   /**
    * Sets the value of the cpuHotUnPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setCpuHotUnPlug(Boolean value) {
      this.cpuHotUnPlug = value;
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
    * Gets the value of the ramHotUnPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isRamHotUnPlug() {
      return ramHotUnPlug;
   }

   /**
    * Sets the value of the ramHotUnPlug property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setRamHotUnPlug(Boolean value) {
      this.ramHotUnPlug = value;
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

   /**
    * Gets the value of the bootable property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isBootable() {
      return bootable;
   }

   /**
    * Sets the value of the bootable property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setBootable(Boolean value) {
      this.bootable = value;
   }

}
