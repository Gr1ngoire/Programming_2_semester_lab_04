package com.example.lab_04.services.Actions.crudActions.facultyActions;

import com.example.lab_04.dao.BinaryFileDAO;
import com.example.lab_04.services.DTOs.FacultyReceiveDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface FacultyAction {
    void execute (BinaryFileDAO binaryFileDao, FacultyReceiveDTO facultyReceiveDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException;
}
