package com.meddew.swagger2.controller;

import com.meddew.swagger2.entities.Student;
import com.meddew.swagger2.repositories.StudentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/school")
public class StudentController {
    @Autowired
    private StudentRepostory studentRepostory;

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        studentRepostory.findAll().forEach( s -> {
            studentList.add(s);
        });

        return studentList;
    }
}
