<%--
  Created by IntelliJ IDEA.
  User: gring
  Date: 27.03.2022
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.lang.Math" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Result students</title>
</head>
<body class="d-flex flex-column justify-content-center">
<div class="container-fluid d-flex flex-row align-items-center justify-content-center mt-5">
    <div class="d-flex flex-column align-items-center bg-dark text-center text-light rounded h-50">
        <div class="d-flex align-items-center mt-3">
            <form action="university-servlet">
                <button
                        class="btn btn-outline-light">
                    <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="16"
                            height="16"
                            fill="currentColor"
                            class="bi bi-arrow-left"
                            viewBox="0 0 16 16"
                    >
                        <path fillRule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                    </svg>
                    Go back to the university
                </button>
            </form>
            <h2 class="pl-2 pr-2">
                <c:if test="${requestScope.operation == null}">
                    No operation results, sorry....
                </c:if>
            </h2>
        </div>
    </div>
    <div class="container-fluid d-flex flex-column rounded">
        <table class="table table-info rounded mt-4">
            <thead>
            <tr>
                <th class="text-center" scope="col">Student Name</th>
                <th class="text-center" scope="col">Student Surname</th>
                <th class="text-center" scope="col">Info button</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${requestScope.resultStudents}">
                <tr>
                    <td class="text-center">${student.name}</td>
                    <td class="text-center">${student.surname}</td>
                    <td>
                        <form action="student-servlet" class="d-flex flex-row justify-content-center">
                            <input type="text" style="display: none;" name="studentNameSurname"
                                   value="${student.name} ${student.surname} ${student.faculty}">
                            <button class="btn btn-success" type="submit">
                                Get ${student.name} info
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
