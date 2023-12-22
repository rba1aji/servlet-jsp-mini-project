<%@ page import="com.balaji.librarystudentdetailssystem2.model.Transaction" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: balaji
  Date: 22/12/23
  Time: 3:32 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow/Return Book</title>
</head>
<body>
<style>
    body {
        background-color: lightcyan;
        display: flex;
        align-items: center;
        flex-direction: row;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px;
    }

    h1 {
        color: blue;
    }

    input[type=text] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
    }

</style>
<div style="width: 50%; padding-left: 10%">
    <%--    get List<Transaction> from request and display as a table--%>
    <h2>Book Borrow/Return History</h2>
    <table>
        <tr>
            <th>Book Name</th>
            <th>Student Name</th>
            <th>Status</th>
            <td>Date</td>
        </tr>
        <%
            List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactionList");
            if (transactions != null)
                for (Transaction transaction : transactions) {
        %>
        <tr>
            <td><%=transaction.getBookName()%>
            </td>
            <td><%=transaction.getStudentName()%>
            </td>
            <td><%=transaction.getType()%>
            </td>
            <td><%=transaction.getDate()%>
            </td>
        </tr>
        <%
                }
        %>
    </table>
</div>

<div style="
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
">
    <h1>Borrow Book Form</h1>
    <form action="add-book-transaction" method="post">
        <table>
            <tr>
                <td>Book Name</td>
                <td><input type="text" name="bookName"></td>
            </tr>
            <tr>
                <td>Student Name</td>
                <td><input type="text" name="studentName"></td>
            </tr>
            <input type="hidden" name="type" value="borrow">
            <tr>
                <td><input type="submit" value="Borrow Book"></td>
            </tr>
        </table>
    </form>
    <h1>Return Book Form</h1>
    <form action="add-book-transaction" method="post">
        <table>
            <tr>
                <td>Book Name</td>
                <td><input type="text" name="bookName"></td>
            </tr>
            <tr>
                <td>Student Name</td>
                <td><input type="text" name="studentName"></td>
            </tr>
            <input type="hidden" name="type" value="return">
            <tr>
                <td><input type="submit" value="Return Book"></td>
            </tr>
        </table>

    </form>
    <form action="index.jsp" method="get">
        <input type="submit" value="Home" style="background: #007bff"/>
    </form>
</div>
</body>
</html>
