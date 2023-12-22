package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/add-review")
public class AddBookReviewServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    try {

      String bookName = request.getParameter("bookName");
      String reviewerName = request.getParameter("reviewerName");
      String review = request.getParameter("review");
      Connection conn = null;
      try {
        conn = ConnectionUtil.getConnection();
        String query = "INSERT INTO book_review(book_name, reviewer_name, review) VALUES(?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, bookName);
        pstmt.setString(2, reviewerName);
        pstmt.setString(3, review);
        pstmt.executeUpdate();
      } catch (SQLException ex) {
        ex.printStackTrace();
      } finally {
        ConnectionUtil.closeConnection(conn);
      }

      request.setAttribute("message", "Review added successfully");
      request.getRequestDispatcher("success.jsp").forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
}