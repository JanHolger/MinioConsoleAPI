package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.model.Bucket;

import java.util.Arrays;
import java.util.List;

public class GetBucketsResponse {

    private Bucket[] buckets;
    private int total;

    public List<Bucket> getBuckets() {
        return Arrays.asList(buckets);
    }

    public int getTotal() {
        return total;
    }

}
