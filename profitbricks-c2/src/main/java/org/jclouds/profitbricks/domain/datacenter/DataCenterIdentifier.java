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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.ProvisioningState;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for dataCenterIdentifier complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="dataCenterIdentifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataCenterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCenterName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCenterVersion" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "dataCenterIdentifier", propOrder = {
   "dataCenterId",
   "dataCenterName",
   "dataCenterVersion",
   "provisioningState"
})
public class DataCenterIdentifier {

   protected String dataCenterId;
   protected String dataCenterName;
   protected Integer dataCenterVersion;
   protected ProvisioningState provisioningState;

   public DataCenterIdentifier() {
   }

   public DataCenterIdentifier(String dataCenterId, String dataCenterName, Integer dataCenterVersion, ProvisioningState provisioningState) {
      this.dataCenterId = dataCenterId;
      this.dataCenterName = dataCenterName;
      this.dataCenterVersion = dataCenterVersion;
      this.provisioningState = provisioningState;
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
    * Gets the value of the dataCenterName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getDataCenterName() {
      return dataCenterName;
   }

   /**
    * Sets the value of the dataCenterName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setDataCenterName(String value) {
      this.dataCenterName = value;
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

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof DataCenterIdentifier))
         return false;
      DataCenterIdentifier dc = DataCenterIdentifier.class.cast(obj);
      return dc.dataCenterId.equals(dataCenterId) && dc.dataCenterVersion.equals(dataCenterVersion);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 47 * hash + Objects.hashCode(this.dataCenterId);
      hash = 47 * hash + Objects.hashCode(this.dataCenterVersion);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s, v%s (%s)", dataCenterId, dataCenterName, dataCenterVersion, provisioningState);
   }

}
