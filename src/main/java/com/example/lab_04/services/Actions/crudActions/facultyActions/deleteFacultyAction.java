package com.example.lab_04.services.Actions.crudActions.facultyActions;

import com.example.lab_04.dao.MyDAO;
import com.example.lab_04.services.DTOs.FacultyReceiveDTO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteFacultyAction implements FacultyAction{
    @Override
    public void execute(MyDAO dao, FacultyReceiveDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        String facultyName = dto.getName();
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
