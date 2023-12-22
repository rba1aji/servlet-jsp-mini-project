package com.balaji.librarystudentdetailssystem2.model;

public class BookReview {
  private int id;
  private String bookName;
  private String reviewerName;
  private String review;

  public BookReview() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  public String getReviewerName() {
    return reviewerName;
  }

  public void setReviewerName(String reviewerName) {
    this.reviewerName = reviewerName;
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public BookReview(int id, String bookName, String reviewerName, String review) {
    this.id = id;
    this.bookName = bookName;
    this.reviewerName = reviewerName;
    this.review = review;
  }
}
