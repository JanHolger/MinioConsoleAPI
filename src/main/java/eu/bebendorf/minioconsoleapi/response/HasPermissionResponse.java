package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.Permission;

import java.util.HashMap;
import java.util.Map;

public class HasPermissionResponse {

    Perm[] permissions;

    public Map<Permission, Boolean> getPermissions() {
        Map<Permission, Boolean> perms = new HashMap<>();
        for(Perm p : permissions) {
            Permission permission = Permission.byId(p.id);
            if(permission != null)
                perms.put(permission, p.can);
        }
        return perms;
    }

    private static class Perm {
        String id;
        boolean can;
    }

}
