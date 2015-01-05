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
package org.jclouds.profitbricks.domain.firewall.add;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.firewall.FirewallRuleRequest;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for addFirewallRulesToNic complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="addFirewallRulesToNic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="request" type="{http://ws.api.profitbricks.com/}firewallRuleRequest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nicId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addFirewallRulesToNic", propOrder = {
   "request",
   "nicId"
})
public class AddFirewallRulesToNic {

   protected List<FirewallRuleRequest> request;
   protected String nicId;

   public AddFirewallRulesToNic() {
      this.request = Lists.newArrayList();
   }

   public AddFirewallRulesToNic(List<FirewallRuleRequest> request, String nicId) {
      this.request = (List<FirewallRuleRequest>) (request == null ? Lists.newArrayList() : request);
      this.nicId = nicId;
   }

   /**
    * Gets the value of the request property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the request property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getRequest().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link FirewallRuleRequest }
    *
    *
    */
   public List<FirewallRuleRequest> getRequest() {
      return this.request;
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

}
