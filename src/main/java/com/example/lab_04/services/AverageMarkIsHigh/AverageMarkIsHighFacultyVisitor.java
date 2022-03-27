package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import java.util.List;

public class AverageMarkIsHighFacultyVisitor implements IAverageMarkIsHighFacultyVisitor{
    @Override
    public void visit(List<Student> list, Faculty faculty) {
        for (Student student: faculty.getStudents()) {
            student.accept(list, new AverageMarkIsHighStudentVisitor());
        }
    }
}
