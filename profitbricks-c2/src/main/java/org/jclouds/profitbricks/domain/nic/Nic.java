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
package org.jclouds.profitbricks.domain.nic;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.firewall.Firewall;
import org.jclouds.profitbricks.domain.nic.create.CreateNicRequestBuilder;
import org.jclouds.profitbricks.domain.nic.update.UpdateNicRequestBuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for nic complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="nic">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="nicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nicName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="internetAccess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="serverId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ips" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firewall" type="{http://ws.api.profitbricks.com/}firewall" minOccurs="0"/>
 *         &lt;element name="dhcpActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="gatewayIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nic", propOrder = {
   "nicId",
   "nicName",
   "lanId",
   "internetAccess",
   "serverId",
   "ips",
   "macAddress",
   "firewall",
   "dhcpActive",
   "gatewayIp",
   "provisioningState"
})
public class Nic
        extends VersionResponse {

   protected String nicId;
   protected String nicName;
   protected int lanId;
   protected Boolean internetAccess;
   protected String serverId;
   @XmlElement(nillable = true)
   protected List<String> ips;
   protected String macAddress;
   protected Firewall firewall;
   protected Boolean dhcpActive;
   protected String gatewayIp;
   protected ProvisioningState provisioningState;

   @Override
   public String toString() {
      return String.format("[%s] %s, serverId=%s ,lanId=%s, hasInternet=%b (%s)", nicId, nicName, serverId,
              lanId, internetAccess, provisioningState);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof Nic))
         return false;
      Nic that = Nic.class.cast(obj);
      return that.nicId.equals(nicId) && that.lanId == lanId;
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 97 * hash + Objects.hashCode(this.nicId);
      hash = 97 * hash + this.lanId;
      return hash;
   }

   public static NicBuilder describingBuilder() {
      return new NicBuilder();
   }

   public static CreateNicRequestBuilder creatingBuilder() {
      return new CreateNicRequestBuilder();
   }

   public static UpdateNicRequestBuilder updatingBuilder() {
      return new UpdateNicRequestBuilder();
   }

   public Nic() {
   }

   public Nic(String nicId, String nicName, int lanId, Boolean internetAccess, String serverId, List<String> ips,
           String macAddress, Firewall firewall, Boolean dhcpActive, String gatewayIp, ProvisioningState provisioningState) {
      this.nicId = nicId;
      this.nicName = nicName;
      this.lanId = lanId;
      this.internetAccess = internetAccess;
      this.serverId = serverId;
      this.ips = ips;
      this.macAddress = macAddress;
      this.firewall = firewall;
      this.dhcpActive = dhcpActive;
      this.gatewayIp = gatewayIp;
      this.provisioningState = provisioningState;
   }

   public Nic(String nicId, String nicName, int lanId, Boolean internetAccess, String serverId, List<String> ips,
           String macAddress, Firewall firewall, Boolean dhcpActive, String gatewayIp, ProvisioningState provisioningState,
           String dataCenterId, Integer dataCenterVersion, String requestId) {
      super(dataCenterId, dataCenterVersion, requestId);
      this.nicId = nicId;
      this.nicName = nicName;
      this.lanId = lanId;
      this.internetAccess = internetAccess;
      this.serverId = serverId;
      this.ips = (List<String>) (ips == null ? Lists.newArrayList() : ips);
      this.macAddress = macAddress;
      this.firewall = firewall;
      this.dhcpActive = dhcpActive;
      this.gatewayIp = gatewayIp;
      this.provisioningState = provisioningState;
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
    * Gets the value of the lanId property.
    *
    */
   public int getLanId() {
      return lanId;
   }

   /**
    * Sets the value of the lanId property.
    *
    */
   public void setLanId(int value) {
      this.lanId = value;
   }

   /**
    * Gets the value of the internetAccess property.
    *
    * @return possible object is {@link Boolean }
    *
    */
   public Boolean isInternetAccess() {
      return internetAccess;
   }

   /**
    * Sets the value of the internetAccess property.
    *
    * @param value allowed object is {@link Boolean }
    *
    */
   public void setInternetAccess(Boolean value) {
      this.internetAccess = value;
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
    * Gets the value of the macAddress property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getMacAddress() {
      return macAddress;
   }

   /**
    * Sets the value of the macAddress property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setMacAddress(String value) {
      this.macAddress = value;
   }

   /**
    * Gets the value of the firewall property.
    *
    * @return possible object is {@link Firewall }
    *
    */
   public Firewall getFirewall() {
      return firewall;
   }

   /**
    * Sets the value of the firewall property.
    *
    * @param value allowed object is {@link Firewall }
    *
    */
   public void setFirewall(Firewall value) {
      this.firewall = value;
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

   /**
    * Gets the value of the gatewayIp property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getGatewayIp() {
      return gatewayIp;
   }

   /**
    * Sets the value of the gatewayIp property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setGatewayIp(String value) {
      this.gatewayIp = value;
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
    * Sets the value of the provisioningState property.
    *
    * @param value allowed object is {@link ProvisioningState }
    *
    */
   public void setProvisioningState(ProvisioningState value) {
      this.provisioningState = value;
   }

}
