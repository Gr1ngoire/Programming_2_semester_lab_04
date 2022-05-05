package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.MyDAO;
import com.example.lab_04.services.DTOs.StudentReceiveDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface StudentAction {
    void execute (MyDAO dao, StudentReceiveDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException;
}
