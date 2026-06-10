// Name: Andrew Kigathi
// Student ID: 220277
// Date: 22/05/2026

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class miniprojimpl extends UnicastRemoteObject implements miniproj {
    private static final String DB_URL = System.getProperty(
            "db.url",
            "jdbc:mysql://localhost:3306/oop_miniproj?createDatabaseIfNotExist=true");
    private static final String DB_USER = System.getProperty("db.user", "root");
    private static final String DB_PASSWORD = System.getProperty("db.password", "");

    public miniprojimpl() throws RemoteException {
        super();
        initializeDatabase();
    }

    // Q1: Modified response — replace "Your Name" with your actual name
    @Override
    public String message(String text) throws RemoteException {
        return "You entered: " + text;
    }

    @Override
    public List<Student> getStudents() throws RemoteException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, course, score, email FROM student_data ORDER BY id";

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("course"),
                        resultSet.getInt("score"),
                        resultSet.getString("email")));
            }
        } catch (SQLException e) {
            throw new RemoteException("Failed to retrieve students from MySQL", e);
        }

        return students;
    }

    private void initializeDatabase() throws RemoteException {
        String createTable = """
                CREATE TABLE IF NOT EXISTS student_data (
                    id INT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    course VARCHAR(50) NOT NULL,
                    score INT NOT NULL,
                    email VARCHAR(100) NOT NULL
                )
                """;
        String insertStudent = """
                INSERT INTO student_data (id, name, course, score, email)
                VALUES (?, ?, ?, ?, ?)
                ON DUPLICATE KEY UPDATE
                    name = VALUES(name),
                    course = VALUES(course),
                    score = VALUES(score),
                    email = VALUES(email)
                """;

        try (Connection connection = getConnection();
                Statement statement = connection.createStatement();
                PreparedStatement insert = connection.prepareStatement(insertStudent)) {
            statement.executeUpdate(createTable);
            saveStudent(insert, 1, "Jackline", "BBIT", 85, "jackie@gmail.com");
            saveStudent(insert, 2, "Konni", "ICS", 95, "konni@gmail.com");
            saveStudent(insert, 3, "Pamela", "CNS", 90, "pam123@gmail.com");
        } catch (SQLException e) {
            throw new RemoteException("Failed to initialize MySQL student_data table", e);
        }
    }

    private void saveStudent(
            PreparedStatement insert,
            int id,
            String name,
            String course,
            int score,
            String email) throws SQLException {
        insert.setInt(1, id);
        insert.setString(2, name);
        insert.setString(3, course);
        insert.setInt(4, score);
        insert.setString(5, email);
        insert.executeUpdate();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
