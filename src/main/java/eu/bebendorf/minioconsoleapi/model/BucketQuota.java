package eu.bebendorf.minioconsoleapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Locale;

public class BucketQuota {

    private boolean enabled;
    private long amount;
    @SerializedName("quota_type")
    private String quotaType;

    public BucketQuota setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public BucketQuota setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public BucketQuota setType(BucketQuota.Type type) {
        this.quotaType = type.name().toLowerCase(Locale.ROOT);
        return this;
    }

    public enum Type {
        HARD,
        FIFO
    }

}
