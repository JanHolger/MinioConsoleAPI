package eu.bebendorf.minioconsoleapi;

import org.javawebstack.httpclient.HTTPRequest;

public class MinioConsoleAPIException extends RuntimeException {

    private final HTTPRequest request;

    public MinioConsoleAPIException(HTTPRequest request) {
        super("Error " + request.status() + " -> " + request.string());
        this.request = request;
    }

    public int getErrorCode() {
        return request.status();
    }

    public String getErrorMessage() {
        return request.string();
    }

}
