package com.example.eregistrardemo.service;

import com.example.eregistrardemo.model.Classroom;
import com.example.eregistrardemo.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student save(Student s);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    Student getStudentById(long id);
    void updateStudent(Classroom classroom, long studentId);
}
