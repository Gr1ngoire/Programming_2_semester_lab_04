package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacultyServlet", value = "/faculty-servlet")
public class FacultyServlet extends HttpServlet {
    DAO dao;
    List<Faculty> faculties;

    public void init() {
        dao = new DAO();
        try {
            faculties = dao.getData().getFaculties();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String facultyName = request.getParameter("facultyName");

        for (Faculty f : faculties) {
            if (f.getName().equals(facultyName)) {
                request.setAttribute("faculty", f);
                request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
