package com.example.lab_04.services.AllStudentsInUniversityVisitor;

import com.example.lab_04.services.Entities.Student;

import java.util.List;

public class StudentsInUniversityVisitorStudentVisitor implements IStudentsInUniversityVisitorStudentVisitor {
    @Override
    public void visit(List<Student> list, Student student) {
        list.add(student);
    }
}
