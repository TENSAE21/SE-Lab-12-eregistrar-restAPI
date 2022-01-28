package com.example.eregistrardemo.controller;

import com.example.eregistrardemo.model.Student;
import com.example.eregistrardemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/student/list", "/eregistrar/student/list"})
    public ModelAndView showStudentList() {
        //TODO: get list of registered students from service class
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.getAllStudents();
        modelAndView.addObject("students", studentList);
        modelAndView.addObject("studentCount", studentList.size());
        modelAndView.addObject("searchString", "");
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/student/new", "/eregistrar/student/new"})
    public String showNewStudentForm(Model model) {
        //Notice how we don't even return model
        //not to mention the fact that it is a parameter we EXPECT FROM SPRING
        model.addAttribute("student", new Student());
        return "student/new";
    }


    @PostMapping(value = {"/student/new", "/eregistrar/student/new"})
    public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        // accept student object - the student object coming in
        // validate it - [ BindingResult ] a Spring's object that holds the result of the validation and binding and contains errors that may have occurred.
        // add it to DB/service - use service.add(object) if no error from above
        // if there is an error send back error (you talk to the front end using a Model, through it's attributes

        //!!make sure everything has the same name and Id in the forms and links are case-sensitive
        if (bindingResult.hasErrors()) {
            model.addAttribute("Error", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.save(student);
        System.out.println(student);

        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}", "/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/search", "/student/search"})
    public ModelAndView searchBooks(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.searchStudents(searchString);
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("studentCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }


    @GetMapping(value = {"/student/edit/{studentId}", "/eregistrar/student/edit/{studentId}"})
    public String showEditStudentForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        } else {
            // TODO
        }
        return "student/list";
    }

    @PostMapping(value = {"/student/edit", "/eregistrar/student/edit"})
    public String editBook(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        studentService.save(student);
        return "redirect:/eregistrar/student/list";

    }
}