package eu.bebendorf.minioconsoleapi.model;

import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

import java.util.Date;

public class BucketObject {

    private String name;
    @MapperOptions(name = "last_modified")
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
