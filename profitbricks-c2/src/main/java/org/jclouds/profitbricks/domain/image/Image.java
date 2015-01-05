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
package org.jclouds.profitbricks.domain.image;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.image.setostype.ImageOsTypeRequestBuilder;
import org.jclouds.profitbricks.domain.image.update.UpdateImageRequestBuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for image complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="image">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bootable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discVirtioHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="imageType" type="{http://ws.api.profitbricks.com/}imageType" minOccurs="0"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location" minOccurs="0"/>
 *         &lt;element name="nicHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://ws.api.profitbricks.com/}osType" minOccurs="0"/>
 *         &lt;element name="public" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="serverIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="writeable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "image", propOrder = {
   "bootable",
   "cpuHotPlug",
   "cpuHotUnPlug",
   "description",
   "discVirtioHotPlug",
   "discVirtioHotUnPlug",
   "imageId",
   "imageName",
   "imageSize",
   "imageType",
   "location",
   "nicHotPlug",
   "nicHotUnPlug",
   "osType",
   "_public",
   "ramHotPlug",
   "ramHotUnPlug",
   "serverIds",
   "writeable"
})
public class Image {

   protected Boolean bootable;
   protected Boolean cpuHotPlug;
   protected Boolean cpuHotUnPlug;
   protected String description;
   protected Boolean discVirtioHotPlug;
   protected Boolean discVirtioHotUnPlug;
   protected String imageId;
   protected String imageName;
   protected Long imageSize;
   protected ImageType imageType;
   protected Location location;
   protected Boolean nicHotPlug;
   protected Boolean nicHotUnPlug;
   protected OsType osType;
   @XmlElement(name = "public")
   protected Boolean _public;
   protected Boolean ramHotPlug;
   protected Boolean ramHotUnPlug;
   @XmlElement(nillable = true)
   protected List<String> serverIds;
   protected Boolean writeable;

   public static ImageBuilder builder() {
      return new ImageBuilder();
   }

   public static UpdateImageRequestBuilder updatingBuilder() {
      return new UpdateImageRequestBuilder();
   }

   public static ImageOsTypeRequestBuilder osTypeSettingBuilder() {
      return new ImageOsTypeRequestBuilder();
   }

   public Image() {
      this.serverIds = Lists.newArrayList();
   }

   public Image(Boolean bootable, Boolean cpuHotPlug, Boolean cpuHotUnPlug, String description,
           Boolean discVirtioHotPlug, Boolean discVirtioHotUnPlug, String imageId, String imageName,
           Long imageSize, ImageType imageType, Location location,
           Boolean nicHotPlug, Boolean nicHotUnPlug, OsType osType,
           Boolean _public, Boolean ramHotPlug, Boolean ramHotUnPlug, List<String> serverIds, Boolean writeable) {
      this.bootable = bootable;
      this.cpuHotPlug = cpuHotPlug;
      this.cpuHotUnPlug = cpuHotUnPlug;
      this.description = description;
      this.discVirtioHotPlug = discVirtioHotPlug;
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      this.imageId = imageId;
      this.imageName = imageName;
      this.imageSize = imageSize;
      this.imageType = imageType;
      this.location = location;
      this.nicHotPlug = nicHotPlug;
      this.nicHotUnPlug = nicHotUnPlug;
      this.osType = osType;
      this._public = _public;
      this.ramHotPlug = ramHotPlug;
      this.ramHotUnPlug = ramHotUnPlug;
      this.serverIds = (List<String>) (serverIds == null ? Lists.newArrayList() : serverIds);
      this.writeable = writeable;
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
    * Gets the value of the imageSize property.
    *
    * @return possible object is {@link Long }
    *
    */
   public Long getImageSize() {
      return imageSize;
   }

   /**
    * Sets the value of the imageSize property.
    *
    * @param value allowed object is {@link Long }
    *
    */
   public void setImageSize(Long value) {
      this.imageSize = value;
   }

   /**
    * Gets the value of the imageType property.
    *
    * @return possible object is {@link ImageType }
    *
    */
   public ImageType getImageType() {
      return imageType;
   }

   /**
    * Sets the value of the imageType property.
    *
    * @param value allowed object is {@link ImageType }
    *
    */
   public void setImageType(ImageType value) {
      this.imageType = value;
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
    * Gets the value of the public property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isPublic() {
      return _public;
   }

   /**
    * Sets the value of the public property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setPublic(Boolean value) {
      this._public = value;
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
    * Gets the value of the serverIds property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the serverIds property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getServerIds().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link String }
    *
    *
    */
   public List<String> getServerIds() {
      return this.serverIds;
   }

   /**
    * Gets the value of the writeable property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isWriteable() {
      return writeable;
   }

   /**
    * Sets the value of the writeable property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setWriteable(Boolean value) {
      this.writeable = value;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof Image))
         return false;
      Image img = (Image) obj;
      return img.imageId.equals(imageId) && img.imageSize.equals(imageSize)
              && img.location.equals(location) && img.osType.equals(osType)
              && img.imageType.equals(imageType);
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 43 * hash + Objects.hashCode(this.imageId);
      hash = 43 * hash + Objects.hashCode(this.imageSize);
      hash = 43 * hash + Objects.hashCode(this.osType);
      hash = 43 * hash + Objects.hashCode(this.location);
      hash = 43 * hash + Objects.hashCode(this.imageType);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, %d, %s (%s)(%s)", imageId, imageName, imageSize, imageType, osType, location);
   }
}
