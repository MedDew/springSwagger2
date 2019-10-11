package com.meddew.swagger2.controller;

import com.meddew.swagger2.entities.Student;
import com.meddew.swagger2.repositories.StudentRepostory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class StudentController {
    @Autowired
    private StudentRepostory studentRepostory;

    @GetMapping("/students")
    @ApiOperation(value = "Fetch all the students", notes = "Return the complete list of students",response = Student.class)
    public List<Student> getStudents(){
        List<Student> studentList = new ArrayList<>();
        studentRepostory.findAll().forEach( s -> {
            studentList.add(s);
        });

        return studentList;
    }

    @GetMapping("/students/{studentId}")
    @ApiOperation(value = "Fetch a student by its id", notes = "Provide an id to lookup specific student",response = Student.class)
    public Student getStudentById(@ApiParam(value = "Student Id value to retrieve", required=true) @PathVariable(name = "studentId") Long id){
        Optional<Student> student = studentRepostory.findById(id);
        if(student.isPresent()){
            return student.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The student id : "+id+" is not found");
        }
    }
}
