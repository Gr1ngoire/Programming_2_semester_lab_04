package com.example.lab_04.services.Actions.crudActions.universityActions;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getUniversityAction implements UniversityAction {
    @Override
    public void execute(DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        University university = dao.getData();
        request.setAttribute("university", university);
        request.getRequestDispatcher("WEB-INF/jsp/university.jsp").forward(request, response);
    }
}
