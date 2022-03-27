package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.University;

import java.util.ArrayList;
import java.util.List;

public class FacultyWithBiggestQuantityOfStudentsUniversityVisitor implements IFacultyWithBiggestQuantityOfStudentsUniversityVisitor{
    @Override
    public Faculty visit(University university) {
        List<Faculty> toRun = university.getFaculties();
        BiggestFacultyData bfd = new BiggestFacultyData(toRun.get(0));

        for (Faculty faculty: toRun) {
            int studentsInFaculty = faculty.accept(new FacultyWithBiggestQuantityOfStudentsFacultyVisitor());
            if (studentsInFaculty > bfd.getCount()) {
                bfd.setCount(studentsInFaculty);
                bfd.setFaculty(faculty);
            }
        }
        return bfd.getFaculty();
    }
}
