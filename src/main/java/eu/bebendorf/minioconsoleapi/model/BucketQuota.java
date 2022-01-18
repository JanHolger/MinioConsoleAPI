package eu.bebendorf.minioconsoleapi.model;

import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

import java.util.Locale;

public class BucketQuota {

    private boolean enabled;
    private long amount;
    @MapperOptions(name = "quota_type")
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
