package com.students.studentManagement.exception;

import com.students.studentManagement.handler.APIHandler;
import com.students.studentManagement.handler.APIResponseHandler;
import com.students.studentManagement.response.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ShowMessage {
    @Autowired
    APIResponseHandler apiResponseHandler;
    @ResponseBody
    @ExceptionHandler(StudentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
   String studentNotFoundHandler(StudentException ex){
        return ex.getMessage();
    }
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<APIHandler> studentNotcreated(MethodArgumentNotValidException ex){
        List<Object> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getDefaultMessage());
        }

        return apiResponseHandler.sendResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
    }

}
