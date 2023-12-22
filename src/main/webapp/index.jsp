<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Library Management System</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #ffffed;
      margin: 0;
      padding: 0;
      background-size: cover;
      background-position: center;
      background-repeat: no-repeat;
      height: 100vh;
    }

    .container {
      width: 80%;
      margin: 20px auto;
    }

    .header {
      background-color: #333;
      color: white;
      padding: 20px;
      text-align: center;
    }

    .options {
      display: flex;
      justify-content: space-around;
      margin-top: 50px;
    }

    .option {
      width: 30%;
      padding: 20px;
      text-align: center;
      background-color: #007bff;
      border-radius: 5px;
      color: white !important;
    }

    .option:hover {
      background-color: #ccc;
      cursor: pointer;
    }
    a{
      color: white;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="header">
    <h1>Welcome to Library Student Profile Management System</h1>
  </div>
  <div class="options">
    <div class="option">
      <a href="AddStudent.jsp">Add Student</a>
    </div>
    <div class="option">
      <a href="view-students">View Students</a>
    </div>
  </div>
  <div class="options">
    <div class="option">
      <a href="manage-books">Manage Books</a>
    </div>
    <div class="option">
      <a href="borrowed-returned-book">Borrow/Return Books</a>
    </div>
  </div>
  <div class="options">
    <div class="option">
      <a href="view-book-reviews">Book Reviews</a>
    </div>
  </div>
</div>
</body>
</html>
