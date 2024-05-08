package com.students.studentManagement.controller;

import com.students.studentManagement.handler.APIHandler;
import com.students.studentManagement.handler.APIResponseHandler;
import com.students.studentManagement.model.Student;
import com.students.studentManagement.response.StudentDTO;
import com.students.studentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
@Autowired
    StudentService studentService;
@Autowired
    APIResponseHandler apiResponseHandler;
@GetMapping("/students")
    private List<StudentDTO> getAllStudents(){

    return studentService.getAllStudents();
}

@GetMapping("/student/{studentID}")
    private StudentDTO getStudentById( @PathVariable("studentID") int id){

    return studentService.getStudentById(id);
}

    @PostMapping("/createStudent")
    private ResponseEntity<APIHandler> saveStudent(@RequestBody @Valid StudentDTO std, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Object> errors = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }

            return apiResponseHandler.sendResponse(HttpStatus.BAD_REQUEST, "Validation failed", errors);
        }

        studentService.saveStudent(std);
        return apiResponseHandler.sendResponse(HttpStatus.CREATED, "Student created successfully", null);
    }



    @DeleteMapping("/deleteStudent/{studentID}")
    private ResponseEntity<APIHandler> deleteBook(@PathVariable("studentID") int id)throws Exception
    {
        try{
            studentService.deleteStudent(id);
            return apiResponseHandler.sendResponse(HttpStatus.OK,"Student updated successfully",null);
        } catch (Exception e){
            return apiResponseHandler.sendResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
    }

    @PutMapping("/updateStudents")
    private ResponseEntity<APIHandler> updateStudents(@RequestBody @Valid Student student) throws Exception
    {
        try{
       studentService.updateStudent(student);
       return apiResponseHandler.sendResponse(HttpStatus.OK,"Student updated successfully",null);
    } catch (Exception e){
            return apiResponseHandler.sendResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        }
}}
