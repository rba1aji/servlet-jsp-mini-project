package com.balaji.librarystudentdetailssystem2.model;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
  private int id;
  private String bookName;
  private String studentName;
  private String type;
  private String date;

  public Transaction() {
  }

  public Transaction(int id, String bookName, String studentName, String type) {
    this.id = id;
    this.bookName = bookName;
    this.studentName = studentName;
    this.type = type;
    this.date = new Timestamp(new Date().getTime()).toString();
  }

  public Transaction(int id, String bookName, String studentName, String type, String date) {
    this.id = id;
    this.bookName = bookName;
    this.studentName = studentName;
    this.type = type;
    this.date = date;
  }

  public int getId() {
    return id;
  }

  public String getBookName() {
    return bookName;
  }

  public String getStudentName() {
    return studentName;
  }

  public String getType() {
    return type;
  }

  public String getDate() {
    return date;
  }
}
