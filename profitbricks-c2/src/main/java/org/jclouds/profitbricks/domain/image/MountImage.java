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
package org.jclouds.profitbricks.domain.image;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.google.common.base.Objects;

/**
 * <p>
 * Java class for mountImage complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="mountImage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mountImage", propOrder = {
   "imageId",
   "imageName"
})
public class MountImage {

   protected String imageId;
   protected String imageName;

   /**
    * Gets the value of the imageId property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getImageId() {
      return imageId;
   }

   /**
    * Sets the value of the imageId property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setImageId(String value) {
      this.imageId = value;
   }

   /**
    * Gets the value of the imageName property.
    *
    * @return possible object is {@link String }
    *
    */
   public String getImageName() {
      return imageName;
   }

   /**
    * Sets the value of the imageName property.
    *
    * @param value allowed object is {@link String }
    *
    */
   public void setImageName(String value) {
      this.imageName = value;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this)
         return true;
      if (!(obj instanceof MountImage))
         return false;
      return ((MountImage) obj).imageId.equals(imageId);
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 53 * hash + Objects.hashCode(this.imageId);
      return hash;
   }

   @Override
   public String toString() {
      return String.format("[%s] %s", imageId, imageName);
   }

}
