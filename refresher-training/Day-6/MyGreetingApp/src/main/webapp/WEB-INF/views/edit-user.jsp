<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Edit User</title>

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
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        a {
            display: block;
            margin-top: 15px;
            text-align: center;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Edit User</h2>

    <form
            action="${pageContext.request.contextPath}/update"
            method="post">

        <input
                type="hidden"
                name="id"
                value="${user.id}"
        >

        <label>Name</label>

        <input
                type="text"
                name="name"
                value="${user.name}"
                required
        >

        <label>Email</label>

        <input
                type="email"
                name="email"
                value="${user.email}"
                required
        >

        <label>Password</label>

        <input
                type="password"
                name="password"
                value="${user.password}"
                required
        >

        <button type="submit">
            Update User
        </button>

    </form>

    <a href="${pageContext.request.contextPath}/users">
        Cancel
    </a>

</div>

</body>

</html>