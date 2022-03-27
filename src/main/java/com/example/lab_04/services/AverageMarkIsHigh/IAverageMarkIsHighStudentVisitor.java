package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Student;

import java.util.List;

public interface IAverageMarkIsHighStudentVisitor {
    void visit(List<Student> list, Student student);
}
