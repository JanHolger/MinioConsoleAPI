package eu.bebendorf.minioconsoleapi.response;

import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetConfigResponse {

    private String name;
    @MapperOptions(name = "key_values")
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
