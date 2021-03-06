package com.example.lab_04.services.Actions.crudActions.studentActions;

import com.example.lab_04.dao.JsonDAO;
import com.example.lab_04.dao.MyDAO;
import com.example.lab_04.services.DTOs.StudentReceiveDTO;
import com.example.lab_04.services.Entities.Faculty;
import com.example.lab_04.services.Entities.Student;
import com.example.lab_04.services.Entities.University;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addStudentAction implements StudentAction {
    @Override
    public void execute(MyDAO dao, StudentReceiveDTO dto, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {
        String studentToCreateName = dto.getName();
        String studentToCreateSurname = dto.getSurname();
        String studentToCreateMarkBookId = dto.getMarkBookId();
        String studentToCreateAverageMark = dto.getAverageMark();
        String studentToCreateFaculty = dto.getFaculty();

        University university = dao.getData();
        Student newStudent = new Student.StudentBuilder(studentToCreateName).setSurname(studentToCreateSurname).setFaculty(studentToCreateFaculty).setMarkBookId(studentToCreateMarkBookId).setAverageMark(Double.parseDouble(studentToCreateAverageMark)).build();
        for (Faculty f : university.getFaculties()) {
            if (f.getName().equals(studentToCreateFaculty)) {
                f.addStudent(newStudent);
                JsonDAO jsonDAO = new JsonDAO();
                jsonDAO.update(university);
                dao.update(university);
                request.setAttribute("faculty", f);
                request.getRequestDispatcher("WEB-INF/jsp/faculty.jsp").forward(request, response);
                break;
            }
        }
    }
}
