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
package org.jclouds.profitbricks.domain.firewall;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.firewall.add.AddFirewallRulesToNicBuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for firewall complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="firewall">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="firewallId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firewallRules" type="{http://ws.api.profitbricks.com/}firewallRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firewall", propOrder = {
   "active",
   "firewallId",
   "firewallRules",
   "nicId",
   "provisioningState"
})
public class Firewall {

   protected boolean active;
   protected String firewallId;
   @XmlElement(nillable = true)
   protected List<FirewallRule> firewallRules;
   protected String nicId;
   protected ProvisioningState provisioningState;

   @Override
   public String toString() {
      return String.format("[%s] [Active=%b] NIC=%s, %d rules, (%s)", firewallId, active, nicId,
              firewallRules.size(), provisioningState);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof Firewall))
         return false;
      Firewall that = Firewall.class.cast(obj);
      return that.firewallId.equals(obj) && that.nicId.equals(nicId);
   }

   @Override
   public int hashCode() {
      int hash = 3;
      hash = 89 * hash + Objects.hashCode(this.firewallId);
      hash = 89 * hash + Objects.hashCode(this.nicId);
      return hash;
   }

   public static AddFirewallRulesToNicBuilder ruleAddingToNicBuilder() {
      return new AddFirewallRulesToNicBuilder();
   }

   public Firewall() {
      this.firewallRules = Lists.newArrayList();
   }

   /**
    * Gets the value of the active property.
    *
    */
   public boolean isActive() {
      return active;
   }

   /**
    * Sets the value of the active property.
    *
    */
   public void setActive(boolean value) {
      this.active = value;
   }

   /**
    * Gets the value of the firewallId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getFirewallId() {
      return firewallId;
   }

   /**
    * Sets the value of the firewallId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setFirewallId(String value) {
      this.firewallId = value;
   }

   /**
    * Gets the value of the firewallRules property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the firewallRules property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getFirewallRules().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link FirewallRule }
    *
    *
    */
   public List<FirewallRule> getFirewallRules() {
      return this.firewallRules;
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
