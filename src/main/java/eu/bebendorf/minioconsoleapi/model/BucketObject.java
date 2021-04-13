package eu.bebendorf.minioconsoleapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BucketObject {

    private String name;
    @SerializedName("last_modified")
    private Date lastModified;
    private Long size;

    public String getName() {
        return name;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public Long getSize() {
        return size;
    }

}
