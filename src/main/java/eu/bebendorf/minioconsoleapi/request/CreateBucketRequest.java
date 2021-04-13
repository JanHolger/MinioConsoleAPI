package eu.bebendorf.minioconsoleapi.request;

import eu.bebendorf.minioconsoleapi.model.BucketQuota;

import java.util.Locale;

public class CreateBucketRequest {

    private String name;
    private boolean locking = false;
    private boolean versioning = false;
    private BucketQuota quota;
    private Retention retention;

    public CreateBucketRequest(String name) {
        this.name = name;
    }

    public CreateBucketRequest setLocking(boolean locking) {
        this.locking = locking;
        return this;
    }

    public CreateBucketRequest setVersioning(boolean versioning) {
        this.versioning = versioning;
        return this;
    }

    public CreateBucketRequest setQuota(BucketQuota quota) {
        this.quota = quota;
        return this;
    }

    public CreateBucketRequest setRetention(Retention retention) {
        this.retention = retention;
        return this;
    }

    public static class Retention {

        private String mode;
        private String unit;
        private int validity;

        public Retention setMode(Retention.Mode mode) {
            this.mode = mode.name().toLowerCase(Locale.ROOT);
            return this;
        }

        public Retention setUnit(Retention.Unit unit) {
            this.unit = unit.name().toLowerCase(Locale.ROOT);
            return this;
        }

        public Retention setValidity(int validity) {
            this.validity = validity;
            return this;
        }

        public enum Mode {
            COMPLIANCE,
            GOVERNANCE
        }

        public enum Unit {
            DAYS,
            YEARS
        }

    }

}
