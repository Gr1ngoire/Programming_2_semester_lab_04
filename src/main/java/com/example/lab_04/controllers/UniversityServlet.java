package com.example.lab_04.controllers;

import com.example.lab_04.dao.BinaryFileDAO;
import com.example.lab_04.services.Actions.crudActions.facultyActions.FacultyAction;
import com.example.lab_04.services.Actions.crudActions.facultyActions.addFacultyAction;
import com.example.lab_04.services.Actions.crudActions.facultyActions.deleteFacultyAction;
import com.example.lab_04.services.Actions.crudActions.universityActions.UniversityAction;
import com.example.lab_04.services.Actions.crudActions.universityActions.getUniversityAction;
import com.example.lab_04.services.DTOs.FacultyReceiveDTO;
import com.example.lab_04.services.Utils.validators.FacultyCustomValidator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "greetingServlet", value = "/university-servlet")
public class UniversityServlet extends HttpServlet {
    BinaryFileDAO binaryFileDao;
    FacultyCustomValidator facultyValidator;
    Map<String, UniversityAction> universityActions;
    Map<String, FacultyAction> facultyActions;

    public void init() {
        binaryFileDao = new BinaryFileDAO();
        universityActions = new HashMap<>();
        facultyActions = new HashMap<>();
        facultyValidator = new FacultyCustomValidator();
        universityActions.put("Get", new getUniversityAction());
        facultyActions.put("Create", new addFacultyAction());
        facultyActions.put("Delete", new deleteFacultyAction());
//
//        try {
//            binaryFileDao.writeTestData();
//            University university = binaryFileDao.getData();
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            universityActions.get("Get").execute(binaryFileDao, request, response);
        } catch (ClassNotFoundException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FacultyReceiveDTO frDTO = new FacultyReceiveDTO(request.getParameter("facultyName"));
        String action = request.getParameter("facultyActionType");
        try {
            facultyValidator.validate(frDTO.asHashMap());
            if (facultyActions.get(action) == null) {
                throw new NullPointerException("There is no such action");
            }

            facultyActions.get(action).execute(binaryFileDao, frDTO, request, response);
        } catch (IllegalArgumentException | ClassNotFoundException | ClassCastException | NullPointerException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }
    }


}