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
package org.jclouds.profitbricks.domain.storage.create;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for createStorageRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createStorageRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mountImageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="profitBricksImagePassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createStorageRequest", propOrder = {
   "dataCenterId",
   "storageName",
   "size",
   "mountImageId",
   "profitBricksImagePassword"
})
public class CreateStorageRequest {

   protected String dataCenterId;
   protected String storageName;
   protected long size;
   protected String mountImageId;
   protected String profitBricksImagePassword;

   public CreateStorageRequest(String dataCenterId, String storageName, long size, String mountImageId, String profitBricksImagePassword) {
      this.dataCenterId = dataCenterId;
      this.storageName = storageName;
      this.size = size;
      this.mountImageId = mountImageId;
      this.profitBricksImagePassword = profitBricksImagePassword;
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

   /**
    * Gets the value of the size property.
    *
    */
   public long getSize() {
      return size;
   }

   /**
    * Sets the value of the size property.
    *
    */
   public void setSize(long value) {
      this.size = value;
   }

   /**
    * Gets the value of the mountImageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getMountImageId() {
      return mountImageId;
   }

   /**
    * Sets the value of the mountImageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setMountImageId(String value) {
      this.mountImageId = value;
   }

   /**
    * Gets the value of the profitBricksImagePassword property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getProfitBricksImagePassword() {
      return profitBricksImagePassword;
   }

   /**
    * Sets the value of the profitBricksImagePassword property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setProfitBricksImagePassword(String value) {
      this.profitBricksImagePassword = value;
   }

}
