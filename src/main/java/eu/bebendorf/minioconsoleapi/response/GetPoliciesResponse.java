package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.model.Policy;

import java.util.Arrays;
import java.util.List;

public class GetPoliciesResponse {

    private Policy[] policies;
    private int total;

    public List<Policy> getPolicies() {
        return Arrays.asList(policies);
    }

    public int getTotal() {
        return total;
    }
}
