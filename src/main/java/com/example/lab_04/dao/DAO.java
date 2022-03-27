package com.example.lab_04.dao;

import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import java.io.*;
import java.util.ArrayList;

public class DAO {
    public void update(University toWrite) throws IOException {

        File file = new File("D:\\Desktop\\University\\Labs\\Programming_2_semester\\Lab_04\\src\\main\\java\\com\\example\\lab_04\\myDatabase\\db.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
            oos.writeObject(toWrite);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public University getData() throws IOException, ClassNotFoundException, ClassCastException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Desktop\\University\\Labs\\Programming_2_semester\\Lab_04\\src\\main\\java\\com\\example\\lab_04\\myDatabase\\db.bin"));) {
            return (University) ois.readObject();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(e.getMessage());
        } catch (ClassCastException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    public void writeTestData() throws IOException {

        File file = new File("D:\\Desktop\\University\\Labs\\Programming_2_semester\\Lab_04\\src\\main\\java\\com\\example\\lab_04\\myDatabase\\db.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
            Student Ivanov = new Student.StudentBuilder("Petro").setSurname("Ivanov").setFaculty("FICT").setMarkBookId("123").setAverageMark(87).build();
            Student Petrov = new Student.StudentBuilder("Andriy").setSurname("Petrov").setFaculty("FICT").setMarkBookId("456").setAverageMark(96).build();
            Student Sydorov = new Student.StudentBuilder("Mykola").setSurname("Sydorov").setFaculty("FICT").setMarkBookId("789").setAverageMark(95).build();
            Faculty FICT = new Faculty.FacultyBuilder("FICT").setStudents(new ArrayList<>()).build();
            FICT.addStudent(Ivanov);
            FICT.addStudent(Petrov);
            FICT.addStudent(Sydorov);
            University KPI = new University.UniversityBuilder("KPI").setFaculties(new ArrayList<>()).build();
            KPI.addFaculty(FICT);
            oos.writeObject(KPI);
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}
