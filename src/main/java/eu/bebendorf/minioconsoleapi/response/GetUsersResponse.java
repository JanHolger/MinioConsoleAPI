package eu.bebendorf.minioconsoleapi.response;

import eu.bebendorf.minioconsoleapi.model.User;

import java.util.Arrays;
import java.util.List;

public class GetUsersResponse {

    private User[] users;

    public List<User> getUsers() {
        return Arrays.asList(users);
    }

}
