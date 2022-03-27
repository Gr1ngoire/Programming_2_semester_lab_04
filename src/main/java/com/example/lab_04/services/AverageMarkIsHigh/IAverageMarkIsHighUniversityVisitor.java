package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import java.util.List;

public interface IAverageMarkIsHighUniversityVisitor {
    List<Student> visit(University university);
}
