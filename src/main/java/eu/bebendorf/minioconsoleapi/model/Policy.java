package eu.bebendorf.minioconsoleapi.model;

public class Policy {

    private String name;
    private String policy;

    public Policy() {

    }

    public Policy(String name, String policy) {
        this.name = name;
        this.policy = policy;
    }

    public String getName() {
        return name;
    }

    public String getPolicy() {
        return policy;
    }

    public Policy setName(String name) {
        this.name = name;
        return this;
    }

    public Policy setPolicy(String policy) {
        this.policy = policy;
        return this;
    }

}
