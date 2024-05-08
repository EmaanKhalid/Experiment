package com.students.studentManagement.model;

import jakarta.persistence.*;
import lombok.Data;

import java.nio.channels.SelectionKey;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    private  int ID;
    @Column(name = "Student_Name")
    private String name;
    @Column(name = "Student_Age")
    private int age;
    @Column(name = "Student_Gender")
   private String gender;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;

}
