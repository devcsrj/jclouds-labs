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

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.jclouds.profitbricks.domain.OsType;
import org.jclouds.profitbricks.domain.ProvisioningState;
import org.jclouds.profitbricks.domain.VersionResponseBuilder;
import org.jclouds.profitbricks.domain.nic.Nic;
import org.jclouds.profitbricks.domain.romdrive.RomDrive;
import org.jclouds.profitbricks.domain.storage.connect.ConnectedStorage;

public class ServerBuilder extends VersionResponseBuilder<ServerBuilder> {

    private String serverId;
    private String serverName;
    private Integer cores;
    private Integer ram;
    private boolean internetAccess;
    private List<String> ips;
    private List<ConnectedStorage> connectedStorages;
    private List<RomDrive> romDrives;
    private List<Nic> nics;
    private ProvisioningState provisioningState;
    private VirtualMachineState virtualMachineState;
    private XMLGregorianCalendar creationTime;
    private XMLGregorianCalendar lastModificationTime;
    private OsType osType;
    private AvailabilityZone availabilityZone;
    private Boolean cpuHotPlug;
    private Boolean ramHotPlug;
    private Boolean nicHotPlug;
    private Boolean nicHotUnPlug;
    private Boolean discVirtioHotPlug;
    private Boolean discVirtioHotUnPlug;

    public ServerBuilder() {
    }

    public ServerBuilder serverId( String serverId ) {
        this.serverId = serverId;
        return self();
    }

    public ServerBuilder serverName( String serverName ) {
        this.serverName = serverName;
        return self();
    }

    public ServerBuilder cores( Integer cores ) {
        this.cores = cores;
        return self();
    }

    public ServerBuilder ram( Integer ram ) {
        this.ram = ram;
        return self();
    }

    public ServerBuilder internetAccess( boolean internetAccess ) {
        this.internetAccess = internetAccess;
        return self();
    }

    public ServerBuilder ips( List<String> ips ) {
        this.ips = ips;
        return self();
    }

    public ServerBuilder connectedStorages( List<ConnectedStorage> connectedStorages ) {
        this.connectedStorages = connectedStorages;
        return self();
    }

    public ServerBuilder romDrives( List<RomDrive> romDrives ) {
        this.romDrives = romDrives;
        return self();
    }

    public ServerBuilder nics( List<Nic> nics ) {
        this.nics = nics;
        return self();
    }

    public ServerBuilder provisioningState( ProvisioningState provisioningState ) {
        this.provisioningState = provisioningState;
        return self();
    }

    public ServerBuilder virtualMachineState( VirtualMachineState virtualMachineState ) {
        this.virtualMachineState = virtualMachineState;
        return self();
    }

    public ServerBuilder creationTime( XMLGregorianCalendar creationTime ) {
        this.creationTime = creationTime;
        return self();
    }

    public ServerBuilder lastModificationTime( XMLGregorianCalendar lastModificationTime ) {
        this.lastModificationTime = lastModificationTime;
        return self();
    }

    public ServerBuilder osType( OsType osType ) {
        this.osType = osType;
        return self();
    }

    public ServerBuilder availabilityZone( AvailabilityZone availabilityZone ) {
        this.availabilityZone = availabilityZone;
        return self();
    }

    public ServerBuilder cpuHotPlug( Boolean cpuHotPlug ) {
        this.cpuHotPlug = cpuHotPlug;
        return self();
    }

    public ServerBuilder ramHotPlug( Boolean ramHotPlug ) {
        this.ramHotPlug = ramHotPlug;
        return self();
    }

    public ServerBuilder nicHotPlug( Boolean nicHotPlug ) {
        this.nicHotPlug = nicHotPlug;
        return self();
    }

    public ServerBuilder nicHotUnPlug( Boolean nicHotUnPlug ) {
        this.nicHotUnPlug = nicHotUnPlug;
        return self();
    }

    public ServerBuilder discVirtioHotPlug( Boolean discVirtioHotPlug ) {
        this.discVirtioHotPlug = discVirtioHotPlug;
        return self();
    }

    public ServerBuilder setDiscVirtioHotUnPlug( Boolean discVirtioHotUnPlug ) {
        this.discVirtioHotUnPlug = discVirtioHotUnPlug;
        return self();
    }

    @Override
    public ServerBuilder self() {
        return this;
    }

    public Server build() {
        return new Server( serverId, serverName, cores, ram, internetAccess, ips, connectedStorages, romDrives,
                nics, provisioningState, virtualMachineState, creationTime, lastModificationTime, osType,
                availabilityZone, cpuHotPlug, ramHotPlug, nicHotPlug, nicHotUnPlug, discVirtioHotPlug, discVirtioHotUnPlug,
                dataCenterId, dataCenterVersion );
    }

}
