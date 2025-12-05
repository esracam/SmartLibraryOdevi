import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public void add(Student student) {
        String sql = "INSERT INTO students(name, department) VALUES(?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDepartment());
            pstmt.executeUpdate();
            System.out.println("✅ Öğrenci eklendi.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
