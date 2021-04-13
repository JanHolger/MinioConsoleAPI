package eu.bebendorf.minioconsoleapi;

public enum Permission {

    CREATE_BUCKET("createBucket", "s3:CreateBucket"),
    GET_REPLICATION_CONFIGURATION("GetReplicationConfiguration", "s3:GetReplicationConfiguration"),
    PUT_REPLICATION_CONFIGURATION("PutReplicationConfiguration", "s3:PutReplicationConfiguration");

    private final String id;
    private final String action;

    Permission(String id, String action) {
        this.id = id;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public static Permission byId(String id) {
        for(Permission p : values()) {
            if(p.getId().equals(id))
                return p;
        }
        return null;
    }

}
