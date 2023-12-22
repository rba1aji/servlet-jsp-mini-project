package com.balaji.librarystudentdetailssystem2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-book-transaction")
public class AddBookTransactionServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    try {
      String bookName = request.getParameter("bookName");
      String studentName = request.getParameter("studentName");
      String type = request.getParameter("type");
      java.sql.Connection conn = null;
      try {
        conn = com.balaji.librarystudentdetailssystem2.util.ConnectionUtil.getConnection();
        String query = "INSERT INTO transaction(book_name, student_name, type, date) VALUES(?, ?, ?,? )";
        java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, bookName);
        pstmt.setString(2, studentName);
        pstmt.setString(3, type);
        pstmt.setString(4, new java.sql.Timestamp(new java.util.Date().getTime()).toString());
        pstmt.executeUpdate();
      } catch (java.sql.SQLException ex) {
        ex.printStackTrace();
      } finally {
        com.balaji.librarystudentdetailssystem2.util.ConnectionUtil.closeConnection(conn);
      }
      request.setAttribute("message", "Book " + type + " Done!");
      request.getRequestDispatcher("success.jsp").forward(request, response);
    } catch (javax.servlet.ServletException | java.io.IOException e) {
      e.printStackTrace();
    }
  }
}
