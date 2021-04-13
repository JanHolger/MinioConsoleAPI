package eu.bebendorf.minioconsoleapi.response;

import java.util.Arrays;
import java.util.List;

public class GetGroupsResponse {

    private String[] groups;
    private int total;

    public List<String> getGroups() {
        return Arrays.asList(groups);
    }

    public int getTotal() {
        return total;
    }

}
