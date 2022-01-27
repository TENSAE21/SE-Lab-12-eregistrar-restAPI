package com.example.eregistrardemo.controller;

import com.example.eregistrardemo.model.Student;
import com.example.eregistrardemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

       @Autowired
       private StudentService studentService;

       @GetMapping(value={"/student/list", "/eregistrar/student/list"})
       public ModelAndView showStudentList(){
           //TODO: get list of registered students from service class
           ModelAndView modelAndView = new ModelAndView();
           List<Student> studentList = studentService.getAllStudents();
           modelAndView.addObject("students", studentList);
           modelAndView.addObject("studentCount", studentList.size());
           modelAndView.addObject("searchString", "");
           modelAndView.setViewName("student/list");
           return modelAndView;
       }

       @GetMapping(value={"/student/new", "/eregistrar/student/new"})
       public String showNewStudentForm (Model model){
           model.addAttribute("student", new Student());
           return "student/new";
       }




}
