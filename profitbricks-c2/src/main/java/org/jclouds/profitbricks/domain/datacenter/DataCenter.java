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
package org.jclouds.profitbricks.domain.datacenter;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponse;
import org.jclouds.profitbricks.domain.datacenter.update.UpdateDcRequestBuilder;
import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancer;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.storage.Storage;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for dataCenter complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="dataCenter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}versionResponse">
 *       &lt;sequence>
 *         &lt;element name="dataCenterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servers" type="{http://ws.api.profitbricks.com/}server" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="storages" type="{http://ws.api.profitbricks.com/}storage" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="loadBalancers" type="{http://ws.api.profitbricks.com/}loadBalancer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="provisioningState" type="{http://ws.api.profitbricks.com/}provisioningState" minOccurs="0"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataCenter", propOrder = {
   "dataCenterName",
   "servers",
   "storages",
   "loadBalancers",
   "provisioningState",
   "location"
})
public class DataCenter
        extends VersionResponse {

   protected String dataCenterName;
   @XmlElement(nillable = true)
   protected List<Server> servers;
   @XmlElement(nillable = true)
   protected List<Storage> storages;
   @XmlElement(nillable = true)
   protected List<LoadBalancer> loadBalancers;
   protected ProvisioningState provisioningState;
   protected Location location;

   public static DataCenterDescribingBuilder builder() {
      return new DataCenterDescribingBuilder();
   }

   public static DataCenterCreatingBuilder creatingBuilder() {
      return new DataCenterCreatingBuilder();
   }

   public static UpdateDcRequestBuilder updatingBuilder() {
      return new UpdateDcRequestBuilder();
   }

   public DataCenter() {
   }

   public DataCenter(String dataCenterName, List<Server> servers, List<Storage> storages, List<LoadBalancer> loadBalancers,
           ProvisioningState provisioningState, Location location, String dataCenterId, Integer dataCenterVersion) {
      super(dataCenterId, dataCenterVersion);
      this.dataCenterName = dataCenterName;
      this.servers = (List<Server>) (servers == null ? Lists.newArrayList() : servers);
      this.storages = (List<Storage>) (storages == null ? Lists.newArrayList() : storages);
      this.loadBalancers = (List<LoadBalancer>) (loadBalancers == null ? Lists.newArrayList() : loadBalancers);
      this.provisioningState = provisioningState;
      this.location = location;
   }

   public DataCenter(String dataCenterName, List<Server> servers, List<Storage> storages, List<LoadBalancer> loadBalancers, ProvisioningState provisioningState, Location location) {
      this(dataCenterName, servers, storages, loadBalancers, provisioningState, location, null, 0);
   }

   /**
    * Gets the value of the dataCenterName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getDataCenterName() {
      return dataCenterName;
   }

   /**
    * Gets the value of the servers property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the servers property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getServers().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Server2 }
    *
    *
    */
   public List<Server> getServers() {
      return this.servers;
   }

   /**
    * Gets the value of the storages property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the storages property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getStorages().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Storage }
    *
    *
    */
   public List<Storage> getStorages() {
      return this.storages;
   }

   /**
    * Gets the value of the loadBalancers property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the loadBalancers property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getLoadBalancers().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link LoadBalancer }
    *
    *
    */
   public List<LoadBalancer> getLoadBalancers() {
      return this.loadBalancers;
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
    * Gets the value of the location property.
    *
    * @return possible object is {@link Location }
    *
    */
   public Location getLocation() {
      return location;
   }

   public void setDataCenterName(String dataCenterName) {
      this.dataCenterName = dataCenterName;
   }

   public void setServers(List<Server> servers) {
      this.servers = servers;
   }

   public void setStorages(List<Storage> storages) {
      this.storages = storages;
   }

   public void setLoadBalancers(List<LoadBalancer> loadBalancers) {
      this.loadBalancers = loadBalancers;
   }

   public void setProvisioningState(ProvisioningState provisioningState) {
      this.provisioningState = provisioningState;
   }

   public void setLocation(Location location) {
      this.location = location;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, v%s - %s", dataCenterId, dataCenterName, dataCenterVersion, location);
   }

}
