package com.example.lab_04.services.Actions.crudActions.facultyActions;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteFacultyAction implements FacultyAction{
    @Override
    public void execute(DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        String facultyName = request.getParameter("facultyName");
        University university = dao.getData();
        for (Faculty f : university.getFaculties()) {
            if (f.getName().equals(facultyName)) {
                university.removeFaculty(f);
                dao.update(university);
                request.setAttribute("university", university);
                request.getRequestDispatcher("WEB-INF/jsp/university.jsp").forward(request, response);
                break;
            }
        }
    }
}
