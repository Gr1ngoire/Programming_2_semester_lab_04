package com.example.lab_04.services.AverageMarkIsHigh;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import java.util.ArrayList;
import java.util.List;

public class AverageMarkIsHighUniversityVisitor implements IAverageMarkIsHighUniversityVisitor{
    @Override
    public List<Student> visit(University university) {
        List<Student> toReturn = new ArrayList<>();
        for (Faculty faculty: university.getFaculties()) {
            faculty.accept(toReturn, new AverageMarkIsHighFacultyVisitor());
        }
        return toReturn;
    }
}
