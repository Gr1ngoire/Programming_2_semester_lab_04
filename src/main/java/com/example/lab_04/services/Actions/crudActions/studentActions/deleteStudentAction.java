package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.DAO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteStudentAction implements StudentAction{
    @Override
    public void execute(DAO dao, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        String studentMarkBookId = request.getParameter("studentMarkBookId");
        String studentFaculty = request.getParameter("studentFaculty");
        University university = dao.getData();
        for (Faculty f : university.getFaculties()) {
            if (f.getName().equals(studentFaculty)) {
                for (Student s: f.getStudents()) {
                    if (s.getMarkBookId().equals(studentMarkBookId)){
                        f.removeStudent(s);
                        dao.update(university);
                        request.setAttribute("faculty", f);
                        request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                        break;
                    }
                }
            }
        }
    }
}
