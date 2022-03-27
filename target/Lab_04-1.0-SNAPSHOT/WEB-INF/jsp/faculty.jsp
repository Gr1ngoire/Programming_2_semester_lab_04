<%--
  Created by IntelliJ IDEA.
  User: gring
  Date: 26.03.2022
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.lang.Math" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Faculty Page</title>
</head>
<body class="d-flex flex-column justify-content-center">
<div class="container-fluid d-flex flex-row align-items-center justify-content-center mt-5">
    <div class="d-flex flex-row align-items-center bg-dark text-center text-light rounded h-50">
        <h2 class="pl-2 pr-2">${requestScope.get("operation") == null ? "" : requestScope.get("operation")}</h2>
    </div>
    <h1>${requestScope.get("faculty").name == null ? "No faculty content, sorry....." : ""}</h1>
    <div style="display: ${requestScope.get("faculty").name == null ? "none" : "block"};" class="w-75 mt-5">
        <div class="d-flex justify-content-center">
            <h1 class="bg-info text-center rounded w-75">Faculty: <p class="text-danger">${requestScope.get("faculty").name}</p></h1>
        </div>
        <div class="container-fluid d-flex flex-column rounded">
            <table class="table table-info rounded mt-4">
                <thead>
                <tr>
                    <th class="text-center" scope="col">Id</th>
                    <th class="text-center" scope="col">Student Name</th>
                    <th class="text-center" scope="col">Student Surname</th>
                    <th class="text-center" scope="col">Info button</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${requestScope.faculty.students}">
                    <tr>
                        <th class="text-center" scope="row">${Math.round(Math.random() * 1000)}_${student.faculty.toLowerCase()}</th>
                        <td class="text-center">${student.name}</td>
                        <td class="text-center">${student.surname}</td>
                        <td>
                            <form action="student-servlet" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="studentNameSurname" value="${student.name} ${student.surname} ${student.faculty}">
                                <button class="btn btn-success" type="submit">
                                    Get ${student.name} info
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="display: ${requestScope.get("operation") == null ? "block" : "none"}">
                <div class="d-flex flex-column w-100" id="addStudentContainer">
                    <button id="addStudentButton" class="btn btn-primary" data-status="inactive">Add new student</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    const studentAddFormContainer = document.querySelector("#addStudentContainer");
    const addStudentButton = document.querySelector("#addStudentButton");

    const addStudentDiv = document.createElement("div");
    addStudentDiv.setAttribute("id", "divToMoveItMoveIt");
    addStudentDiv.setAttribute("class", "d-flex flex-column");

    const addStudentForm = document.createElement("form");
    addStudentForm.setAttribute("action", "student-servlet");
    addStudentForm.setAttribute("method", "post");

    const addStudentNameInput = document.createElement("input");
    addStudentNameInput.setAttribute("placeholder", "Student name");
    addStudentNameInput.setAttribute("name", "studentToCreateName");
    addStudentNameInput.setAttribute("class", "form-control mt-1");

    const addStudentSurnameInput = document.createElement("input");
    addStudentSurnameInput.setAttribute("placeholder", "Student surname");
    addStudentSurnameInput.setAttribute("name", "studentToCreateSurname");
    addStudentSurnameInput.setAttribute("class", "form-control mt-1");

    const addStudentMarkBookIdInput = document.createElement("input");
    addStudentMarkBookIdInput.setAttribute("placeholder", "Student mark book id");
    addStudentMarkBookIdInput.setAttribute("name", "studentToCreateMarkBookId");
    addStudentMarkBookIdInput.setAttribute("class", "form-control mt-1");

    const addStudentAverageMarkInput = document.createElement("input");
    addStudentAverageMarkInput.setAttribute("placeholder", "Student average mark");
    addStudentAverageMarkInput.setAttribute("name", "studentToCreateAverageMark");
    addStudentAverageMarkInput.setAttribute("class", "form-control mt-1");

    const buttonWrapper = document.createElement("div");
    buttonWrapper.setAttribute("class", "d-flex justify-content-center w-100 mt-3");

    const addStudentSubmitButton = document.createElement("button");
    addStudentSubmitButton.setAttribute("class", "btn btn-success w-25");
    addStudentSubmitButton.setAttribute("type", "submit");
    addStudentSubmitButton.innerText = "Create Student!";

    buttonWrapper.append(addStudentSubmitButton);
    addStudentForm.append(addStudentNameInput, addStudentSurnameInput, addStudentMarkBookIdInput, addStudentAverageMarkInput, buttonWrapper);
    addStudentDiv.append(addStudentForm);

    addStudentButton.addEventListener('click', (event) => {
        const divToMoveItMoveIt = document.querySelector("#divToMoveItMoveIt");
        event.target.dataset.status === "active" ? divToMoveItMoveIt.remove() : studentAddFormContainer.append(addStudentDiv);

        event.target.dataset.status = event.target.dataset.status === "active" ? "inactive" : "active";
        addStudentButton.innerText = addStudentButton.innerText === "Add new student" ? "Cancel" : "Add new student";
        addStudentButton.className = addStudentButton.innerText === "Add new student" ? "btn btn-primary" : "btn btn-danger";
    })

</script>
</html>
