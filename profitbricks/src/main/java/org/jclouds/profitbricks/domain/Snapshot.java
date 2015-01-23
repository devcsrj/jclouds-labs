package org.jclouds.profitbricks.domain;

import com.google.auto.value.AutoValue;
import org.jclouds.javax.annotation.Nullable;

import java.util.Date;
import java.util.List;

@AutoValue
public abstract class Snapshot {
    public abstract String id();

    @Nullable
    public abstract String name();

    public abstract float size();

    public abstract boolean bootable();

    public abstract String description();

    public abstract OsType osType();

    public abstract boolean cpuHotPlug();

    public abstract boolean cpuHotUnPlug();

    public abstract boolean discVirtioHotPlug();

    public abstract boolean discVirtioHotUnPlug();

    public abstract boolean ramHotPlug();

    public abstract boolean ramHotUnPlug();

    public abstract boolean nicHotPlug();

    public abstract boolean nicHotUnPlug();

    @Nullable
    public abstract Date creationTime();

    @Nullable
    public abstract Date lastModificationTime();

    public abstract ProvisioningState state();

    public abstract Location location();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String name;
        private float size;
        private Date creationTime;
        private Date lastModificationTime;
        private ProvisioningState state;
        private boolean bootable;
        private String description;
        private OsType osType;
        private boolean cpuHotPlug;
        private boolean cpuHotUnPlug;
        private boolean discVirtioHotPlug;
        private boolean discVirtioHotUnPlug;
        private boolean ramHotPlug;
        private boolean ramHotUnPlug;
        private boolean nicHotPlug;
        private boolean nicHotUnPlug;
        private Location location;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder size(float size) {
            this.size = size;
            return this;
        }

        public Builder creationTime(Date creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        public Builder lastModificationTime(Date lastModificationTime) {
            this.lastModificationTime = lastModificationTime;
            return this;
        }

        public Builder state(ProvisioningState state) {
            this.state = state;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder bootable(Boolean bootable) {
            this.bootable = bootable;
            return this;
        }

        public Builder osType(OsType osType) {
            this.osType = osType;
            return this;
        }

        public Builder cpuHotPlug(boolean cpuHotPlug) {
            this.cpuHotPlug = cpuHotPlug;
            return this;
        }

        public Builder cpuHotUnPlug(boolean cpuHotUnPlug) {
            this.cpuHotUnPlug = cpuHotUnPlug;
            return this;
        }

        public Builder discVirtioHotPlug(boolean discVirtioHotPlug) {
            this.discVirtioHotPlug = discVirtioHotPlug;
            return this;
        }

        public Builder discVirtioHotUnPlug(boolean discVirtioHotUnPlug) {
            this.discVirtioHotUnPlug = discVirtioHotUnPlug;
            return this;
        }

        public Builder ramHotPlug(boolean ramHotPlug) {
            this.ramHotPlug = ramHotPlug;
            return this;
        }

        public Builder ramHotUnPlug(boolean ramHotUnPlug) {
            this.ramHotUnPlug = ramHotUnPlug;
            return this;
        }

        public Builder nicHotPlug(boolean nicHotPlug) {
            this.nicHotPlug = nicHotPlug;
            return this;
        }

        public Builder nicHotUnPlug(boolean nicHotUnPlug) {
            this.nicHotUnPlug = nicHotUnPlug;
            return this;
        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }
        public static Snapshot create(String id, String name, float size, boolean bootable, String description, OsType osType, boolean cpuHotPlug, boolean cpuHotUnPlug,
                                      boolean discVirtioHotPlug, boolean discVirtioHotUnPlug, boolean ramHotPlug, boolean ramHotUnPlug,
                                      boolean nicHotPlug, boolean nicHotUnPlug, Date creationTime, Date lastModificationTime, ProvisioningState state, Location location) {
            return new AutoValue_Snapshot(id, name, size, bootable, description, osType, cpuHotPlug, cpuHotUnPlug,
                    discVirtioHotPlug, discVirtioHotUnPlug, ramHotPlug, ramHotUnPlug,
                    nicHotPlug, nicHotUnPlug, creationTime, lastModificationTime, state, location);
        }

        private Builder fromSnapshot(Snapshot in) {
            return this.id(in.id()).name(in.name()).size(in.size()).creationTime(in.creationTime())
                    .lastModificationTime(in.lastModificationTime()).state(in.state()).bootable(in.bootable()).description(in.description())
                    .cpuHotPlug(in.cpuHotPlug()).cpuHotUnPlug(in.cpuHotUnPlug()).discVirtioHotPlug(in.discVirtioHotPlug())
                    .discVirtioHotUnPlug(in.discVirtioHotUnPlug()).ramHotPlug(in.ramHotPlug()).ramHotUnPlug(in.ramHotUnPlug())
                    .nicHotPlug(in.nicHotPlug()).nicHotUnPlug(in.nicHotUnPlug());
        }
    }

    public static final class Request {

        public static CreatePayload.Builder creatingBuilder() {
            return new CreatePayload.Builder();
        }

        public static UpdatePayload.Builder updatingBuilder() {
            return new UpdatePayload.Builder();
        }

        @AutoValue
        public abstract static class CreatePayload {
            public abstract String storageId();
            public abstract String description();
            public abstract String snapshotName();

            public static CreatePayload create(String storageId, String description, String snapshotName)
            {
                return new AutoValue_Snapshot_Request_CreatePayload(storageId,description,snapshotName);
            }

            public static class Builder {

            }
        }

        public abstract static class UpdatePayload {
            public static class Builder {

            }
        }
    }
}
