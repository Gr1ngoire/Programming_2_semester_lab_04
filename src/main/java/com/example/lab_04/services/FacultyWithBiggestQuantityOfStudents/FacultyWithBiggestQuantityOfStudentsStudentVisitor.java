package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Student;

public class FacultyWithBiggestQuantityOfStudentsStudentVisitor implements IFacultyWithBiggestQuantityOfStudentsStudentVisitor{
    @Override
    public int visit(Student student) {
        return 1;
    }
}
