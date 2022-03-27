package com.example.lab_04.services.AllStudentsInUniversityVisitor;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import java.util.ArrayList;
import java.util.List;

public class StudentsInUniversityUniversityVisitor implements IStudentsInUniversityUniversityVisitor {

    @Override
    public List<Student> visit(University university) {
        List<Student> toReturn = new ArrayList<>();

        IStudentsInUniversityVisitorFacultyVisitor siufv = new StudentsInUniversityVisitorFacultyVisitor();
        for (Faculty faculty: university.getFaculties()) {
            faculty.accept(toReturn, siufv);
        }
        return toReturn;
    }
}
