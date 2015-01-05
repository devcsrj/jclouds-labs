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
package org.jclouds.profitbricks.domain.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

import org.jclouds.domain.Location;
import org.jclouds.domain.LocationBuilder;
import org.jclouds.domain.LocationScope;

/**
 * <p>
 * Java class for availabilityZone.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="availabilityZone"> &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 * &lt;enumeration value="AUTO"/> &lt;enumeration value="ZONE_1"/> &lt;enumeration value="ZONE_2"/> &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "availabilityZone")
@XmlEnum
public enum AvailabilityZone {

   AUTO, ZONE_1, ZONE_2;

   public String value() {
      return name();
   }

   public static AvailabilityZone fromValue(String value) {
      try {
         return valueOf(value);
      } catch (IllegalArgumentException e) {
         return AUTO;
      }
   }

   public Location toLocation() {
      return toLocation(null);
   }

   public Location toLocation(Location parent) {
      return new LocationBuilder()
              .id(value())
              .description(value())
              .scope(LocationScope.ZONE)
              .parent(parent)
              .build();
   }
}
