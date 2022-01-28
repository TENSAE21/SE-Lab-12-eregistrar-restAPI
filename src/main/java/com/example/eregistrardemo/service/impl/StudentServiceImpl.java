package com.example.eregistrardemo.service.impl;

import com.example.eregistrardemo.model.Classroom;
import com.example.eregistrardemo.model.Student;
import com.example.eregistrardemo.repository.StudentRepository;
import com.example.eregistrardemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Saves Student data
     * @param s Student data object to be saved
     * @return saved student data object
     */
    @Override
    public Student save(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getPassingStudentsOnly() {
        return studentRepository.findStudentsWithCgpaGreaterThan3(3.0f);
    }

    @Override
    public List<Student> getLatestStudents() {
        return studentRepository.findStudentsByStudentNumberGreaterThan(980002);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(Classroom classroom, long studentId) {
        studentRepository.update(classroom, studentId);
    }

    @Override
    public void deleteStudentById(Long studentId) { studentRepository.deleteById(studentId);}

    @Override
    public List<Student> searchStudents(String searchString) {

        if(containsDecimalPoint(searchString) && isGPA(searchString)) {
            return studentRepository.findAllByCgpaEquals(Float.parseFloat(searchString));

        } else if(isDate(searchString)) {
            return studentRepository.findAllByAdmissionDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentRepository.findAllByFirstNameContainingOrLastNameContainingOrderByLastName(searchString, searchString);
        }
    }

    private boolean isGPA(String searchString) {
        boolean isParseableAsGPA = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsGPA = true;
        } catch(Exception ex) {
            if(ex instanceof ParseException) {
                isParseableAsGPA = false;
            }
        }
        return isParseableAsGPA;
    }

    private boolean isDate(String searchString) {
        //admissionDate
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        //cgpa
        return searchString.contains(".");
    }


}
