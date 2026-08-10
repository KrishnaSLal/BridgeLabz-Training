<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>My Greetings App</title>

    <style>

        body {
            font-family: Arial;
            text-align: center;
            background-color: #f4f4f4;
        }

        .container {
            width: 650px;
            margin: 100px auto;
            padding: 40px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        a {
            display: inline-block;
            margin: 10px;
            padding: 12px 25px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
        }

        .logout {
            background-color: #dc3545;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>
        Hello, ${user.name}! 👋
    </h1>

    <p>
        Welcome to My Greetings App.
    </p>

    <p>
        You are logged in as:
        <strong>${user.email}</strong>
    </p>


    <a href="${pageContext.request.contextPath}/users">
        View Users
    </a>


    <a
            class="logout"
            href="${pageContext.request.contextPath}/logout">
        Logout
    </a>

</div>

</body>

</html>