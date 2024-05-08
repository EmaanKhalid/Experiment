package com.students.studentManagement.service;

import com.students.studentManagement.exception.StudentException;

import com.students.studentManagement.model.Student;
import com.students.studentManagement.repository.StudentRepository;
import com.students.studentManagement.response.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IsStudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    // get all student list
    public List<StudentDTO> getAllStudents(){
     List<Student> students = studentRepository.findAll();
     List<StudentDTO> sDTO = new ArrayList<>();
     for(Student student : students){
         StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);
         sDTO.add(studentDTO);
     }
     return  sDTO;

    }

    // get specific student
    public StudentDTO getStudentById(int id){
       Student std= studentRepository.findById(id).orElseThrow(()->new StudentException("No such ID is found"));
        StudentDTO sDTO = new StudentDTO();
        sDTO = modelMapper.map(std, StudentDTO.class);
     return sDTO;
    }

    // save student
    public Student saveStudent(StudentDTO std){
        Student student = modelMapper.map(std, Student.class);
        // Encode password before saving
        student.setPassword(passwordEncoder.encode(std.getPassword()));
        return studentRepository.save(student);

    }

    // delete student by id
    public void deleteStudent(int id)throws Exception{
        if(!(studentRepository.existsById(id) || id==0)){
            throw new Exception("ID not found or ID not exist");
        }
        studentRepository.deleteById(id);
    }

    //update student
    public Student updateStudent(Student std) throws Exception{

        if(!(studentRepository.existsById(std.getID())) || std.getID()==0){
            throw new Exception("ID not found or ID not exist");
        }

        return studentRepository.save(std);
    }
}
