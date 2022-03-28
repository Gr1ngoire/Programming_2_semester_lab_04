package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Actions.crudActions.facultyActions.FacultyAction;
import com.example.lab_04.services.Actions.crudActions.facultyActions.addFacultyAction;
import com.example.lab_04.services.Actions.crudActions.facultyActions.deleteFacultyAction;
import com.example.lab_04.services.Actions.crudActions.universityActions.UniversityAction;
import com.example.lab_04.services.Actions.crudActions.universityActions.getUniversityAction;
import com.example.lab_04.services.Entities.University;
import com.example.lab_04.services.Utils.validators.FacultyValidator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "greetingServlet", value = "/university-servlet")
public class UniversityServlet extends HttpServlet {
    DAO dao;
    FacultyValidator facultyValidator;
    Map<String, UniversityAction> universityActions;
    Map<String, FacultyAction> facultyActions;

    public void init() {
        universityActions = new HashMap<>();
        facultyActions = new HashMap<>();
        facultyValidator = new FacultyValidator();
        dao = new DAO();

        universityActions.put("Get", new getUniversityAction());

        facultyActions.put("Create", new addFacultyAction());
        facultyActions.put("Delete", new deleteFacultyAction());
        try {
            // dao.writeTestData();
            University university = dao.getData();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            universityActions.get("Get").execute(dao, request, response);
        } catch (ClassNotFoundException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyToCreateName = request.getParameter("facultyToCreateName");
        String action = request.getParameter("facultyActionType");
        try {
            if (facultyToCreateName != null) {
                facultyValidator.validateAll(facultyToCreateName.trim().split(" "));
            }
            facultyActions.get(action).execute(dao, request, response);
        } catch (IllegalArgumentException | ClassNotFoundException | ClassCastException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }
    }


}