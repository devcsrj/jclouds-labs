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
package org.jclouds.profitbricks.domain.nic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for protocol.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="protocol"> &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"> &lt;enumeration
 * value="TCP"/> &lt;enumeration value="UDP"/> &lt;enumeration value="ICMP"/> &lt;enumeration value="ANY"/>
 * &lt;/restriction> &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "protocol")
@XmlEnum
public enum Protocol {

   TCP,
   UDP,
   ICMP,
   ANY;

   public String value() {
      return name();
   }

   public static Protocol fromValue(String v) {
      return valueOf(v);
   }

}
