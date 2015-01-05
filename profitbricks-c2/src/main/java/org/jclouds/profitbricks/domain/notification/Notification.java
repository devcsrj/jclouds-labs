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
package org.jclouds.profitbricks.domain.notification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for notification complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="notification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="networkUUid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedItemUuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="messageCode" type="{http://ws.api.profitbricks.com/}notificationCode" minOccurs="0"/>
 *         &lt;element name="relatedItemType" type="{http://ws.api.profitbricks.com/}virtualItemType" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notification", propOrder = {
   "id",
   "networkUUid",
   "relatedItemUuid",
   "timestamp",
   "messageCode",
   "relatedItemType",
   "message"
})
public class Notification {

   protected String id;
   protected String networkUUid;
   protected String relatedItemUuid;
   @XmlSchemaType(name = "dateTime")
   protected XMLGregorianCalendar timestamp;
   protected NotificationCode messageCode;
   protected VirtualItemType relatedItemType;
   protected String message;

   @Override
   public String toString() {
      return String.format("[%s (%s) - %s] %s, %s", id, networkUUid, messageCode, relatedItemType, message);
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof Notification))
         return false;
      Notification that = Notification.class.cast(obj);
      return that.id.equals(id) && that.networkUUid.equals(networkUUid) && that.relatedItemUuid.equals(relatedItemUuid)
              && that.messageCode.equals(messageCode) && that.relatedItemType.equals(relatedItemType)
              && that.timestamp.equals(timestamp);
   }

   @Override
   public int hashCode() {
      int hash = 7;
      hash = 13 * hash + Objects.hashCode(this.id);
      hash = 13 * hash + Objects.hashCode(this.networkUUid);
      hash = 13 * hash + Objects.hashCode(this.relatedItemUuid);
      hash = 13 * hash + Objects.hashCode(this.timestamp);
      hash = 13 * hash + Objects.hashCode(this.messageCode);
      hash = 13 * hash + Objects.hashCode(this.relatedItemType);
      return hash;
   }

   /**
    * Gets the value of the id property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getId() {
      return id;
   }

   /**
    * Sets the value of the id property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setId(String value) {
      this.id = value;
   }

   /**
    * Gets the value of the networkUUid property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getNetworkUUid() {
      return networkUUid;
   }

   /**
    * Sets the value of the networkUUid property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setNetworkUUid(String value) {
      this.networkUUid = value;
   }

   /**
    * Gets the value of the relatedItemUuid property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getRelatedItemUuid() {
      return relatedItemUuid;
   }

   /**
    * Sets the value of the relatedItemUuid property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setRelatedItemUuid(String value) {
      this.relatedItemUuid = value;
   }

   /**
    * Gets the value of the timestamp property.
    *
    * @return possible object is {@link XMLGregorianCalendar }
    *
    */
   public XMLGregorianCalendar getTimestamp() {
      return timestamp;
   }

   /**
    * Sets the value of the timestamp property.
    *
    * @param value allowed object is {@link XMLGregorianCalendar }
    *
    */
   public void setTimestamp(XMLGregorianCalendar value) {
      this.timestamp = value;
   }

   /**
    * Gets the value of the messageCode property.
    *
    * @return possible object is {@link NotificationCode }
    *
    */
   public NotificationCode getMessageCode() {
      return messageCode;
   }

   /**
    * Sets the value of the messageCode property.
    *
    * @param value allowed object is {@link NotificationCode }
    *
    */
   public void setMessageCode(NotificationCode value) {
      this.messageCode = value;
   }

   /**
    * Gets the value of the relatedItemType property.
    *
    * @return possible object is {@link VirtualItemType }
    *
    */
   public VirtualItemType getRelatedItemType() {
      return relatedItemType;
   }

   /**
    * Sets the value of the relatedItemType property.
    *
    * @param value allowed object is {@link VirtualItemType }
    *
    */
   public void setRelatedItemType(VirtualItemType value) {
      this.relatedItemType = value;
   }

   /**
    * Gets the value of the message property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getMessage() {
      return message;
   }

   /**
    * Sets the value of the message property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setMessage(String value) {
      this.message = value;
   }

}
