package eu.bebendorf.minioconsoleapi.model;

import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

import java.util.Date;

public class Bucket {

    @MapperOptions(name = "creation_date")
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
