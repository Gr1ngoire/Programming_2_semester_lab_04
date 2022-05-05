package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Actions.crudActions.studentActions.StudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.addStudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.deleteStudentAction;
import com.example.lab_04.services.Actions.crudActions.studentActions.editStudentAction;
import com.example.lab_04.services.DTOs.StudentReceiveDTO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Utils.validators.FacultyCustomValidator;
import com.example.lab_04.services.Utils.validators.StudentCustomValidator;

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
    FacultyCustomValidator facultyCustomValidator;
    StudentCustomValidator studentValidator;
    Map<String, StudentAction> actions;

    public void init() {
        dao = new DAO();
        facultyCustomValidator = new FacultyCustomValidator();
        studentValidator = new StudentCustomValidator();
        actions = new HashMap<>();
        actions.put("Create", new addStudentAction());
        actions.put("Delete", new deleteStudentAction());
        actions.put("Edit", new editStudentAction());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        try {
            String facultyName = request.getParameter("facultyName");
            facultyCustomValidator.validate(new HashMap<String, String>(){{put("facultyName", facultyName);}});
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
            if (actions.get(actionType) == null) {
                throw new IllegalArgumentException("There is no such action");
            }

            if (actionType.equals("Create")) {
                StudentReceiveDTO studentToCreateDto = new StudentReceiveDTO.StudentReceiveDTOBuilder(request.getParameter("studentToCreateName"))
                        .setSurname(request.getParameter("studentToCreateSurname"))
                        .setMarkBookId(request.getParameter("studentToCreateMarkBookId"))
                        .setAverageMark(request.getParameter("studentToCreateAverageMark"))
                        .setFaculty(request.getParameter("studentToCreateFaculty"))
                        .build();
                studentValidator.validate(studentToCreateDto.asHashMap());
            } else if (actionType.equals("Edit")) {
                StudentReceiveDTO studentToEditDto = new StudentReceiveDTO.StudentReceiveDTOBuilder(request.getParameter("studentToEditName"))
                        .setSurname(request.getParameter("studentToEditSurname"))
                        .setMarkBookId(request.getParameter("studentToEditMarkBookId"))
                        .setAverageMark(request.getParameter("studentToEditAverageMark"))
                        .setFaculty(request.getParameter("studentToEditFaculty"))
                        .build();
                studentValidator.validate(studentToEditDto.asHashMap());
            }

            actions.get(actionType).execute(dao, request, response);

        } catch (IllegalArgumentException | ClassNotFoundException | ClassCastException | NullPointerException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }


    }

}
