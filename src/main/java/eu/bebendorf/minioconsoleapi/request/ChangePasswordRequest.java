package eu.bebendorf.minioconsoleapi.request;

import org.javawebstack.abstractdata.mapper.annotation.MapperOptions;

public class ChangePasswordRequest {

    @MapperOptions(name = "old_secret_key")
    private String oldSecretKey;
    @MapperOptions(name = "new_secret_key")
    private String newSecretKey;

    public ChangePasswordRequest(String oldSecretKey, String newSecretKey) {
        this.oldSecretKey = oldSecretKey;
        this.newSecretKey = newSecretKey;
    }

}
