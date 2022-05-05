package com.example.lab_04.services.Actions.UniversityOperationsCommand;

import com.example.lab_04.dao.JsonDAO;
import com.example.lab_04.dao.MyDAO;
import com.example.lab_04.services.AllStudentsInUniversityVisitor.StudentsInUniversityUniversityVisitor;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllStudentsListAction implements StudentsOperationAction {
    @Override
    public List<Student> execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        MyDAO dao = new JsonDAO();
        University university = dao.getData();
        StudentsInUniversityUniversityVisitor siuuv = new StudentsInUniversityUniversityVisitor();
        return siuuv.visit(university);
    }
}
