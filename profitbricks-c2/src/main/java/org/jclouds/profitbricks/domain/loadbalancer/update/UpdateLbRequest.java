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
package org.jclouds.profitbricks.domain.loadbalancer.update;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancerAlgorithm;

/**
 * <p>
 * Java class for updateLbRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="updateLbRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loadBalancerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loadBalancerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadBalancerAlgorithm" type="{http://ws.api.profitbricks.com/}loadBalancerAlgorithm" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateLbRequest", propOrder = {
   "loadBalancerId",
   "loadBalancerName",
   "loadBalancerAlgorithm",
   "ip"
})
public class UpdateLbRequest {

   @XmlElement(required = true)
   protected String loadBalancerId;
   protected String loadBalancerName;
   protected LoadBalancerAlgorithm loadBalancerAlgorithm;
   protected String ip;

   public UpdateLbRequest() {
   }

   public UpdateLbRequest(String loadBalancerId, String loadBalancerName, LoadBalancerAlgorithm loadBalancerAlgorithm, String ip) {
      this.loadBalancerId = loadBalancerId;
      this.loadBalancerName = loadBalancerName;
      this.loadBalancerAlgorithm = loadBalancerAlgorithm;
      this.ip = ip;
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
    * Gets the value of the loadBalancerName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getLoadBalancerName() {
      return loadBalancerName;
   }

   /**
    * Sets the value of the loadBalancerName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setLoadBalancerName(String value) {
      this.loadBalancerName = value;
   }

   /**
    * Gets the value of the loadBalancerAlgorithm property.
    *
    * @return possible object is {@link LoadBalancerAlgorithm }
    *
    */
   public LoadBalancerAlgorithm getLoadBalancerAlgorithm() {
      return loadBalancerAlgorithm;
   }

   /**
    * Sets the value of the loadBalancerAlgorithm property.
    *
    * @param value allowed object is {@link LoadBalancerAlgorithm }
    *
    */
   public void setLoadBalancerAlgorithm(LoadBalancerAlgorithm value) {
      this.loadBalancerAlgorithm = value;
   }

   /**
    * Gets the value of the ip property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getIp() {
      return ip;
   }

   /**
    * Sets the value of the ip property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setIp(String value) {
      this.ip = value;
   }

}
