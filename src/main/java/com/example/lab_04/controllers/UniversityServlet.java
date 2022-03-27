package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.University;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "greetingServlet", value = "/university-servlet")
public class UniversityServlet extends HttpServlet {
    DAO dao;
    University university;

    public void init() {
        dao = new DAO();
        try {
            dao.writeTestData();
            university = dao.getData();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("university", university);
            request.getRequestDispatcher("WEB-INF/jsp/university.jsp").forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroy() {
    }
}