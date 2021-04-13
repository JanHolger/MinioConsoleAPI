package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.model.BucketReplicationRule;

import java.util.Arrays;
import java.util.List;

public class GetBucketReplicationRulesResponse {

    private BucketReplicationRule[] rules;

    public List<BucketReplicationRule> getRules() {
        return Arrays.asList(rules);
    }

}
