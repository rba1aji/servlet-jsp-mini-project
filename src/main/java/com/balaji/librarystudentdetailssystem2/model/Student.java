package com.balaji.librarystudentdetailssystem2.model;

public class Student {
  private int id;
  private String name;
  private String email;
  private String department;
  private int booksTaken;

  public Student() {
  }

  public Student(int id, String name, String email, String department) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.department = department;
    this.booksTaken = 0;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public int getBooksTaken() {
    return booksTaken;
  }

  public void setBooksTaken(int booksTaken) {
    this.booksTaken = booksTaken;
  }
}
