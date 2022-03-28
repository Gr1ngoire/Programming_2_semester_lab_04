package com.example.lab_04.services.Entities;

import com.example.lab_04.services.AllStudentsInUniversityVisitor.IStudentsInUniversityVisitorFacultyVisitor;
import com.example.lab_04.services.AverageMarkIsHigh.IAverageMarkIsHighFacultyVisitor;
import com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents.IFacultyWithBiggestQuantityOfStudentsFacultyVisitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty implements Serializable {
    private String name;
    private List<Student> students;

    public Faculty(FacultyBuilder facultyBuilder) {
        this.name = facultyBuilder.name;
        this.students = facultyBuilder.students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void updateStudent(Student updatedStudent) {
        for (Student s: students) {
            if (s.getMarkBookId().equals(updatedStudent.getMarkBookId())){
                s.setName(updatedStudent.getName());
                s.setSurname(updatedStudent.getSurname());
                s.setAverageMark(updatedStudent.getAverageMark());
            }
        }
    }

    public void removeStudent(Student studentToRemove) {
        students.remove(studentToRemove);
    }

    public void accept(List<Student> list,  IStudentsInUniversityVisitorFacultyVisitor siuvfv) {
        siuvfv.visit(list,this);
    }

    public int accept(IFacultyWithBiggestQuantityOfStudentsFacultyVisitor fwbqosfv) {
        return fwbqosfv.visit(this);
    }

    public void accept(List<Student> list, IAverageMarkIsHighFacultyVisitor amihfv) {
        amihfv.visit(list, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.equals(students, faculty.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students);
    }


    public static class FacultyBuilder {
        private String name;
        private List<Student> students;

        public FacultyBuilder(String name) {
            this.name = name;
        }

        public FacultyBuilder setStudents(List<Student> students) {
            this.students = students;
            return this;
        }

        public Faculty build() {
            return new Faculty(this);
        }
    }
}
