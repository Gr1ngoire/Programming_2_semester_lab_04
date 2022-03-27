package com.example.lab_04.controllers;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
    DAO dao;
    List<Faculty> facultiesList;

    public void init() {
        dao = new DAO();
        try {
            facultiesList = dao.getData().getFaculties();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String studentNameSurnameFaculty = request.getParameter("studentNameSurname");
        String[] studentNameSurnameFacultyToFindData = studentNameSurnameFaculty.split(" ");
        String studentName = studentNameSurnameFacultyToFindData[0];
        String studentSurname = studentNameSurnameFacultyToFindData[1];
        String facultyName = studentNameSurnameFacultyToFindData[2];

        System.out.println(studentName);
        System.out.println(studentSurname);
        System.out.println(facultyName);
        for (Faculty f : facultiesList) {
            if (f.getName().equals(facultyName)) {
                for (Student s : f.getStudents()) {
                    if (s.getName().equals(studentName) && s.getSurname().equals(studentSurname)) {
                        request.setAttribute("student", s);
                        request.getRequestDispatcher("WEB-INF/jsp/student.jsp").forward(request, response);
                        break;
                    }
                }
            }
        }
    }

}
