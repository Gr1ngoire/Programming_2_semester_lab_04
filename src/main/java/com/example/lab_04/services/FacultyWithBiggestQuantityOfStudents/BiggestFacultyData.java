package com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents;

import com.example.lab_04.services.Entities.Faculty;

public class BiggestFacultyData {
    private int count;
    private Faculty faculty;

    public BiggestFacultyData(Faculty faculty) {
        count = 0;
        this.faculty = faculty;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
