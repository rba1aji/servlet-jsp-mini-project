package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/add-new-book")
public class AddNewBookServlet extends HttpServlet {


  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    try {

      String name = request.getParameter("name");
      String author = request.getParameter("author");
      String category = request.getParameter("category");
      int quantity = Integer.parseInt(request.getParameter("quantity"));
      Connection conn = null;
      try {
        conn = ConnectionUtil.getConnection();
        String query = "INSERT INTO book(name, author, category, quantity) VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, name);
        pstmt.setString(2, author);
        pstmt.setString(3, category);
        pstmt.setInt(4, quantity);
        pstmt.executeUpdate();
      } catch (SQLException ex) {
        ex.printStackTrace();
      } finally {
        ConnectionUtil.closeConnection(conn);
      }

      request.setAttribute("message", "Book added successfully");
      request.getRequestDispatcher("success.jsp").forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
}
