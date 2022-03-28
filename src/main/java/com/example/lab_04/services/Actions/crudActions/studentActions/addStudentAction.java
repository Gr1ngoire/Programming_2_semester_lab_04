package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addStudentAction implements StudentAction{
    @Override
    public void execute(DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        String studentToCreateName = request.getParameter("studentToCreateName").trim();
        String studentToCreateSurname = request.getParameter("studentToCreateSurname").trim();
        String studentToCreateMarkBookId = request.getParameter("studentToCreateMarkBookId").trim();
        String studentToCreateAverageMark = request.getParameter("studentToCreateAverageMark").trim();
        String studentToCreateFaculty = request.getParameter("studentToCreateFaculty");

        University university = dao.getData();
        Student newStudent = new Student.StudentBuilder(studentToCreateName).setSurname(studentToCreateSurname).setFaculty(studentToCreateFaculty).setMarkBookId(studentToCreateMarkBookId).setAverageMark(Double.parseDouble(studentToCreateAverageMark)).build();
        for (Faculty f : university.getFaculties()) {
            if (f.getName().equals(studentToCreateFaculty)) {
                f.addStudent(newStudent);
                dao.update(university);
                request.setAttribute("faculty", f);
                request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                break;
            }
        }
    }
}
