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
package org.jclouds.profitbricks.domain.loadbalancer.create;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancerAlgorithm;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for createLbRequest complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="createLbRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataCenterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loadBalancerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadBalancerAlgorithm" type="{http://ws.api.profitbricks.com/}loadBalancerAlgorithm" minOccurs="0"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lanId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="serverIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createLbRequest", propOrder = {
   "dataCenterId",
   "loadBalancerName",
   "loadBalancerAlgorithm",
   "ip",
   "lanId",
   "serverIds"
})
public class CreateLbRequest {

   @XmlElement(required = true)
   protected String dataCenterId;
   @XmlElement(defaultValue = "Load Balancer")
   protected String loadBalancerName;
   @XmlElement(defaultValue = "ROUND_ROBIN")
   protected LoadBalancerAlgorithm loadBalancerAlgorithm;
   protected String ip;
   protected Integer lanId;
   @XmlElement(nillable = true)
   protected List<String> serverIds;

   public CreateLbRequest() {
      this.serverIds = Lists.newArrayList();
   }

   public CreateLbRequest(String dataCenterId, String loadBalancerName, LoadBalancerAlgorithm loadBalancerAlgorithm,
           String ip, Integer lanId, List<String> serverIds) {
      this.dataCenterId = dataCenterId;
      this.loadBalancerName = loadBalancerName;
      this.loadBalancerAlgorithm = loadBalancerAlgorithm;
      this.ip = ip;
      this.lanId = lanId;
      this.serverIds = (List<String>) (serverIds == null ? Lists.newArrayList() : serverIds);
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

   /**
    * Gets the value of the lanId property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getLanId() {
      return lanId;
   }

   /**
    * Sets the value of the lanId property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setLanId(Integer value) {
      this.lanId = value;
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

}
