package com.dawnei.buildlab;

import org.springframework.stereotype.Service;

@Service // Service class that contains business logic and is used by the controller class
public class StudentService {

    public Student prepareStudent(Student student) {
        student.setName(student.getName().trim()); // trim whitespace from name
        return student;
    }
}