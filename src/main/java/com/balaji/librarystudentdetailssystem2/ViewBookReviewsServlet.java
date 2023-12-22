package com.balaji.librarystudentdetailssystem2;

import com.balaji.librarystudentdetailssystem2.model.BookReview;
import com.balaji.librarystudentdetailssystem2.util.ConnectionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/view-book-reviews")
public class ViewBookReviewsServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    try {
      Connection conn = null;
      List<BookReview> bookReviewList = new ArrayList<>();
      try {
        conn = ConnectionUtil.getConnection();
        String query = "SELECT * FROM book_review";
        java.sql.PreparedStatement pstmt = conn.prepareStatement(query);
        java.sql.ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
          int bookReviewId = rs.getInt("id");
          String bookName = rs.getString("book_name");
          String reviewerName = rs.getString("reviewer_name");
          String review = rs.getString("review");
          BookReview bookReview = new BookReview(bookReviewId, bookName, reviewerName, review);
          bookReviewList.add(bookReview);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        ConnectionUtil.closeConnection(conn);
      }

      request.setAttribute("bookReviewList", bookReviewList);
      request.getRequestDispatcher("BookReviews.jsp").forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
