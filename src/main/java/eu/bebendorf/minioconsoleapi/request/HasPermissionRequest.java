package eu.bebendorf.minioconsoleapi.request;

import eu.bebendorf.minioconsoleapi.Permission;
import org.javawebstack.abstractdata.AbstractArray;
import org.javawebstack.abstractdata.AbstractObject;

public class HasPermissionRequest {

    private final AbstractArray actions = new AbstractArray();

    public HasPermissionRequest(Permission... actions) {
        for(Permission p : actions)
            this.actions.add(new AbstractObject().set("id", p.getId()).set("action", p.getAction()));
    }

    public HasPermissionRequest(String bucket, Permission... actions) {
        for(Permission p : actions)
            this.actions.add(new AbstractObject().set("id", p.getId()).set("action", p.getAction()).set("bucket_name", bucket));
    }

}
