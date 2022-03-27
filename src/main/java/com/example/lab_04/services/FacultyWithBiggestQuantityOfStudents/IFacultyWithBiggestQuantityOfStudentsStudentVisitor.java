package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Student;

public interface IFacultyWithBiggestQuantityOfStudentsStudentVisitor {
    int visit(Student student);
}
