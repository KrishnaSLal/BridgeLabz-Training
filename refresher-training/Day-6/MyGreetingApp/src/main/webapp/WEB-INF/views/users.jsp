<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib
        prefix="c"
        uri="jakarta.tags.core"
%>

<!DOCTYPE html>
<html>

<head>

    <title>User Management</title>

    <style>

        body {
            font-family: Arial;
            background-color: #f4f4f4;
        }

        .container {
            width: 900px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }

        th,
        td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        .edit {
            color: white;
            background-color: #ffc107;
            padding: 7px 12px;
            text-decoration: none;
            border-radius: 4px;
        }

        .delete {
            color: white;
            background-color: #dc3545;
            padding: 7px 12px;
            text-decoration: none;
            border-radius: 4px;
        }

        .back {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>User Management</h2>

    <table>

        <thead>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>

        </thead>


        <tbody>

        <c:forEach
                var="user"
                items="${users}">

            <tr>

                <td>
                    ${user.id}
                </td>

                <td>
                    ${user.name}
                </td>

                <td>
                    ${user.email}
                </td>

                <td>

                    <a
                            class="edit"
                            href="${pageContext.request.contextPath}/edit/${user.id}">
                        Edit
                    </a>

                    <a
                            class="delete"
                            href="${pageContext.request.contextPath}/delete/${user.id}"
                            onclick="return confirm('Are you sure you want to delete this user?');">
                        Delete
                    </a>

                </td>

            </tr>

        </c:forEach>

        </tbody>

    </table>


    <a
            class="back"
            href="${pageContext.request.contextPath}/greeting">
        Back to Greeting
    </a>

</div>

</body>

</html>