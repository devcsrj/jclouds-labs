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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for location.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="location"> &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"> &lt;enumeration
 * value="de/fkb"/> &lt;enumeration value="de/fra"/> &lt;enumeration value="us/las"/> &lt;/restriction> &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "location")
@XmlEnum
public enum Location {

   @XmlEnumValue("de/fkb")
   DE_FKB("de/fkb"),
   @XmlEnumValue("de/fra")
   DE_FRA("de/fra"),
   @XmlEnumValue("us/las")
   US_LAS("us/las"),
   @XmlEnumValue("us/lasdev")
   US_LASDEV("us/lasdev"),
   UNRECOGNIZED("unknown");
   private final String value;

   Location(String v) {
      value = v;
   }

   public String value() {
      return value;
   }

   public static Location fromValue(String v) {
      try {
         return valueOf(v);
      } catch (IllegalArgumentException ex) {
         return UNRECOGNIZED;
      }
   }

}
