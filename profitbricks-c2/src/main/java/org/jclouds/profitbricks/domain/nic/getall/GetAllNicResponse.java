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
package org.jclouds.profitbricks.domain.nic.getall;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.profitbricks.domain.nic.Nic;

import com.google.common.collect.Lists;

/**
 * <p>
 * Java class for getAllNicResponse complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getAllNicResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.api.profitbricks.com/}nic" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "getAllNicResponse", propOrder = {
   "_return"
})
public class GetAllNicResponse {

   @XmlElement(name = "return")
   protected List<Nic> _return;

   public GetAllNicResponse() {
      this._return = Lists.newArrayList();
   }

   public GetAllNicResponse(List<Nic> _return) {
      this._return = (List<Nic>) (_return == null ? Lists.newArrayList() : _return);
   }

   /**
    * Gets the value of the return property.
    *
    * <p>
    * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
    * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
    * the return property.
    *
    * <p>
    * For example, to add a new item, do as follows:
    * <pre>
    *    getReturn().add(newItem);
    * </pre>
    *
    *
    * <p>
    * Objects of the following type(s) are allowed in the list {@link Nic }
    *
    *
    */
   public List<Nic> getReturn() {
      return this._return;
   }

}
