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
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.server.BusType;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for connectedStorage complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="connectedStorage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bootDevice" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="busType" type="{http://ws.api.profitbricks.com/}busType" minOccurs="0"/>
 *         &lt;element name="deviceNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="storageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectedStorage", propOrder = {
   "bootDevice",
   "busType",
   "deviceNumber",
   "size",
   "storageId",
   "storageName"
})
public class ConnectedStorage {

   protected boolean bootDevice;
   protected BusType busType;
   protected Integer deviceNumber;
   protected Long size;
   protected String storageId;
   protected String storageName;

   public ConnectedStorage() {
   }

   public ConnectedStorage(String storageId) {
      this.storageId = storageId;
   }

   public ConnectedStorage(boolean bootDevice, BusType busType, Integer deviceNumber, Long size, String storageId, String storageName) {
      this.bootDevice = bootDevice;
      this.busType = busType;
      this.deviceNumber = deviceNumber;
      this.size = size;
      this.storageId = storageId;
      this.storageName = storageName;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof ConnectedStorage))
         return false;
      ConnectedStorage that = ConnectedStorage.class.cast(obj);
      return that.storageId.equals(storageId);
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 11 * hash + Objects.hashCode(this.storageId);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, busType=%s (%d GiB, deviceNumber=%d, bootDevice=%b)",
              storageId, storageName, busType, size, deviceNumber, bootDevice);
   }

   /**
    * Gets the value of the bootDevice property.
    *
    */
   public boolean isBootDevice() {
      return bootDevice;
   }

   /**
    * Sets the value of the bootDevice property.
    *
    */
   public void setBootDevice(boolean value) {
      this.bootDevice = value;
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

   /**
    * Gets the value of the size property.
    *
    * @return possible object is {@link Long }
    *
    */
   public Long getSize() {
      return size;
   }

   /**
    * Sets the value of the size property.
    *
    * @param value allowed object is {@link Long }
    *
    */
   public void setSize(Long value) {
      this.size = value;
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
    * Gets the value of the storageName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getStorageName() {
      return storageName;
   }

   /**
    * Sets the value of the storageName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setStorageName(String value) {
      this.storageName = value;
   }

}
