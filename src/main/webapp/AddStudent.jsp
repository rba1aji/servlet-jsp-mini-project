<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            color: white;
            background-color: #ffffed;
        }

        .container {
            width: 60%;
            margin: 100px auto;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.6);
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(255, 255, 255, 0.3);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-group input[type="text"],
        .form-group input[type="submit"] {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .form-group input[type="submit"] {
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        .navigation {
            text-align: center;
            margin-top: 20px;
        }

        .navigation a {
            padding: 8px 20px;
            margin: 0 10px;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            background-color: #007bff;
            transition: background-color 0.3s ease;
        }

        .navigation a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add Student</h2>
    <form action="add-student" method="post">
        <div class="form-group">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="email">Email Address:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="department">Department:</label>
            <input type="text" id="department" name="department" required>
        </div>

        <div class="form-group">
            <input type="submit" value="Add Student">
        </div>
    </form>

    <div class="navigation">
        <a href="index.jsp">Got to Home</a>
        <a href="view-students">View Students</a>
        <!-- Other navigation links can be added here -->
    </div>
</div>
</body>
</html>
