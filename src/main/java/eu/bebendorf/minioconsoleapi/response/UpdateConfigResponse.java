package eu.bebendorf.minioconsoleapi.response;

public class UpdateConfigResponse {

    private boolean restart;

    public boolean requiresRestart() {
        return restart;
    }

}
