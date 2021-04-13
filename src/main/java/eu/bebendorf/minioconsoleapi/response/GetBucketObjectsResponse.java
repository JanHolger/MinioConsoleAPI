package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.model.BucketObject;

import java.util.Arrays;
import java.util.List;

public class GetBucketObjectsResponse {

    private BucketObject[] objects;

    public List<BucketObject> getObjects() {
        return Arrays.asList(objects);
    }

}
