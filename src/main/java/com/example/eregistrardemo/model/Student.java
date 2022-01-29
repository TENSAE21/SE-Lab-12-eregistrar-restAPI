package com.example.eregistrardemo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name="student_number", unique = true, nullable = false)
    private Long studentNumber;

    private String firstName;
//    private String middleName;
    private String lastName;
    private Float cgpa;

    private boolean isInternational;

    @Column(name = "admission_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate admissionDate;


    public Student() {
    }

    public Student(Long studentNumber, String firstName, String lastName, Float cgpa, LocalDate admissionDate) {
        this.studentNumber = studentNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;
    }


    public Student(Long studentId, Long studentNumber, String firstName, String lastName, Float cgpa, LocalDate admissionDate) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.cgpa = cgpa;
        this.admissionDate = admissionDate;

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", admissionDate=" + admissionDate +
                '}';
    }
}
