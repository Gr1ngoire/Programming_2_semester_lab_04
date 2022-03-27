package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

public class FacultyWithBiggestQuantityOfStudentsFacultyVisitor implements IFacultyWithBiggestQuantityOfStudentsFacultyVisitor{

    @Override
    public int visit(Faculty faculty) {
        int counter = 0;
        for (Student student: faculty.getStudents()) {
            counter += student.accept(new FacultyWithBiggestQuantityOfStudentsStudentVisitor());
        }
        return counter;
    }
}
