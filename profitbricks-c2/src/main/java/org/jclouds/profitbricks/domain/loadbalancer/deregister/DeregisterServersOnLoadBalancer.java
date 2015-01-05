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
package org.jclouds.profitbricks.domain.loadbalancer.deregister;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for deregisterServersOnLoadBalancer complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="deregisterServersOnLoadBalancer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serverIds" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loadBalancerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deregisterServersOnLoadBalancer", propOrder = {
   "serverIds",
   "loadBalancerId"
})
public class DeregisterServersOnLoadBalancer {

   protected List<String> serverIds;
   protected String loadBalancerId;

   public DeregisterServersOnLoadBalancer() {
      this.serverIds = Lists.newArrayList();
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

}
