package com.example.lab_04.services.Actions.UniversityOperationsCommand;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.University;
import com.example.lab_04.services.FacultyWithBiggestQuantityOfStudents.FacultyWithBiggestQuantityOfStudentsUniversityVisitor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacultyWithBiggestQuantityOfStudentsAction implements FacultyOperationAction {
    @Override
    public Faculty execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        DAO dao = new DAO();
        University university = dao.getData();
        FacultyWithBiggestQuantityOfStudentsUniversityVisitor fwbqosuv = new FacultyWithBiggestQuantityOfStudentsUniversityVisitor();
        return fwbqosuv.visit(university);
    }
}
