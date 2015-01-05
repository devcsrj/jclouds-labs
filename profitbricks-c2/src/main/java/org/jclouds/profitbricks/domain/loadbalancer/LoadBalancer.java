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
package org.jclouds.profitbricks.domain.loadbalancer;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.firewall.Firewall;
import org.jclouds.profitbricks.domain.loadbalancer.create.CreateLbRequestBuilder;
import org.jclouds.profitbricks.domain.loadbalancer.register.ServerRegistrationOnLoadBalancerRequestBuilder;
import org.jclouds.profitbricks.domain.loadbalancer.update.UpdateLbRequestBuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for loadBalancer complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="loadBalancer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="loadBalancerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadBalancerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loadBalancerAlgorithm" type="{http://ws.api.profitbricks.com/}loadBalancerAlgorithm" minOccurs="0"/>
 *         &lt;element name="internetAccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lanId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="balancedServers" type="{http://ws.api.profitbricks.com/}balancedServer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState" minOccurs="0"/>
 *         &lt;element name="creationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastModificationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="firewall" type="{http://ws.api.profitbricks.com/}firewall" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loadBalancer", propOrder = {
   "loadBalancerId",
   "loadBalancerName",
   "loadBalancerAlgorithm",
   "internetAccess",
   "ip",
   "lanId",
   "balancedServers",
   "provisioningState",
   "creationTime",
   "lastModificationTime",
   "firewall"
})
public class LoadBalancer
        extends VersionResponse {

   protected String loadBalancerId;
   protected String loadBalancerName;
   protected LoadBalancerAlgorithm loadBalancerAlgorithm;
   protected boolean internetAccess;
   protected String ip;
   protected int lanId;
   @XmlElement(nillable = true)
   protected List<BalancedServer> balancedServers;
   protected ProvisioningState provisioningState;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar creationTime;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar lastModificationTime;
   protected Firewall firewall;

   @Override
   public String toString() {
      return String.format("[%s] %s, %s, %s, lanId=%s, hasInternet=%b, (%s)", loadBalancerId, loadBalancerName,
              loadBalancerAlgorithm, ip, lanId, internetAccess, provisioningState);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof LoadBalancer))
         return false;
      LoadBalancer that = LoadBalancer.class.cast(obj);
      return that.loadBalancerId.equals(loadBalancerId) && that.lanId == lanId && that.ip.equals(ip);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 79 * hash + Objects.hashCode(this.loadBalancerId);
      hash = 79 * hash + Objects.hashCode(this.ip);
      hash = 79 * hash + this.lanId;
      return hash;
   }

   public CreateLbRequestBuilder creatingBuilder() {
      return new CreateLbRequestBuilder();
   }

   public UpdateLbRequestBuilder updatingBuilder() {
      return new UpdateLbRequestBuilder();
   }

   public ServerRegistrationOnLoadBalancerRequestBuilder serverRegisteringBuilder() {
      return new ServerRegistrationOnLoadBalancerRequestBuilder();
   }

   public LoadBalancer() {
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
    * Gets the value of the internetAccess property.
    *
    */
   public boolean isInternetAccess() {
      return internetAccess;
   }

   /**
    * Sets the value of the internetAccess property.
    *
    */
   public void setInternetAccess(boolean value) {
      this.internetAccess = value;
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
    * Sets the value of the creationTime property.
    *
    * @param value allowed object is {@link XMLGregorianCalendar }
    *
    */
   public void setCreationTime(XMLGregorianCalendar value) {
      this.creationTime = value;
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
    * Sets the value of the lastModificationTime property.
    *
    * @param value allowed object is {@link XMLGregorianCalendar }
    *
    */
   public void setLastModificationTime(XMLGregorianCalendar value) {
      this.lastModificationTime = value;
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

}
