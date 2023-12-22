<%@ page import="com.balaji.librarystudentdetailssystem2.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #ffffed;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            color: #fff;
            height: 100vh;
        }

        .container {
            width: 80%;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7);
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #fff;
        }

        th {
            background-color: #007bff;
        }

        tr:nth-child(even) {
            background-color: rgba(255, 255, 255, 0.1);
        }

        tr:nth-child(odd) {
            background-color: rgba(255, 255, 255, 0.05);
        }
    </style>
</head>
<body>
<div class="container">
    <h2>View Students</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Email</th>
            <th>Department</th>
            <th>Num of Book taken</th>
        </tr>
        </thead>
        <%
            //get List<Student> from request and display the table
            List<Student> list = (List<Student>) request.getAttribute("studentList");
            for (Student student : list) {
        %>
        <tr>
            <td><%= student.getId() %>
            </td>
            <td><%= student.getName() %>
            </td>
            <td><%= student.getEmail() %>
            </td>
            <td><%= student.getDepartment() %>
            </td>
            <td>
                <%= student.getBooksTaken()%>
            </td>
        </tr>
        <%
            }
        %>

    </table>
    <br>
</div>
</body>
</html>
