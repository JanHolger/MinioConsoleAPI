package eu.bebendorf.minioconsoleapi.request;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest {

    @SerializedName("old_secret_key")
    private String oldSecretKey;
    @SerializedName("new_secret_key")
    private String newSecretKey;

    public ChangePasswordRequest(String oldSecretKey, String newSecretKey) {
        this.oldSecretKey = oldSecretKey;
        this.newSecretKey = newSecretKey;
    }

}
