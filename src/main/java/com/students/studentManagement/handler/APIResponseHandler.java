package com.students.studentManagement.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class APIResponseHandler {
    public ResponseEntity<APIHandler> sendResponse(
            HttpStatus status,
            String message,
            List<Object> content) {
        APIHandler apiHandler = new APIHandler();
        apiHandler.setMessage(message);
        apiHandler.setStatus(status);
        apiHandler.setContent(content);
        return new ResponseEntity<>(apiHandler, apiHandler.getStatus());
    }
    private List<Object> convertInputToList(Object input) {
        if(input instanceof List) {
            List<Object> content = (List) input;
            return content;
        } else {
            List<Object> content = new ArrayList<>();
            content.add(input);
            return content;
        }
    }
}
