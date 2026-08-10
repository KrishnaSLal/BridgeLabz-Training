<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>My Greetings App - Login</title>

    <style>

        body {
            font-family: Arial;
            background-color: #f4f4f4;
        }

        .container {
            width: 400px;
            margin: 100px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
        }

        .success {
            color: green;
        }

        a {
            text-decoration: none;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>My Greetings App</h2>

    <h3>Login</h3>

    <%
        String error =
                (String) request.getAttribute("error");

        String success =
                (String) request.getAttribute("success");
    %>

    <% if (error != null) { %>

        <p class="error">
            <%= error %>
        </p>

    <% } %>

    <% if (success != null) { %>

        <p class="success">
            <%= success %>
        </p>

    <% } %>


    <form
            action="${pageContext.request.contextPath}/login"
            method="post">

        <label>Email</label>

        <input
                type="email"
                name="email"
                required
        >

        <label>Password</label>

        <input
                type="password"
                name="password"
                required
        >

        <button type="submit">
            Login
        </button>

    </form>

    <p>
        Don't have an account?
        <a href="${pageContext.request.contextPath}/register">
            Register
        </a>
    </p>

</div>

</body>

</html>