package com.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    // These lines tell the program exactly where to look
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/dbBooks";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = conn.createStatement();

            // This is the SQL command to pull your books
            result = statement.executeQuery("SELECT * FROM tblBooks");

            while (result.next()) {
                String author = (String) result.getObject(2);
                String title = (String) result.getObject(3);
                System.out.println(author + " : " + title);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}