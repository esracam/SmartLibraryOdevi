import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {

    // Kitap şu an başkasında mı kontrolü
    public boolean isBookLoaned(int bookId) {
        String sql = "SELECT count(*) FROM loans WHERE bookId = ? AND dateReturned IS NULL";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void borrowBook(int bookId, int studentId, String date) {
        if(isBookLoaned(bookId)) {
            System.out.println("⚠️ HATA: Bu kitap şu an başkasında!");
            return;
        }
        String sql = "INSERT INTO loans(bookId, studentId, dateBorrowed) VALUES(?,?,?)";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, studentId);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            System.out.println("✅ Kitap başarıyla ödünç verildi.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(int bookId, String dateReturned) {
        String sql = "UPDATE loans SET dateReturned = ? WHERE bookId = ? AND dateReturned IS NULL";
        try (Connection conn = Database.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dateReturned);
            pstmt.setInt(2, bookId);
            int affected = pstmt.executeUpdate();
            if(affected > 0) System.out.println("✅ Kitap iade alındı.");
            else System.out.println("⚠️ İade edilecek aktif kayıt bulunamadı.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Loan> getAll() {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                loans.add(new Loan(
                        rs.getInt("id"),
                        rs.getInt("bookId"),
                        rs.getInt("studentId"),
                        rs.getString("dateBorrowed"),
                        rs.getString("dateReturned")
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return loans;
    }
}