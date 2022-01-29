package com.example.eregistrardemo.service;

import com.example.eregistrardemo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    Student updateById(Student student, long id);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    Student getStudentById(long id);
    void deleteStudentById(Long studentId);
    List<Student> searchStudents(String searchString);

}
