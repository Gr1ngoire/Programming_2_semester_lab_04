package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Actions.crudActions.studentActions.StudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.addStudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.deleteStudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.editStudentAction;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;
import com.example.lab_04.services.Utils.validators.StudentValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacultyServlet", value = "/faculty-servlet")
public class FacultyServlet extends HttpServlet {
    DAO dao;
    StudentValidator studentValidator;
    Map<String, StudentAction> actions;

    public void init() {
        dao = new DAO();
        studentValidator = new StudentValidator();
        actions = new HashMap<>();
        actions.put("Create", new addStudentAction());
        actions.put("Delete", new deleteStudentAction());
        actions.put("Edit", new editStudentAction());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyName = request.getParameter("facultyName");
        try {
            List<Faculty> faculties = dao.getData().getFaculties();
            for (Faculty f : faculties) {
                if (f.getName().equals(facultyName)) {
                    request.setAttribute("faculty", f);
                    request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionType = request.getParameter("actionType");

        try {
            if (actionType.equals("Create")) {
                studentValidator.validateAll(String.format("%s %s %s %s", request.getParameter("studentToCreateName").trim(), request.getParameter("studentToCreateSurname").trim(), request.getParameter("studentToCreateMarkBookId").trim(), request.getParameter("studentToCreateAverageMark").trim()).split(" "));
            } else if (actionType.equals("Edit")) {
                studentValidator.validateAll(String.format("%s %s %s %s", request.getParameter("studentToEditName").trim(), request.getParameter("studentToEditSurname").trim(), request.getParameter("studentToEditMarkBookId"), request.getParameter("studentToEditAverageMark").trim()).split(" "));
            }

            actions.get(actionType).execute(dao, request, response);

        } catch (IllegalArgumentException | ClassNotFoundException | ClassCastException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }


    }

}
