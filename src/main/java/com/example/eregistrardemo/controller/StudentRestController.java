package com.example.eregistrardemo.controller;

import com.example.eregistrardemo.model.Student;
import com.example.eregistrardemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:81"}, allowedHeaders = "*")
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/eregistrar/api/student", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> showStudentList() {
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/register")
    public Student addNewStudent(@Valid @RequestBody Student student) {
        // accept student object - the student object coming in
        // validate it - [ BindingResult ] a Spring's object that holds the result of the validation and binding and contains errors that may have occurred.
        // add it to DB/service - use service.add(object) if no error from above
        // if there is an error send back error (you talk to the front end using a Model, through it's attributes

        //!!make sure everything has the same name and Id in the forms and links are case-sensitive
        return studentService.save(student);
    }

    @GetMapping(value="/get/{studentId}")
    public Student getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping(value ="/delete/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PostMapping(value = "/update/{studentId}")
    public Student updateStudent(@Valid @RequestBody Student student, @PathVariable Long studentId) {
        return studentService.updateById(student, studentId);
    }
}