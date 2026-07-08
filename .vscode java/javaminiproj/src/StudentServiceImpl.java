import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    protected StudentServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT id, name, course, score, email FROM student_data";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getInt("score"),
                    rs.getString("email")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RemoteException("Database error while fetching students: " + e.getMessage());
        }

        return students;
    }
}