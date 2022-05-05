package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Utils.validators.StudentCustomValidator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    DAO dao;
    StudentCustomValidator studentCustomValidator;

    public void init() {
        dao = new DAO();
        studentCustomValidator = new StudentCustomValidator();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String actionTypeToLookAt = request.getParameter("actionTypeToLookAt");
        String studentBookMarkId = request.getParameter("studentMarkBookId");
        String facultyName = request.getParameter("studentFaculty");

        try {
            studentCustomValidator.validate(new HashMap<String, String>(){{
                put("markBookId", studentBookMarkId);
                put("faculty", facultyName);
            }});
            List<Faculty> facultiesList = dao.getData().getFaculties();
            for (Faculty f : facultiesList) {
                if (f.getName().equals(facultyName)) {
                    for (Student s : f.getStudents()) {
                        if (s.getMarkBookId().equals(studentBookMarkId)) {
                            request.setAttribute("student", s);
                            request.getRequestDispatcher(String.format("WEB-INF/jsp/%s.jsp", actionTypeToLookAt == null ? "student" : "studentEditPage")).forward(request, response);
                            break;
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException | IllegalArgumentException | NullPointerException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("WEB-INF/jsp/errorPage.jsp").forward(request, response);
        }
    }
}
