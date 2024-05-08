package com.students.studentManagement.exception;

public class StudentException extends RuntimeException {
    private String message;
    public StudentException (String msg){
        super(msg);
        this.message=msg;
    }

}
