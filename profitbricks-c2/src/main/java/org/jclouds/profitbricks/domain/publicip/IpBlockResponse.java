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

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.Location;
import org.jclouds.profitbricks.domain.RequestResponse;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for ipBlockResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ipBlockResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.api.profitbricks.com/}requestResponse">
 *       &lt;sequence>
 *         &lt;element name="blockId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://ws.api.profitbricks.com/}location" minOccurs="0"/>
 *         &lt;element name="ips" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ipBlockResponse", propOrder = {
   "blockId",
   "location",
   "ips"
})
public class IpBlockResponse
        extends RequestResponse {

   protected String blockId;
   protected Location location;
   @XmlElement(nillable = true)
   protected List<String> ips;

   public IpBlockResponse() {
      this.ips = Lists.newArrayList();
   }

   /**
    * Gets the value of the blockId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getBlockId() {
      return blockId;
   }

   /**
    * Sets the value of the blockId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setBlockId(String value) {
      this.blockId = value;
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

   /**
    * Sets the value of the location property.
    *
    * @param value allowed object is {@link Location }
    *
    */
   public void setLocation(Location value) {
      this.location = value;
   }

   /**
    * Gets the value of the ips property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the ips property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getIps().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link String }
    *
    *
    */
   public List<String> getIps() {
      return this.ips;
   }

}
