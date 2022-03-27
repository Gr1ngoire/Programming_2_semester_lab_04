package com.example.lab_04.services.UniversityOperationsCommand;

import com.example.lab_04.services.Entities.Faculty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FacultyAction {
    Faculty execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException;
}
