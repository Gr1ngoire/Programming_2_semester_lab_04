package com.example.lab_04.services.Entities;

import com.example.lab_04.services.AllStudentsInUniversityVisitor.IStudentsInUniversityUniversityVisitor;
import com.example.lab_04.services.AverageMarkIsHigh.IAverageMarkIsHighUniversityVisitor;
import com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents.IFacultyWithBiggestQuantityOfStudentsUniversityVisitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University implements Serializable {
    private String name;
    private List<Faculty> faculties;

    public University(UniversityBuilder universityBuilder) {
        this.name = universityBuilder.name;
        this.faculties = universityBuilder.faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty newFaculty) {
        faculties.add(newFaculty);
    }

    public void removeFaculty(Faculty facultyToRemove) {
        faculties.remove(facultyToRemove);
    }

    public List<Student> accept(IStudentsInUniversityUniversityVisitor siuuvv) {
        return siuuvv.visit(this);
    }

    public Faculty accept(IFacultyWithBiggestQuantityOfStudentsUniversityVisitor fwbqosuv) {
        return fwbqosuv.visit(this);
    }

    public List<Student> accept(IAverageMarkIsHighUniversityVisitor amihuv) {
        return amihuv.visit(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) && Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculties);
    }


    public static class UniversityBuilder {
        private String name;
        private List<Faculty> faculties;

        public UniversityBuilder(String name) {
            this.name = name;
        }

        public UniversityBuilder setFaculties(List<Faculty> faculties) {
            this.faculties = faculties;
            return this;
        }

        public University build() {
            return new University(this);
        }
    }
}
