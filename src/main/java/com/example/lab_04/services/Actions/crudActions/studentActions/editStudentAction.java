package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editStudentAction implements StudentAction{
    @Override
    public void execute(DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        String studentToEditName = request.getParameter("studentToEditName").trim();
        String studentToEditSurname = request.getParameter("studentToEditSurname").trim();
        String studentToEditMarkBookId = request.getParameter("studentToEditMarkBookId");
        String studentToEditAverageMark = request.getParameter("studentToEditAverageMark").trim();
        String studentToEditFaculty = request.getParameter("studentToEditFaculty");

        Student updatedStudent = new Student.StudentBuilder(studentToEditName).setSurname(studentToEditSurname).setFaculty(studentToEditFaculty).setMarkBookId(studentToEditMarkBookId).setAverageMark(Double.parseDouble(studentToEditAverageMark)).build();
        University university = dao.getData();
        for (Faculty f : university.getFaculties()) {
            if (f.getName().equals(studentToEditFaculty)) {
                for (Student s: f.getStudents()) {
                    if (s.getMarkBookId().equals(updatedStudent.getMarkBookId())) {
                        f.updateStudent(updatedStudent);
                        dao.update(university);
                        request.setAttribute("faculty", f);
                        request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                        return;
                    }
                }
            }
        }
    }
}
