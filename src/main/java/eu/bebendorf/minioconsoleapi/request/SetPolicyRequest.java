package eu.bebendorf.minioconsoleapi.request;

public class SetPolicyRequest {

    private String entityType;
    private String entityName;

    public SetPolicyRequest(String entityType, String entityName) {
        this.entityType = entityType;
        this.entityName = entityName;
    }

}
