package com.example.lab_04.services.AllStudentsInUniversityVisitor;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsInUniversityVisitorFacultyVisitor implements IStudentsInUniversityVisitorFacultyVisitor {
    @Override
    public void visit(List<Student> list,  Faculty faculty) {
        IStudentsInUniversityVisitorStudentVisitor siusv =  new StudentsInUniversityVisitorStudentVisitor();

        List<Student> toReturn = new ArrayList<>();
        for (Student student: faculty.getStudents()) {
            student.accept(list, siusv);
        }
    }
}
