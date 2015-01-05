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
package org.jclouds.profitbricks.domain.server;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.nic.Nic;
import org.jclouds.profitbricks.domain.romdrive.RomDrive;
import org.jclouds.profitbricks.domain.server.create.CreateServerRequestBuilder;
import org.jclouds.profitbricks.domain.server.update.UpdateServerRequestBuilder;
import org.jclouds.profitbricks.domain.storage.connect.ConnectedStorage;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for server complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="server">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serverName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cores" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ram" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="internetAccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ips" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="connectedStorages" type="{http://ws.api.profitbricks.com/}connectedStorage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="romDrives" type="{http://ws.api.profitbricks.com/}romDrive" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nics" type="{http://ws.api.profitbricks.com/}nic" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState" minOccurs="0"/>
 *         &lt;element name="virtualMachineState" type="{http://ws.api.profitbricks.com/}virtualMachineState" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastModificationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="osType" type="{http://ws.api.profitbricks.com/}osType" minOccurs="0"/>
 *         &lt;element name="availabilityZone" type="{http://ws.api.profitbricks.com/}availabilityZone" minOccurs="0"/>
 *         &lt;element name="cpuHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ramHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nicHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="discVirtioHotUnPlug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "server", propOrder = {
   "serverId",
   "serverName",
   "cores",
   "ram",
   "internetAccess",
   "ips",
   "connectedStorages",
   "romDrives",
   "nics",
   "provisioningState",
   "virtualMachineState",
   "creationTime",
   "lastModificationTime",
   "osType",
   "availabilityZone",
   "cpuHotPlug",
   "ramHotPlug",
   "nicHotPlug",
   "nicHotUnPlug",
   "discVirtioHotPlug",
   "discVirtioHotUnPlug"
})
public class Server
        extends VersionResponse {

   protected String serverId;
   protected String serverName;
   protected Integer cores;
   protected Integer ram;
   protected boolean internetAccess;
   @XmlElement(nillable = true)
   protected List<String> ips;
   @XmlElement(nillable = true)
   protected List<ConnectedStorage> connectedStorages;
   @XmlElement(nillable = true)
   protected List<RomDrive> romDrives;
   @XmlElement(nillable = true)
   protected List<Nic> nics;
   protected ProvisioningState provisioningState;
   protected VirtualMachineState virtualMachineState;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar creationTime;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar lastModificationTime;
   protected OsType osType;
   protected AvailabilityZone availabilityZone;
   protected Boolean cpuHotPlug;
   protected Boolean ramHotPlug;
   protected Boolean nicHotPlug;
   protected Boolean nicHotUnPlug;
   protected Boolean discVirtioHotPlug;
   protected Boolean discVirtioHotUnPlug;

   public static CreateServerRequestBuilder creationBuilder() {
      return new CreateServerRequestBuilder();
   }

   public static ServerBuilder describingBuilder() {
      return new ServerBuilder();
   }

   public static UpdateServerRequestBuilder updatingBuilder() {
      return new UpdateServerRequestBuilder();
   }

   public Server() {
      this.ips = Lists.newArrayList();
      this.connectedStorages = Lists.newArrayList();
      this.nics = Lists.newArrayList();
      this.romDrives = Lists.newArrayList();
   }

   public Server(String serverId, String serverName, Integer cores, Integer ram, boolean internetAccess, List<String> ips,
           List<ConnectedStorage> connectedStorages, List<RomDrive> romDrives, List<Nic> nics, ProvisioningState provisioningState,
           VirtualMachineState virtualMachineState, XMLGregorianCalendar creationTime, XMLGregorianCalendar lastModificationTime,
           OsType osType, AvailabilityZone availabilityZone, Boolean cpuHotPlug, Boolean ramHotPlug, Boolean nicHotPlug,
           Boolean nicHotUnPlug, Boolean discVirtioHotPlug, Boolean discVirtioHotUnPlug, String dataCenterId, Integer dataCenterVersion) {
      super(dataCenterId, dataCenterVersion);

      this.serverId = serverId;
      this.serverName = serverName;
      this.cores = cores;
      this.ram = ram;
      this.internetAccess = internetAccess;
      this.ips = (List<String>) (ips == null ? Lists.newArrayList() : ips);
      this.connectedStorages = (List<ConnectedStorage>) (connectedStorages == null ? Lists.newArrayList() : connectedStorages);
      this.romDrives = (List<RomDrive>) (romDrives == null ? Lists.newArrayList() : romDrives);
      this.nics = (List<Nic>) (nics == null ? Lists.newArrayList() : nics);
      this.provisioningState = provisioningState;
      this.virtualMachineState = virtualMachineState;
      this.creationTime = creationTime;
      this.lastModificationTime = lastModificationTime;
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
    * Gets the value of the serverName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getServerName() {
      return serverName;
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
    * Gets the value of the ram property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getRam() {
      return ram;
   }

   /**
    * Gets the value of the internetAccess property.
    *
    */
   public boolean isInternetAccess() {
      return internetAccess;
   }

   /**
    * Gets the value of the ips property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the ips property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getIps().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link String }
    *
    *
    */
   public List<String> getIps() {
      return this.ips;
   }

   /**
    * Gets the value of the connectedStorages property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the connectedStorages property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getConnectedStorages().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link ConnectedStorage }
    *
    *
    */
   public List<ConnectedStorage> getConnectedStorages() {
      return this.connectedStorages;
   }

   /**
    * Gets the value of the romDrives property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the romDrives property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getRomDrives().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link RomDrive }
    *
    *
    */
   public List<RomDrive> getRomDrives() {
      return this.romDrives;
   }

   /**
    * Gets the value of the nics property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the nics property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getNics().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Nic }
    *
    *
    */
   public List<Nic> getNics() {
      return this.nics;
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
    * Gets the value of the virtualMachineState property.
    *
    * @return possible object is {@link VirtualMachineState }
    *
    */
   public VirtualMachineState getVirtualMachineState() {
      return virtualMachineState;
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
    * Gets the value of the availabilityZone property.
    *
    * @return possible object is {@link AvailabilityZone }
    *
    */
   public AvailabilityZone getAvailabilityZone() {
      return availabilityZone;
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
    * Gets the value of the ramHotPlug property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isRamHotPlug() {
      return ramHotPlug;
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

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      Server that = Server.class.cast(obj);

      return Objects.equal(this.serverId, that.serverId);
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 11 * hash + Objects.hashCode(this.serverId);
      return hash;
   }

   @Override
   public String toString() {
      return getClass().getSimpleName() + "{"
              + "dataCenterId=" + dataCenterId + ","
              + "serverId=" + serverId + ","
              + "serverName=" + serverName + ","
              + "internetAccess=" + internetAccess + ","
              + "creationTime=" + creationTime + ","
              + "lastModificationTime=" + lastModificationTime + ","
              + "cores=" + cores + ","
              + "ram=" + ram + ","
              + "osType=" + osType + ","
              + "provisioningState=" + provisioningState + ","
              + "virtualMachineState=" + virtualMachineState + ","
              + "availabilityZone=" + availabilityZone
              + "}";
   }

}
