package com.example.lab_04.controllers;

import com.example.lab_04.dao.BinaryFileDAO;
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
    BinaryFileDAO binaryFileDao;
    FacultyCustomValidator facultyCustomValidator;
    StudentCustomValidator studentValidator;
    Map<String, StudentAction> actions;

    public void init() {
        binaryFileDao = new BinaryFileDAO();
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
            List<Faculty> faculties = binaryFileDao.getData().getFaculties();
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

            StudentReceiveDTO studentDTO = new StudentReceiveDTO.StudentReceiveDTOBuilder(request.getParameter("studentName"))
                    .setSurname(request.getParameter("studentSurname"))
                    .setMarkBookId(request.getParameter("studentMarkBookId"))
                    .setAverageMark(request.getParameter("studentAverageMark"))
                    .setFaculty(request.getParameter("studentFaculty"))
                    .build();
            studentValidator.validate(studentDTO.asHashMap());

            actions.get(actionType).execute(binaryFileDao, studentDTO, request, response);

        } catch (IllegalArgumentException | ClassNotFoundException | ClassCastException | NullPointerException | IOException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }


    }

}
