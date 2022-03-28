package com.example.lab_04.services.Entities;

import com.example.lab_04.services.AllStudentsInUniversityVisitor.IStudentsInUniversityVisitorStudentVisitor;
import com.example.lab_04.services.AverageMarkIsHigh.IAverageMarkIsHighStudentVisitor;
import com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents.IFacultyWithBiggestQuantityOfStudentsStudentVisitor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Student extends HumanInUniversity implements Serializable {
    private String name;
    private String surname;
    private String faculty;
    private String markBookId;
    private double averageMark;

    public Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.surname = studentBuilder.surname;
        this.faculty = studentBuilder.faculty;
        this.markBookId = studentBuilder.markBookId;
        this.averageMark = studentBuilder.averageMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getMarkBookId() {
        return markBookId;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(markBookId, student.markBookId) && Objects.equals(averageMark, student.averageMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, markBookId, averageMark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", faculty='" + faculty + '\'' +
                ", markBookId='" + markBookId + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }

    public void accept(List<Student> list, IStudentsInUniversityVisitorStudentVisitor siuvsv) {
        siuvsv.visit(list, this);
    }

    public int accept(IFacultyWithBiggestQuantityOfStudentsStudentVisitor fwbqossv) {
        return fwbqossv.visit(this);
    }

    public void accept(List<Student> list, IAverageMarkIsHighStudentVisitor amih) {
        amih.visit(list, this);
    }

    public static class StudentBuilder {
        private String name;
        private String surname;
        private String faculty;
        private String markBookId;
        private double averageMark;

        public StudentBuilder(String name) {
            this.name = name;
        }

        public StudentBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder setFaculty(String faculty) {
            this.faculty = faculty;
            return this;
        }

        public StudentBuilder setMarkBookId(String markBookId) {
            this.markBookId = markBookId;
            return this;
        }

        public StudentBuilder setAverageMark(double averageMark) {
            this.averageMark = averageMark;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
