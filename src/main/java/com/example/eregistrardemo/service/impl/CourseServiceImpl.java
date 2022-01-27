package com.example.eregistrardemo.service.impl;

import com.example.eregistrardemo.model.Course;
import com.example.eregistrardemo.repository.CourseRepository;
import com.example.eregistrardemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
