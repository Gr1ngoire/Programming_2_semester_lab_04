package com.example.lab_04.services.Actions.crudActions.facultyActions;

import com.example.lab_04.dao.MyDAO;
import com.example.lab_04.services.DTOs.FacultyReceiveDTO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class addFacultyAction implements FacultyAction{
    @Override
    public void execute(MyDAO dao, FacultyReceiveDTO facultyReceiveDTO, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        String facultyToCreateName = facultyReceiveDTO.getName();
        Faculty newFaculty = new Faculty.FacultyBuilder(facultyToCreateName).setStudents(new ArrayList<>()).build();
        University university = dao.getData();
        university.addFaculty(newFaculty);
        dao.update(university);
        request.setAttribute("university", university);
        request.getRequestDispatcher("WEB-INF/jsp/university.jsp").forward(request, response);
    }

}
