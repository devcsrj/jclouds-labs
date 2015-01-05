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

import org.jclouds.profitbricks.domain.datacenter.create.CreateDcResponse;
import org.jclouds.profitbricks.domain.publicip.IpBlockResponse;
import org.jclouds.profitbricks.domain.snapshot.Snapshot;
import org.jclouds.profitbricks.domain.snapshot.create.CreateSnapshotResponse;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for requestResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="requestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestResponse", propOrder = {
   "requestId"
})
@XmlSeeAlso({
   Snapshot.class,
   CreateSnapshotResponse.class,
   IpBlockResponse.class,
   CreateDcResponse.class,
   VersionResponse.class
})
public class RequestResponse {

   protected String requestId;

   public RequestResponse() {
   }

   public RequestResponse(String requestId) {
      this.requestId = requestId;
   }

   /**
    * Gets the value of the requestId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getRequestId() {
      return requestId;
   }

   /**
    * Sets the value of the requestId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setRequestId(String value) {
      this.requestId = value;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (!(obj instanceof RequestResponse))
         return false;
      return ((RequestResponse) obj).requestId.equals(requestId);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 71 * hash + Objects.hashCode(this.requestId);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("Request ID: %s", requestId);
   }
}
