<%--
  Created by IntelliJ IDEA.
  User: gring
  Date: 26.03.2022
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.lang.Math" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>University Page</title>
</head>
<body class="d-flex flex-column justify-content-center">
<div class="container-fluid d-flex flex-row justify-content-center mt-5">
    <h1><c:if test="${requestScope.university.name == null}">No university content, sorry.....</c:if></h1>
    <div style="display: ${requestScope.get("university").name == null ? "none" : "block"};" class="w-75 mt-5">
        <div class="d-flex justify-content-center">
            <h1 class="bg-info text-center rounded w-75">University: <p
                    class="text-danger"><c:out value="${requestScope.university.name}"/></p></h1>
        </div>
        <div class="container-fluid d-flex flex-column rounded">
            <table class="table table-info rounded mt-4">
                <thead>
                <tr>
                    <th class="text-center" scope="col">Id</th>
                    <th class="text-center" scope="col">Faculty name</th>
                    <th class="text-center" scope="col">Info Button</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="faculty" items="${requestScope.university.faculties}">
                    <tr>
                        <th class="text-center"
                            scope="row">${Math.round(Math.random() * 1000)}_<c:out value="${requestScope.university.name.toLowerCase()}"/></th>
                        <td class="text-center">${faculty.name}</td>
                        <td class="d-flex justify-content-center">
                            <form action="faculty-servlet" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="facultyName" value="${faculty.name}">
                                <button class="btn btn-success" type="submit">
                                    Get ${faculty.name} students info
                                </button>
                            </form>
                            <form action="university-servlet" method="post" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="facultyName" value="${faculty.name}">
                                <input type="text" style="display: none" name="facultyActionType" value="Delete">
                                <button class="btn btn-danger" type="submit">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="w-100">
                <form class="d-flex flex-column" action="university-operations-handler-servlet">
                    <input class="btn btn-dark mt-1" type="submit" name="action" value="Get all students list">
                    <input class="btn btn-danger mt-1" type="submit" name="action"
                           value="Get faculty with biggest quantity of stdnts">
                    <input class="btn btn-warning mt-1" type="submit" name="action"
                           value="Get students with high marks">
                </form>
            </div>
            <div class="d-flex flex-column w-100 mt-5" id="addFacultyContainer">
                <button id="addFacultyButton" class="btn btn-primary" data-status="inactive">Add new faculty</button>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/js/university.js"/>" type="text/javascript"></script>
</body>
</html>
