import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public void add(Book book) {
        String sql = "INSERT INTO books(title, author, year) VALUES(?,?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getYear());
            pstmt.executeUpdate();
            System.out.println("✅ Kitap eklendi.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}