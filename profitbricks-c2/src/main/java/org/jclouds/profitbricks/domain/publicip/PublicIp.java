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
package org.jclouds.profitbricks.domain.publicip;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.publicip.reserve.CreateReservePublicIpBlockRequestBuilder;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for publicIp complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="publicIp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "publicIp", propOrder = {
   "ip",
   "nicId"
})
public class PublicIp {

   @XmlElement(required = true)
   protected String ip;
   protected String nicId;

   @Override
   public String toString() {
      return String.format("[%s] %s", ip, nicId);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof PublicIp))
         return false;
      PublicIp that = PublicIp.class.cast(obj);
      return that.ip.equals(ip) && that.nicId.equals(nicId);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 97 * hash + Objects.hashCode(this.ip);
      hash = 97 * hash + Objects.hashCode(this.nicId);
      return hash;
   }

   public static CreateReservePublicIpBlockRequestBuilder ipReservingBuilder() {
      return new CreateReservePublicIpBlockRequestBuilder();
   }

   public PublicIp() {
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
