package com.example.eregistrardemo.repository;

import com.example.eregistrardemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * Search queries
     */

    List<Student> findAllByFirstNameContainingOrLastNameContainingOrderByLastName(String firstName, String lastname);
    List<Student> findAllByCgpaEquals(float cgpa);
    List<Student> findAllByAdmissionDateEquals(LocalDate admissionDate);

    @Query("select s from Student s where s.cgpa >= ?1 order by s.lastName")
    List<Student> findStudentsWithCgpaGreaterThan3(float cgpa);
    List<Student> findStudentsByStudentNumberGreaterThan(long studentNumber);

}
