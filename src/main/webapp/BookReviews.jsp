<%@ page import="com.balaji.librarystudentdetailssystem2.model.BookReview" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Reviews</title>
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

        .review {
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
            margin-bottom: 20px;
        }

        .review h3 {
            margin-bottom: 5px;
        }

        .review p {
            margin-top: 5px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group textarea {
            width: 100%;
            height: 100px;
            border-radius: 5px;
            border: 1px solid #ccc;
            resize: vertical;
        }

        .form-group input[type="submit"] {
            width: auto;
            padding: 8px 20px;
            border-radius: 5px;
            border: none;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Book Reviews</h2>

    <!-- get List<BookReview> from request and display as cards -->
    <%
        List<BookReview> reviews = (List<BookReview>) request.getAttribute("bookReviewList");
        if (reviews != null) {
            for (BookReview review : reviews) {
    %>
    <div class="review">
        <h3><%= review.getBookName() %>
        </h3>
        <p>
            <%= review.getReviewerName() %> says: <%= review.getReview() %>
        </p>
    </div>
    <%
            }
        }
    %>

    <!-- Review Submission Form -->
    <form action="add-review" method="post">
        <div class="form-group">
            <label for="reviewerName">Your Name:</label>
            <input type="text" id="reviewerName" name="reviewerName" required>
        </div>
        <div class="form-group">
            <label for="bookName">Book Name:</label>
            <input type="text" id="bookName" name="bookName" required>
        </div>
        <div class="form-group">
            <label for="review">Your Review:</label>
            <textarea id="review" name="review" required></textarea>
        </div>
        <div class="form-group">
            <input type="submit" value="Submit Review">
        </div>
    </form>
</div>
</body>
</html>
