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
    <h1>${requestScope.get("university").name == null ? "No university content, sorry....." : ""}</h1>
    <div style="display: ${requestScope.get("university").name == null ? "none" : "block"};" class="w-75 mt-5">
        <div class="d-flex justify-content-center">
            <h1 class="bg-info text-center rounded w-75">University: <p class="text-danger">${requestScope.get("university").name}</p></h1>
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
                        <th class="text-center" scope="row">${Math.round(Math.random() * 1000)}_${requestScope.get("university").name.toLowerCase()}</th>
                        <td class="text-center">${faculty.name}</td>
                        <td>
                            <form action="faculty-servlet" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="facultyName" value="${faculty.name}">
                                <button class="btn btn-success" type="submit">
                                    Get ${faculty.name} students info
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
                    <input class="btn btn-danger mt-1" type="submit" name="action" value="Get faculty with biggest quantity of stdnts">
                    <input class="btn btn-warning mt-1" type="submit" name="action" value="Get students with high marks">
                </form>
            </div>
            <div class="d-flex flex-column w-100 mt-5" id="addFacultyContainer">
                <button id="addFacultyButton" class="btn btn-primary" data-status="inactive">Add new faculty</button>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    const facultyAddFormContainer = document.querySelector("#addFacultyContainer");
    const addFacultyButton = document.querySelector("#addFacultyButton");

    const addFacultyDiv = document.createElement("div");
    addFacultyDiv.setAttribute("id", "divToMoveItMoveIt")
    addFacultyDiv.setAttribute("class", "d-flex flex-column")

    const addFacultyForm = document.createElement("form");
    addFacultyForm.setAttribute("action", "faculty-servlet")
    addFacultyForm.setAttribute("method", "post");

    const addFacultyNameInput = document.createElement("input");
    addFacultyNameInput.setAttribute("placeholder", "Faculty name");
    addFacultyNameInput.setAttribute("name", "facultyToCreateName");
    addFacultyNameInput.setAttribute("class", "form-control mt-2");

    const buttonWrapper = document.createElement("div")
    buttonWrapper.setAttribute("class", "d-flex justify-content-center w-100 mt-3")

    const addFacultySubmitButton = document.createElement("button");
    addFacultySubmitButton.setAttribute("class", "btn btn-success w-25");
    addFacultySubmitButton.setAttribute("type", "submit")
    addFacultySubmitButton.innerText = "Create Faculty!"

    buttonWrapper.append(addFacultySubmitButton)
    addFacultyForm.append(addFacultyNameInput, buttonWrapper);
    addFacultyDiv.append(addFacultyForm);
    addFacultyButton.addEventListener('click', (event) => {
        const divToMoveItMoveIt = document.querySelector("#divToMoveItMoveIt");
        event.target.dataset.status === "active" ? divToMoveItMoveIt.remove() : facultyAddFormContainer.append(addFacultyDiv);

        event.target.dataset.status = event.target.dataset.status === "active" ? "inactive" : "active";
        addFacultyButton.innerText = addFacultyButton.innerText === "Add new faculty" ? "Cancel" : "Add new faculty";
        addFacultyButton.className = addFacultyButton.innerText === "Add new faculty" ? "btn btn-primary" : "btn btn-danger";
    })
</script>
</html>
