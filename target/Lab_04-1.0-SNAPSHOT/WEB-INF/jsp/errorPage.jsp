<%--
  Created by IntelliJ IDEA.
  User: gring
  Date: 25.03.2022
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Error Page</title>
</head>
<body class="d-flex flex-row justify-content-center bg-danger" style="border: none;">
    <div class="d-flex align-items-top">
        <form action="university-servlet">
            <button
                    class="btn btn-outline-warning mt-5">
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
    <div class="card mt-5 mb-5 " style="border: none;">
        <img class="card-img-top" src="https://i.redd.it/34kcp87vt5e11.jpg" alt="Card image cap">
        <div class="card-body d-flex flex-column justify-content-center bg-danger">
            <h1 class="card-title text-center text-warning">Error occurred:</h1>
            <p class="card-text text-center text-warning" style="font-size: 2rem;">${requestScope.error}</p>
        </div>
    </div>
</body>
</html>
