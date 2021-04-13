package eu.bebendorf.minioconsoleapi.request;

import com.google.gson.annotations.SerializedName;

import java.util.Locale;

public class CreateBucketRequest {

    private String name;
    private boolean locking = false;
    private boolean versioning = false;
    private Quota quota;
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

    public CreateBucketRequest setQuota(Quota quota) {
        this.quota = quota;
        return this;
    }

    public CreateBucketRequest setRetention(Retention retention) {
        this.retention = retention;
        return this;
    }

    public static class Quota {

        private boolean enabled;
        private long amount;
        @SerializedName("quota_type")
        private String quotaType;

        public Quota setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Quota setAmount(long amount) {
            this.amount = amount;
            return this;
        }

        public Quota setType(Quota.Type type) {
            this.quotaType = type.name().toLowerCase(Locale.ROOT);
            return this;
        }

        public enum Type {
            HARD,
            FIFO
        }

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
