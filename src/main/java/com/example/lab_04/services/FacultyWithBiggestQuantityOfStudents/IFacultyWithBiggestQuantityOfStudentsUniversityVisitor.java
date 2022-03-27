package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.University;

public interface IFacultyWithBiggestQuantityOfStudentsUniversityVisitor {
    Faculty visit(University university);
}
