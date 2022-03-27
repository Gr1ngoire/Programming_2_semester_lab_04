package com.example.lab_04.services.UniversityOperationsCommand;

import com.example.lab_04.services.Entities.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface StudentsAction {
    List<Student> execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException;
}
