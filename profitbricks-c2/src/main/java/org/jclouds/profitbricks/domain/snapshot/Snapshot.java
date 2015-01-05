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
package org.jclouds.profitbricks.domain.snapshot;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.RequestResponse;
import org.jclouds.profitbricks.domain.snapshot.create.CreateSnapshotRequestBuilder;
import org.jclouds.profitbricks.domain.snapshot.rollback.RollbackSnapshotRequestBuilder;
import org.jclouds.profitbricks.domain.snapshot.update.UpdateSnapshotRequestBuilder;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for snapshot complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="snapshot">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}requestResponse">
 *       &lt;sequence>
 *         &lt;element name="snapshotId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="snapshotSize" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="snapshotName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState"/>
 *         &lt;element name="bootable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://ws.api.profitbricks.com/}osType" minOccurs="0"/>
 *         &lt;element name="cpuHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cpuHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="creationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="modificationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "snapshot", propOrder = {
   "snapshotId",
   "description",
   "snapshotSize",
   "snapshotName",
   "provisioningState",
   "bootable",
   "osType",
   "cpuHotPlug",
   "cpuHotUnPlug",
   "discVirtioHotPlug",
   "discVirtioHotUnPlug",
   "ramHotPlug",
   "ramHotUnPlug",
   "nicHotPlug",
   "nicHotUnPlug",
   "creationTimestamp",
   "modificationTimestamp",
   "location"
})
public class Snapshot extends RequestResponse {

   @XmlElement(required = true)
   protected String snapshotId;
   protected String description;
   protected long snapshotSize;
   protected String snapshotName;
   @XmlElement(required = true)
   protected ProvisioningState provisioningState;
   protected Boolean bootable;
   protected OsType osType;
   protected Boolean cpuHotPlug;
   protected Boolean cpuHotUnPlug;
   protected Boolean discVirtioHotPlug;
   protected Boolean discVirtioHotUnPlug;
   protected Boolean ramHotPlug;
   protected Boolean ramHotUnPlug;
   protected Boolean nicHotPlug;
   protected Boolean nicHotUnPlug;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar creationTimestamp;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar modificationTimestamp;
   @XmlElement(required = true)
   protected Location location;

   public static CreateSnapshotRequestBuilder creatingBuilder() {
      return new CreateSnapshotRequestBuilder();
   }

   public static RollbackSnapshotRequestBuilder rollbackBuilder() {
      return new RollbackSnapshotRequestBuilder();
   }

   public static UpdateSnapshotRequestBuilder updatingBuilder() {
      return new UpdateSnapshotRequestBuilder();
   }

   public Snapshot() {
   }

   public Snapshot(String snapshotId, String description, long snapshotSize, String snapshotName,
           ProvisioningState provisioningState, Boolean bootable, OsType osType,
           Boolean cpuHotPlug, Boolean cpuHotUnPlug, Boolean discVirtioHotPlug, Boolean discVirtioHotUnPlug,
           Boolean ramHotPlug, Boolean ramHotUnPlug, Boolean nicHotPlug, Boolean nicHotUnPlug,
           XMLGregorianCalendar creationTimestamp, XMLGregorianCalendar modificationTimestamp, Location location) {
      this.snapshotId = snapshotId;
      this.description = description;
      this.snapshotSize = snapshotSize;
      this.snapshotName = snapshotName;
      this.provisioningState = provisioningState;
      this.bootable = bootable;
      this.osType = osType;
      this.cpuHotPlug = cpuHotPlug;
      this.cpuHotUnPlug = cpuHotUnPlug;
      this.discVirtioHotPlug = discVirtioHotPlug;
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
      this.ramHotPlug = ramHotPlug;
      this.ramHotUnPlug = ramHotUnPlug;
      this.nicHotPlug = nicHotPlug;
      this.nicHotUnPlug = nicHotUnPlug;
      this.creationTimestamp = creationTimestamp;
      this.modificationTimestamp = modificationTimestamp;
      this.location = location;
   }

   /**
    * Gets the value of the snapshotId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getSnapshotId() {
      return snapshotId;
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
    * Gets the value of the snapshotSize property.
    *
    */
   public long getSnapshotSize() {
      return snapshotSize;
   }

   /**
    * Gets the value of the snapshotName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getSnapshotName() {
      return snapshotName;
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
    * Gets the value of the bootable property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isBootable() {
      return bootable;
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
    * Gets the value of the cpuHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isCpuHotPlug() {
      return cpuHotPlug;
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
    * Gets the value of the discVirtioHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isDiscVirtioHotPlug() {
      return discVirtioHotPlug;
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
    * Gets the value of the ramHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isRamHotPlug() {
      return ramHotPlug;
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
    * Gets the value of the nicHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isNicHotPlug() {
      return nicHotPlug;
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
    * Gets the value of the creationTimestamp property.
    *
    * @return possible object is {@link XMLGregorianCalendar }
    *
    */
   public XMLGregorianCalendar getCreationTimestamp() {
      return creationTimestamp;
   }

   /**
    * Gets the value of the modificationTimestamp property.
    *
    * @return possible object is {@link XMLGregorianCalendar }
    *
    */
   public XMLGregorianCalendar getModificationTimestamp() {
      return modificationTimestamp;
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

   public void setSnapshotId(String snapshotId) {
      this.snapshotId = snapshotId;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setSnapshotSize(long snapshotSize) {
      this.snapshotSize = snapshotSize;
   }

   public void setSnapshotName(String snapshotName) {
      this.snapshotName = snapshotName;
   }

   public void setProvisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
   }

   public void setBootable(Boolean bootable) {
      this.bootable = bootable;
   }

   public void setOsType(OsType osType) {
      this.osType = osType;
   }

   public void setCpuHotPlug(Boolean cpuHotPlug) {
      this.cpuHotPlug = cpuHotPlug;
   }

   public void setCpuHotUnPlug(Boolean cpuHotUnPlug) {
      this.cpuHotUnPlug = cpuHotUnPlug;
   }

   public void setDiscVirtioHotPlug(Boolean discVirtioHotPlug) {
      this.discVirtioHotPlug = discVirtioHotPlug;
   }

   public void setDiscVirtioHotUnPlug(Boolean discVirtioHotUnPlug) {
      this.discVirtioHotUnPlug = discVirtioHotUnPlug;
   }

   public void setRamHotPlug(Boolean ramHotPlug) {
      this.ramHotPlug = ramHotPlug;
   }

   public void setRamHotUnPlug(Boolean ramHotUnPlug) {
      this.ramHotUnPlug = ramHotUnPlug;
   }

   public void setNicHotPlug(Boolean nicHotPlug) {
      this.nicHotPlug = nicHotPlug;
   }

   public void setNicHotUnPlug(Boolean nicHotUnPlug) {
      this.nicHotUnPlug = nicHotUnPlug;
   }

   public void setCreationTimestamp(XMLGregorianCalendar creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

   public void setModificationTimestamp(XMLGregorianCalendar modificationTimestamp) {
      this.modificationTimestamp = modificationTimestamp;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, %s (%s GB) - { bootable=%s, osType=%s, location=%s }", snapshotId, snapshotName,
              description, snapshotSize, provisioningState, bootable, osType, location);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof Snapshot))
         return false;
      Snapshot that = Snapshot.class.cast(obj);
      return this.snapshotId.equals(that.snapshotId);
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 37 * hash + Objects.hashCode(this.snapshotId);
      return hash;
   }

}
