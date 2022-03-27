package com.example.lab_04.services.AllStudentsInUniversityVisitor;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import java.util.List;

public interface IStudentsInUniversityVisitorFacultyVisitor {
    void visit(List<Student> list, Faculty faculty);
}
