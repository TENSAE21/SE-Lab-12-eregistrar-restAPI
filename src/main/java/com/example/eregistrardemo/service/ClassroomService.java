package com.example.eregistrardemo.service;

import com.example.eregistrardemo.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
