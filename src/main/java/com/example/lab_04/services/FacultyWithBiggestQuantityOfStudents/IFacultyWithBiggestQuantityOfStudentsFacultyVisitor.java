package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Faculty;

public interface IFacultyWithBiggestQuantityOfStudentsFacultyVisitor {
    int visit(Faculty faculty);
}
