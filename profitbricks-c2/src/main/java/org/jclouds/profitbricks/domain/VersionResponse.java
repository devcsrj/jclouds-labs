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
package org.jclouds.profitbricks.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.datacenter.DataCenter;
import org.jclouds.profitbricks.domain.loadbalancer.LoadBalancer;
import org.jclouds.profitbricks.domain.loadbalancer.create.CreateLbResponse;
import org.jclouds.profitbricks.domain.loadbalancer.register.RegisterLbServerResponse;
import org.jclouds.profitbricks.domain.nic.Nic;
import org.jclouds.profitbricks.domain.nic.create.CreateNicResponse;
import org.jclouds.profitbricks.domain.server.Server;
import org.jclouds.profitbricks.domain.server.create.CreateServerResponse;
import org.jclouds.profitbricks.domain.storage.Storage;
import org.jclouds.profitbricks.domain.storage.create.CreateStorageResponse;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for versionResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="versionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}requestResponse">
 *       &lt;sequence>
 *         &lt;element name="dataCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCenterVersion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionResponse", propOrder = {
   "dataCenterId",
   "dataCenterVersion"
})
@XmlSeeAlso({
   CreateNicResponse.class,
   CreateStorageResponse.class,
   DataCenter.class,
   CreateServerResponse.class,
   CreateLbResponse.class,
   LoadBalancer.class,
   RegisterLbServerResponse.class,
   Nic.class,
   Server.class,
   Storage.class
})
public class VersionResponse
        extends RequestResponse {

   protected String dataCenterId;
   protected Integer dataCenterVersion;

   public VersionResponse() {
   }

   public VersionResponse(String dataCenterId, Integer dataCenterVersion) {
      this.dataCenterId = dataCenterId;
      this.dataCenterVersion = dataCenterVersion;
   }

   public VersionResponse(String dataCenterId, Integer dataCenterVersion, String requestId) {
      super(requestId);
      this.dataCenterId = dataCenterId;
      this.dataCenterVersion = dataCenterVersion;
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
    * Gets the value of the dataCenterVersion property.
    *
    * @return possible object is {@link Integer }
    *
    */
   public Integer getDataCenterVersion() {
      return dataCenterVersion;
   }

   /**
    * Sets the value of the dataCenterVersion property.
    *
    * @param value allowed object is {@link Integer }
    *
    */
   public void setDataCenterVersion(Integer value) {
      this.dataCenterVersion = value;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof VersionResponse))
         return false;
      VersionResponse vdc = (VersionResponse) obj;
      return vdc.dataCenterId.equals(dataCenterId) && vdc.dataCenterVersion.equals(dataCenterVersion);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 43 * hash + Objects.hashCode(this.dataCenterId);
      hash = 43 * hash + Objects.hashCode(this.dataCenterVersion);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("%s, VersionResponse: %s (%s)", super.toString(), dataCenterId, dataCenterVersion);
   }

}
