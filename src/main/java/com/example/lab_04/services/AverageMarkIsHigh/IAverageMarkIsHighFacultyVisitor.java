package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import java.util.List;

public interface IAverageMarkIsHighFacultyVisitor {
    void visit(List<Student> list, Faculty faculty);
}
