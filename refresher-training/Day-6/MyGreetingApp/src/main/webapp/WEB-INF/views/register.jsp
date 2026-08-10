<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>My Greetings App - Register</title>

    <style>

        body {
            font-family: Arial;
            background-color: #f4f4f4;
        }

        .container {
            width: 400px;
            margin: 80px auto;
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
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Create Account</h2>

    <%
        String error =
                (String) request.getAttribute("error");
    %>

    <% if (error != null) { %>

        <p class="error">
            <%= error %>
        </p>

    <% } %>


    <form
            action="${pageContext.request.contextPath}/register"
            method="post">

        <label>Name</label>

        <input
                type="text"
                name="name"
                required
        >

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
            Register
        </button>

    </form>

    <p>

        Already have an account?

        <a href="${pageContext.request.contextPath}/login">
            Login
        </a>

    </p>

</div>

</body>

</html>