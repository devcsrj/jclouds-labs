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
package org.jclouds.profitbricks.domain.publicip.get;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.publicip.IpBlock;

/**
 * <p>
 * Java class for getPublicIpBlockResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getPublicIpBlockResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.api.profitbricks.com/}ipBlock" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(namespace = "http://ws.api.profitbricks.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPublicIpBlockResponse", propOrder = {
   "_return"
})
public class GetPublicIpBlockResponse {

   @XmlElement(name = "return")
   protected IpBlock _return;

   /**
    * Gets the value of the return property.
    *
    * @return possible object is {@link IpBlock }
    *
    */
   public IpBlock getReturn() {
      return _return;
   }

   /**
    * Sets the value of the return property.
    *
    * @param value allowed object is {@link IpBlock }
    *
    */
   public void setReturn(IpBlock value) {
      this._return = value;
   }

}
