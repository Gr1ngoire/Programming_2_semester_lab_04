package com.example.lab_04.controllers;

import com.example.lab_04.services.Actions.UniversityOperationsCommand.*;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UniversityOperationsHandlerServlet", value = "/university-operations-handler-servlet")
public class UniversityOperationsHandlerServlet extends HttpServlet {
    Map<String, FacultyOperationAction> facultyActions = new HashMap<>();
    Map<String, StudentsOperationAction> studentActions = new HashMap<>();

    public void init() {
        facultyActions.put("Get faculty with biggest quantity of stdnts", new FacultyWithBiggestQuantityOfStudentsAction());
        studentActions.put("Get all students list", new AllStudentsListAction());
        studentActions.put("Get students with high marks", new StudentsWithHighMarksAction());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            if (action.toLowerCase().contains("faculty")) {
                Faculty result = facultyActions.get(action).execute(request, response);
                request.setAttribute("operation", action);
                request.setAttribute("faculty", result);
                request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
            } else if (action.toLowerCase().contains("students")) {
                List<Student> result = studentActions.get(action).execute(request, response);
                request.setAttribute("operation", action);
                request.setAttribute("resultStudents", result);
                request.getRequestDispatcher("WEB-INF/jsp/studentsListOperationsView.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
