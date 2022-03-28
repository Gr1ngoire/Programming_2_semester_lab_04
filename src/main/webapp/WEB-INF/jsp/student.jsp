<%--
  Created by IntelliJ IDEA.
  User: gring
  Date: 26.03.2022
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Student Page</title>
</head>
<body class="d-flex flex-column justify-content-center">
<div class="container-fluid d-flex flex-row justify-content-around mt-5">
    <h1>${requestScope.get("student").name == null ? "No student content, sorry....." : ""}</h1>
    <div class="d-flex align-items-center">
        <form action="faculty-servlet">
            <input type="text" style="display: none;" name="facultyName" value="${requestScope.student.faculty}">
            <button type="submit"
                    class="btn btn-outline-primary">
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
                Go back to the faculty
            </button>
        </form>
    </div>
    <div style="display: ${requestScope.get("student").name == null ? "none" : "block"};" class="bg-info w-50 mt-5 rounded">
        <div class="container-fluid d-flex flex-row rounded text-danger">
            <div class="container-fluid d-flex flex-column justify-content-between rounded mt-3 mb-3">
                <h3>Name:</h3>
                <h3>Surname:</h3>
                <h3>Faculty:</h3>
                <h3>Mark book №:</h3>
                <h3>Average mark:</h3>
            </div>
            <div class="container-fluid d-flex flex-column rounded mt-3 mb-3">
                <h3>${requestScope.student.name}</h3>
                <h3>${requestScope.student.surname}</h3>
                <h3>${requestScope.student.faculty}</h3>
                <h3> ${requestScope.student.markBookId}</h3>
                <h3> ${requestScope.student.averageMark}</h3>
            </div>
        </div>
    </div>
</div>
</body>
</html>
