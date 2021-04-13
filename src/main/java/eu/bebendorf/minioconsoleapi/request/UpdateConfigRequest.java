package eu.bebendorf.minioconsoleapi.request;

import com.google.gson.annotations.SerializedName;
import org.javawebstack.abstractdata.AbstractArray;
import org.javawebstack.abstractdata.AbstractObject;

import java.util.Map;

public class UpdateConfigRequest {

    @SerializedName("key_values")
    private final AbstractArray keyValues = new AbstractArray();

    public UpdateConfigRequest(Map<String, String> values) {
        values.forEach((k, v) -> keyValues.add(new AbstractObject().set("key", k).set("v", v)));
    }

}
