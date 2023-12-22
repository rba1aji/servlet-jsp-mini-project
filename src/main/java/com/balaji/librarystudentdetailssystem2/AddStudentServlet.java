package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String department = request.getParameter("department");

    Connection conn = null;
    try {
      conn = ConnectionUtil.getConnection();
      String query = "INSERT INTO student (name, email, department) VALUES (?, ?, ?)";
      PreparedStatement pstmt = conn.prepareStatement(query);
      pstmt.setString(1, name);
      pstmt.setString(2, email);
      pstmt.setString(3, department);
      int rowsInserted = pstmt.executeUpdate();
      request.setAttribute("message", "Student added successfully");
      request.getRequestDispatcher("success.jsp").forward(request, response);
    } catch (Exception ex) {
      ex.printStackTrace();
      response.sendRedirect("error.jsp");
    } finally {
      ConnectionUtil.closeConnection(conn);
    }
  }

}
