package eu.bebendorf.minioconsoleapi.request;

public class CreateUserRequest {

    private String accessKey;
    private String secretKey;
    private String[] groups;

    public CreateUserRequest(String accessKey, String secretKey, String... groups) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.groups = groups;
    }

}
