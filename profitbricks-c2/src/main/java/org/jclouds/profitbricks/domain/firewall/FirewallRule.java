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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.nic.Protocol;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for firewallRule complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="firewallRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firewallRuleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="icmpCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="icmpType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portRangeEnd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="portRangeStart" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="protocol" type="{http://ws.api.profitbricks.com/}protocol" minOccurs="0"/>
 *         &lt;element name="sourceIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceMac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetIp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firewallRule", propOrder = {
   "firewallRuleId",
   "icmpCode",
   "icmpType",
   "name",
   "portRangeEnd",
   "portRangeStart",
   "protocol",
   "sourceIp",
   "sourceMac",
   "targetIp"
})
public class FirewallRule {

   protected String firewallRuleId;
   protected Integer icmpCode;
   protected Integer icmpType;
   protected String name;
   protected Integer portRangeEnd;
   protected Integer portRangeStart;
   protected Protocol protocol;
   protected String sourceIp;
   protected String sourceMac;
   protected String targetIp;

   @Override
   public String toString() {
      return String.format("[%s] %s, icmpCode=%d, icmpType=%d, portRange=%d-%d, protocol=%s, sourceIp=%s, sourceMac=%s, targetIp=%s",
              firewallRuleId, name, icmpCode, icmpType, portRangeStart, portRangeEnd, protocol, sourceIp, sourceMac, targetIp);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof FirewallRule))
         return false;
      FirewallRule that = FirewallRule.class.cast(obj);
      return that.firewallRuleId.equals(this.firewallRuleId);
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 53 * hash + Objects.hashCode(this.firewallRuleId);
      return hash;
   }

   /**
    * Gets the value of the firewallRuleId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getFirewallRuleId() {
      return firewallRuleId;
   }

   /**
    * Sets the value of the firewallRuleId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setFirewallRuleId(String value) {
      this.firewallRuleId = value;
   }

   /**
    * Gets the value of the icmpCode property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getIcmpCode() {
      return icmpCode;
   }

   /**
    * Sets the value of the icmpCode property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setIcmpCode(Integer value) {
      this.icmpCode = value;
   }

   /**
    * Gets the value of the icmpType property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getIcmpType() {
      return icmpType;
   }

   /**
    * Sets the value of the icmpType property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setIcmpType(Integer value) {
      this.icmpType = value;
   }

   /**
    * Gets the value of the name property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getName() {
      return name;
   }

   /**
    * Sets the value of the name property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setName(String value) {
      this.name = value;
   }

   /**
    * Gets the value of the portRangeEnd property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getPortRangeEnd() {
      return portRangeEnd;
   }

   /**
    * Sets the value of the portRangeEnd property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setPortRangeEnd(Integer value) {
      this.portRangeEnd = value;
   }

   /**
    * Gets the value of the portRangeStart property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getPortRangeStart() {
      return portRangeStart;
   }

   /**
    * Sets the value of the portRangeStart property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setPortRangeStart(Integer value) {
      this.portRangeStart = value;
   }

   /**
    * Gets the value of the protocol property.
    *
    * @return possible object is {@link Protocol }
    *
    */
   public Protocol getProtocol() {
      return protocol;
   }

   /**
    * Sets the value of the protocol property.
    *
    * @param value allowed object is {@link Protocol }
    *
    */
   public void setProtocol(Protocol value) {
      this.protocol = value;
   }

   /**
    * Gets the value of the sourceIp property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getSourceIp() {
      return sourceIp;
   }

   /**
    * Sets the value of the sourceIp property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setSourceIp(String value) {
      this.sourceIp = value;
   }

   /**
    * Gets the value of the sourceMac property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getSourceMac() {
      return sourceMac;
   }

   /**
    * Sets the value of the sourceMac property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setSourceMac(String value) {
      this.sourceMac = value;
   }

   /**
    * Gets the value of the targetIp property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getTargetIp() {
      return targetIp;
   }

   /**
    * Sets the value of the targetIp property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setTargetIp(String value) {
      this.targetIp = value;
   }

}
