package com.balaji.librarystudentdetailssystem2.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

  public static Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName("org.postgresql.Driver");
      conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentlibrarydb", "postgres", "postgres");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return conn;
  }

  public static void closeConnection(Connection conn) {
    try {
      if (conn != null) conn.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
