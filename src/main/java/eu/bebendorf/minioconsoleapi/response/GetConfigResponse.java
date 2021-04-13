package eu.bebendorf.minioconsoleapi.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetConfigResponse {

    private String name;
    @SerializedName("key_values")
    private KeyValue[] keyValues;

    public String getName() {
        return name;
    }

    public Map<String, String> getValues() {
        return Stream.of(keyValues).collect(Collectors.toMap(kv -> kv.key, kv -> kv.value));
    }

    private static class KeyValue {
        String key;
        String value;
    }

}
