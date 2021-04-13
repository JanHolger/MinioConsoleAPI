package eu.bebendorf.minioconsoleapi.request;

public class LoginRequest {

    private final String accessKey;
    private final String secretKey;

    public LoginRequest(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

}
