package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.model.Book;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manage-books")
public class ManageBooksServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    Connection conn = null;
    List<Book> bookList = new ArrayList<>();
    try {
      conn = ConnectionUtil.getConnection();
      String query = "SELECT * FROM book";
      PreparedStatement pstmt = conn.prepareStatement(query);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        int bookId = rs.getInt("id");
        String name = rs.getString("name");
        String author = rs.getString("author");
        String department = rs.getString("category");
        int quantity = rs.getInt("quantity");
        Book book = new Book(bookId, name, author, department, quantity);
        bookList.add(book);
      }
      request.setAttribute("bookList", bookList);
      request.getRequestDispatcher("ManageBooks.jsp").forward(request, response);
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionUtil.closeConnection(conn);
    }
  }

}
