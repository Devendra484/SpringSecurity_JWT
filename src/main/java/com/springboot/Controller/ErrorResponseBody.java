package com.springboot.Controller;

import org.springframework.http.HttpStatusCode;

public class ErrorResponseBody {

    private int status;
    private HttpStatusCode error;
    private String message;
    private String path;
    public ErrorResponseBody( int status, HttpStatusCode httpStatusCode, String message, String path) {
        super();
        this.status = status;
        this.error = httpStatusCode;
        this.message = message;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public HttpStatusCode getError() {
        return error;
    }
    public void setError(HttpStatusCode error) {
        this.error = error;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }



}
