package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Student;

import java.util.List;

public class AverageMarkIsHighStudentVisitor implements IAverageMarkIsHighStudentVisitor{

    @Override
    public void visit(List<Student> list, Student student) {
        int highMarkIntervalStart = 95;
        int highMarkIntervalEnd = 100;
        if (student.getAverageMark() >= highMarkIntervalStart && student.getAverageMark() <= highMarkIntervalEnd) {
            list.add(student);
        }
    }
}
