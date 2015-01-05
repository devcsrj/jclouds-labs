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
package org.jclouds.profitbricks.domain.storage;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.image.MountImage;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storage", propOrder = {
   "storageId",
   "size",
   "storageName",
   "mountImage",
   "serverIds",
   "provisioningState",
   "creationTime",
   "lastModificationTime"
})
public class Storage extends VersionResponse {

   protected String storageId;
   protected Long size;
   protected String storageName;
   protected MountImage mountImage;
   @XmlElement(nillable = true)
   protected List<String> serverIds;
   protected ProvisioningState provisioningState;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar creationTime;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar lastModificationTime;

   public static StorageBuilder describingBuilder() {
      return new StorageBuilder();
   }

   public static CreateStorageRequestBuilder creatingBuilder() {
      return new CreateStorageRequestBuilder();
   }

   public static UpdateStorageRequestBuilder updatingBuilder() {
      return new UpdateStorageRequestBuilder();
   }

   public static ConnectStorageRequestBuilder connectingBuilder() {
      return new ConnectStorageRequestBuilder();
   }

   public Storage() {
   }

   public Storage(String storageId, Long size, String storageName, MountImage mountImage, List<String> serverIds,
           ProvisioningState provisioningState, XMLGregorianCalendar creationTime, XMLGregorianCalendar lastModificationTime) {
      this.storageId = storageId;
      this.size = size;
      this.storageName = storageName;
      this.mountImage = mountImage;
      this.serverIds = (List<String>) (serverIds == null ? Lists.newArrayList() : serverIds);
      this.provisioningState = provisioningState;
      this.creationTime = creationTime;
      this.lastModificationTime = lastModificationTime;
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
    * Gets the value of the size property.
    *
    * @return possible object is {@link Long }
    *
    */
   public Long getSize() {
      return size;
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
    * Gets the value of the mountImage property.
    *
    * @return possible object is {@link MountImage }
    *
    */
   public MountImage getMountImage() {
      return mountImage;
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
    * Gets the value of the provisioningState property.
    *
    * @return possible object is {@link ProvisioningState }
    *
    */
   public ProvisioningState getProvisioningState() {
      return provisioningState;
   }

   /**
    * Gets the value of the creationTime property.
    *
    * @return possible object is {@link XMLGregorianCalendar }
    *
    */
   public XMLGregorianCalendar getCreationTime() {
      return creationTime;
   }

   /**
    * Gets the value of the lastModificationTime property.
    *
    * @return possible object is {@link XMLGregorianCalendar }
    *
    */
   public XMLGregorianCalendar getLastModificationTime() {
      return lastModificationTime;
   }

   public void setStorageId(String storageId) {
      this.storageId = storageId;
   }

   public void setSize(Long size) {
      this.size = size;
   }

   public void setStorageName(String storageName) {
      this.storageName = storageName;
   }

   public void setMountImage(MountImage mountImage) {
      this.mountImage = mountImage;
   }

   public void setServerIds(List<String> serverIds) {
      this.serverIds = serverIds;
   }

   public void setProvisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
   }

   public void setCreationTime(XMLGregorianCalendar creationTime) {
      this.creationTime = creationTime;
   }

   public void setLastModificationTime(XMLGregorianCalendar lastModificationTime) {
      this.lastModificationTime = lastModificationTime;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, %s - %s", storageId, storageName, size, mountImage);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof Storage))
         return false;
      Storage storage = Storage.class.cast(obj);
      return storage.storageId.equals(storageId) && storage.lastModificationTime.equals(lastModificationTime);
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 53 * hash + Objects.hashCode(this.storageId);
      hash = 53 * hash + Objects.hashCode(this.lastModificationTime);
      return hash;
   }

}
