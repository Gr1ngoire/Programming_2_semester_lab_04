package com.example.lab_04.services.Actions.crudActions.universityActions;

import com.example.lab_04.dao.MyDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UniversityAction {
    void execute (MyDAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException;
}
