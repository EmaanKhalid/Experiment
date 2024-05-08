package com.students.studentManagement.handler;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class APIHandler {
    private HttpStatus status;
    private String message;
    private List<Object> content;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getContent() {
        return content;
    }

    public void setContent(List<Object> content) {
        this.content = content;
    }
}
