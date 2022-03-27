package com.example.lab_04.services.AllStudentsInUniversityVisitor;

import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import java.util.List;

public interface IStudentsInUniversityUniversityVisitor {
    List<Student> visit(University university);
}
