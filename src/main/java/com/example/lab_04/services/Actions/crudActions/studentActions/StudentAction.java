package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface StudentAction {
    void execute (DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException;
}
