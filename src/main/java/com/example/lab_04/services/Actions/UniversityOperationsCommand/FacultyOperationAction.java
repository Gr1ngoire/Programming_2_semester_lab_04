package com.example.lab_04.services.Actions.UniversityOperationsCommand;

import com.example.lab_04.services.Entities.Faculty;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FacultyOperationAction {
    Faculty execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException;
}
