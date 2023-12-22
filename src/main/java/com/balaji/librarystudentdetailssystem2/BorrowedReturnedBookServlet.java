package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.model.Transaction;
import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/borrowed-returned-book")
public class BorrowedReturnedBookServlet extends javax.servlet.http.HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Connection conn = null;
    List<Transaction> transactionList = new ArrayList<>();
    try {
      conn = ConnectionUtil.getConnection();
      String query = "SELECT * FROM transaction";
      java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
      java.sql.ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        int transactionId = rs.getInt("id");
        String bookName = rs.getString("book_name");
        String studentName = rs.getString("student_name");
        String type = rs.getString("type");
        String date = rs.getString("date");
        Transaction transaction = new Transaction(transactionId, bookName, studentName, type, date);
        transactionList.add(transaction);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      ConnectionUtil.closeConnection(conn);
    }
    request.setAttribute("transactionList", transactionList);
    request.getRequestDispatcher("BorrowOrReturnBook.jsp").forward(request, response);
  }

}
