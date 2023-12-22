package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.model.Student;
import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/view-students")
public class ViewStudentsServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<Student> studentList = new ArrayList<>();
    Connection conn = null;

    try {
      conn = ConnectionUtil.getConnection();
      String query = "SELECT * FROM student";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int studentId = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String department = rs.getString("department");
        Student student = new Student(studentId, name, email, department);
        studentList.add(student);
      }

      request.setAttribute("studentList", studentList);
      RequestDispatcher dispatcher = request.getRequestDispatcher("ViewStudents.jsp");
      dispatcher.forward(request, response);
    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      ConnectionUtil.closeConnection(conn);
    }
  }
}
