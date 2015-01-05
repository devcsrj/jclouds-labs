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
package org.jclouds.profitbricks.domain.loadbalancer.register;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.loadbalancer.BalancedServer;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for registerLbServerResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="registerLbServerResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="loadBalancerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="balancedServers" type="{http://ws.api.profitbricks.com/}balancedServer" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registerLbServerResponse", propOrder = {
   "loadBalancerId",
   "lanId",
   "balancedServers"
})
public class RegisterLbServerResponse
        extends VersionResponse {

   protected String loadBalancerId;
   protected int lanId;
   @XmlElement(nillable = true)
   protected List<BalancedServer> balancedServers;

   public RegisterLbServerResponse() {
      this.balancedServers = Lists.newArrayList();
   }

   /**
    * Gets the value of the loadBalancerId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getLoadBalancerId() {
      return loadBalancerId;
   }

   /**
    * Sets the value of the loadBalancerId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setLoadBalancerId(String value) {
      this.loadBalancerId = value;
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
    * Gets the value of the balancedServers property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the balancedServers property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getBalancedServers().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link BalancedServer }
    *
    *
    */
   public List<BalancedServer> getBalancedServers() {
      return this.balancedServers;
   }

}
