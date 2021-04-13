package eu.bebendorf.minioconsoleapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Bucket {

    @SerializedName("creation_date")
    private Date creationDate;
    private String name;
    private Long size;
    private AccessPolicy access;

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public AccessPolicy getAccess() {
        return access;
    }

    public enum AccessPolicy {
        PRIVATE
    }

}
