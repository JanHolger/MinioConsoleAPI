package eu.bebendorf.minioconsoleapi;

import eu.bebendorf.minioconsoleapi.model.*;
import eu.bebendorf.minioconsoleapi.request.*;
import eu.bebendorf.minioconsoleapi.response.*;
import org.javawebstack.abstractdata.AbstractObject;
import org.javawebstack.abstractdata.NamingPolicy;
import org.javawebstack.httpclient.HTTPClient;
import org.javawebstack.httpclient.HTTPRequest;

import java.net.HttpCookie;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinioConsoleAPI extends HTTPClient {

    public MinioConsoleAPI(String url) {
        setBaseUrl(url + "/api/v1");
        header("Content-Type", "application/json");
        header("Accept", "application/json");
        getAbstractMapper().setNamingPolicy(NamingPolicy.NONE);
    }

    public String getToken() {
        HttpCookie cookie = getDefaultCookies().stream().filter(c -> c.getName().equals("token")).findFirst().orElse(null);
        if(cookie == null)
            return null;
        return cookie.getValue();
    }

    public MinioConsoleAPI setToken(String token) {
        cookie(new HttpCookie("token", token));
        return this;
    }

    public MinioConsoleAPI login(String accessKey, String secretKey) {
        login(new LoginRequest(accessKey, secretKey));
        return this;
    }

    public LoginResponse login(LoginRequest request) {
        LoginResponse response = errorCheck(post("/login", request)).object(LoginResponse.class);
        setToken(response.getSessionId());
        return response;
    }

    public InfoResponse getInfo() {
        return errorCheck(get("/admin/info")).object(InfoResponse.class);
    }

    public Map<Permission, Boolean> hasPermission(Permission... permissions) {
        return errorCheck(post("/has-permission", new HasPermissionRequest(permissions))).object(HasPermissionResponse.class).getPermissions();
    }

    public Map<Permission, Boolean> hasPermission(String bucket, Permission... permissions) {
        return errorCheck(post("/has-permission", new HasPermissionRequest(bucket, permissions))).object(HasPermissionResponse.class).getPermissions();
    }

    public List<BucketObject> getBucketObjects(String bucket) {
        return errorCheck(get("/buckets/" + bucket + "/objects")).object(GetBucketObjectsResponse.class).getObjects();
    }

    public void deleteBucketObject(String bucket, String path, boolean recursive) {
        errorCheck(delete("/buckets/" + bucket + "/objects").query("path", path).query("recursive", String.valueOf(recursive)));
    }

    public List<BucketObject> getBucketObjects(String bucket, String prefix) {
        return errorCheck(get("/buckets/" + bucket + "/objects").query("prefix", prefix)).object(GetBucketObjectsResponse.class).getObjects();
    }

    public List<Bucket> getBuckets() {
        return errorCheck(get("/buckets")).object(GetBucketsResponse.class).getBuckets();
    }

    public Bucket getBucket(String name) {
        return errorCheck(get("/buckets/" + name)).object(Bucket.class);
    }

    public List<BucketReplicationRule> getBucketReplicationRules(String name) {
        return errorCheck(get("/buckets/" + name + "/replication")).object(GetBucketReplicationRulesResponse.class).getRules();
    }

    public void createBucket(String name) {
        createBucket(new CreateBucketRequest(name));
    }

    public void createBucket(CreateBucketRequest request) {
        errorCheck(post("/buckets", request));
    }

    public void deleteBucket(String name) {
        errorCheck(delete("/buckets/" + name));
    }

    public void updateBucketQuota(String name, BucketQuota quota) {
        errorCheck(put("/buckets/" + name + "/quota", quota));
    }

    public User createUser(String accessKey, String secretKey, String... groups) {
        return errorCheck(post("/users", new CreateUserRequest(accessKey, secretKey, groups))).object(User.class);
    }

    public List<User> getUsers() {
        return errorCheck(get("/users")).object(GetUsersResponse.class).getUsers();
    }

    public void deleteUser(String name) {
        errorCheck(delete("/users/" + name));
    }

    public List<String> getGroups() {
        return errorCheck(get("/groups")).object(GetGroupsResponse.class).getGroups();
    }

    public Group getGroup(String name) {
        return errorCheck(get("/groups/" + name)).object(Group.class);
    }

    public void deleteGroup(String name) {
        errorCheck(delete("/groups/" + name));
    }

    public List<Policy> getPolicies() {
        return errorCheck(get("/policies")).object(GetPoliciesResponse.class).getPolicies();
    }

    public Policy createPolicy(Policy policy) {
        return errorCheck(post("/policies", policy)).object(Policy.class);
    }

    public Policy updatePolicy(Policy policy) {
        return createPolicy(policy);
    }

    public void deletePolicy(String policy) {
        errorCheck(delete("policy").query("name", policy));
    }

    public void setUserPolicy(String user, String policy) {
        setPolicy("user", user, policy);
    }

    public void setGroupPolicy(String group, String policy) {
        setPolicy("group", group, policy);
    }

    public void setPolicy(String entityType, String entityName, String policy) {
        errorCheck(put("/set-policy/" + policy, new SetPolicyRequest(entityType, entityName)));
    }

    public List<String> getServiceAccounts() {
        return Arrays.asList(errorCheck(get("/service-accounts")).object(String[].class));
    }

    public CreateServiceAccountResponse createServiceAccount() {
        return createServiceAccount("");
    }

    public CreateServiceAccountResponse createServiceAccount(String policy) {
        return errorCheck(post("/service-accounts", new CreateServiceAccountRequest(policy))).object(CreateServiceAccountResponse.class);
    }

    public void deleteServiceAccount(String name) {
        errorCheck(delete("/service-accounts/" + name));
    }

    public Map<String, String> getConfig(String name) {
        return errorCheck(get("/configs/" + name)).object(GetConfigResponse.class).getValues();
    }

    public boolean updateConfig(String name, Map<String, String> values) {
        return errorCheck(put("/configs/" + name, new UpdateConfigRequest(values))).object(UpdateConfigResponse.class).requiresRestart();
    }

    public LoginResponse changePassword(String oldSecretKey, String newSecretKey) {
        LoginResponse response = errorCheck(post("/account/change-password", new ChangePasswordRequest(oldSecretKey, newSecretKey))).object(LoginResponse.class);
        setToken(response.getSessionId());
        return response;
    }

    public void restart() {
        errorCheck(post("/service/restart", new AbstractObject()));
    }

    public void stop() {
        errorCheck(post("/service/stop", new AbstractObject()));
    }

    private HTTPRequest errorCheck(HTTPRequest request) {
        if(request.status() < 200 || request.status() >= 300)
            throw new MinioConsoleAPIException(request);
        return request;
    }

}
