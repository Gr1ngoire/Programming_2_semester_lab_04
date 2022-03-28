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
        <h2 class="pl-2 pr-2"><c:if test="${requestScope.operation != null}">${requestScope.operation}</c:if></h2>
    </div>
    <h1><c:if test="${requestScope.faculty == null}">No faculty content, sorry.....</c:if></h1>
    <div style="display: ${requestScope.get("faculty").name == null ? "none" : "block"};" class="w-75 mt-5">
        <div class="d-flex justify-content-around">
            <div class="d-flex align-items-center">
                <form action="university-servlet">
                    <button
                            class="btn btn-outline-primary">
                        <svg
                                xmlns="http://www.w3.org/2000/svg"
                                width="16"
                                height="16"
                                fill="currentColor"
                                class="bi bi-arrow-left"
                                viewBox="0 0 16 16"
                        >
                            <path fillRule="evenodd"
                                  d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                        </svg>
                        Go back to the university
                    </button>
                </form>
            </div>
            <h1 class="bg-info text-center rounded w-75">Faculty: <p
                    class="text-danger"><c:out value="${requestScope.faculty.name}"/></p></h1>
        </div>
        <div class="container-fluid d-flex flex-column rounded">
            <table class="table table-info rounded mt-4">
                <thead>
                <tr>
                    <th class="text-center" scope="col">Id</th>
                    <th class="text-center" scope="col">Student Name</th>
                    <th class="text-center" scope="col">Student Surname</th>
                    <th class="text-center" scope="col">Action buttons</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${requestScope.faculty.students}">
                    <tr>
                        <th class="text-center" scope="row"><c:out value="${student.markBookId}"/></th>
                        <td class="text-center"><c:out value="${student.name}"/> </td>
                        <td class="text-center"><c:out value="${student.surname}"/></td>
                        <td class="d-flex justify-content-center">
                            <form action="student-servlet" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="studentNameSurname"
                                       value="${student.markBookId} ${student.faculty}">
                                <button class="btn btn-success" type="submit">
                                    Get <c:out value="${student.name}"/> info
                                </button>
                            </form>
                            <form action="faculty-servlet" method="post" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="studentMarkBookId"
                                       value="${student.markBookId}">
                                <input type="text" style="display: none;" name="studentFaculty"
                                       value="${student.faculty}">
                                <input type="text" style="display: none" name="actionType" value="Delete">
                                <button class="btn btn-danger" type="submit">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                        <path fill-rule="evenodd"
                                              d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                    </svg>
                                </button>
                            </form>
                            <form action="student-servlet" class="d-flex flex-row justify-content-center">
                                <input type="text" style="display: none;" name="studentNameSurname"
                                       value="${student.markBookId} ${student.faculty}">
                                <input type="text" style="display: none" name="actionTypeToLookAt" value="Edit">
                                <button class="btn btn-dark" type="submit">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-pen" viewBox="0 0 16 16">
                                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                                    </svg>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div style="display: ${requestScope.get("operation") == null ? "block" : "none"}">
                <div class="d-flex flex-column w-100" id="addStudentContainer">
                    <button id="addStudentButton" class="btn btn-primary" data-status="inactive">Add new student
                    </button>
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
    addStudentForm.setAttribute("action", "faculty-servlet");
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

    const addStudentInvisibleFacultyInput = document.createElement("input");
    addStudentInvisibleFacultyInput.setAttribute("name", "studentToCreateFaculty");
    addStudentInvisibleFacultyInput.setAttribute("value", "${requestScope.get("faculty").name}");
    addStudentInvisibleFacultyInput.style.display = "none";

    const buttonWrapper = document.createElement("div");
    buttonWrapper.setAttribute("class", "d-flex justify-content-center w-100 mt-3");

    const addStudentSubmitButton = document.createElement("input");
    addStudentSubmitButton.setAttribute("class", "btn btn-success w-25");
    addStudentSubmitButton.setAttribute("type", "submit");
    addStudentSubmitButton.setAttribute("name", "actionType");
    addStudentSubmitButton.setAttribute("value", "Create");

    buttonWrapper.append(addStudentSubmitButton);
    addStudentForm.append(addStudentNameInput, addStudentSurnameInput, addStudentMarkBookIdInput, addStudentAverageMarkInput, addStudentInvisibleFacultyInput, buttonWrapper);
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
