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

/**
 * <p>
 * Java class for virtualMachineState.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="virtualMachineState"> &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 * &lt;enumeration value="NOSTATE"/> &lt;enumeration value="RUNNING"/> &lt;enumeration value="BLOCKED"/> &lt;enumeration
 * value="PAUSED"/> &lt;enumeration value="SHUTDOWN"/> &lt;enumeration value="SHUTOFF"/> &lt;enumeration
 * value="CRASHED"/> &lt;/restriction> &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "virtualMachineState")
@XmlEnum
public enum VirtualMachineState {

   NOSTATE, RUNNING, BLOCKED, PAUSED, SHUTDOWN, SHUTOFF, CRASHED, UNRECOGNIZED;

   public String value() {
      return name();
   }

   public static VirtualMachineState fromValue(String value) {
      try {
         return valueOf(value);
      } catch (IllegalArgumentException e) {
         return UNRECOGNIZED;
      }
   }
}
