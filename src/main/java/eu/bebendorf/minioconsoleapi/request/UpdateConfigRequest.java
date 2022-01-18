package eu.bebendorf.minioconsoleapi.request;

import org.javawebstack.abstractdata.AbstractArray;
import org.javawebstack.abstractdata.AbstractObject;
import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

import java.util.Map;

public class UpdateConfigRequest {

    @MapperOptions(name = "key_values")
    private final AbstractArray keyValues = new AbstractArray();

    public UpdateConfigRequest(Map<String, String> values) {
        values.forEach((k, v) -> keyValues.add(new AbstractObject().set("key", k).set("v", v)));
    }

}
