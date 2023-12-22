<%@ page import="com.balaji.librarystudentdetailssystem2.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #ffffed;
            color: #333;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        .container {
            width: 80%;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #007bff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:nth-child(odd) {
            background-color: #ffffff;
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button-container a {
            display: inline-block;
            padding: 10px 20px;
            margin: 0 10px;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            background-color: #007bff;
            transition: background-color 0.3s ease;
        }

        .button-container a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Manage Books</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Category</th>
            <th>Available Copies</th>
        </tr>
        <%
            // get bookList from request and display table
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            for (Book book : bookList) {
        %>
        <tr>
            <td><%= book.getId() %>
            </td>
            <td><%= book.getName() %>
            </td>
            <td><%= book.getAuthor() %>
            </td>
            <td><%= book.getCategory() %>
            </td>
            <td><%= book.getQuantity() %>
            </td>
        </tr>
        <% } %>

    </table>
    <div class="button-container">
        <a href="AddNewBook.jsp">Add New Book</a>
        <a href="index.jsp">Go Home</a>
    </div>
</div>
</body>
</html>
