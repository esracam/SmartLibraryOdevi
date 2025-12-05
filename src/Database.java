import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // Veritabanı dosyasının adı
    private static final String URL = "jdbc:sqlite:SmartLibrary.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            // Bağlantıyı oluştur
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Veritabanı bağlantı hatası: " + e.getMessage());
        }
        return conn;
    }

    public static void createNewDatabase() {
        // Tablo oluşturma sorguları
        String booksTable = "CREATE TABLE IF NOT EXISTS books (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " title TEXT,\n"
                + " author TEXT,\n"
                + " year INTEGER\n"
                + ");";

        String studentsTable = "CREATE TABLE IF NOT EXISTS students (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT,\n"
                + " department TEXT\n"
                + ");";

        String loansTable = "CREATE TABLE IF NOT EXISTS loans (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " bookId INTEGER,\n"
                + " studentId INTEGER,\n"
                + " dateBorrowed TEXT,\n"
                + " dateReturned TEXT\n"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            // Tabloları çalıştır
            stmt.execute(booksTable);
            stmt.execute(studentsTable);
            stmt.execute(loansTable);
            System.out.println("Veritabanı ve tablolar başarıyla kontrol edildi/oluşturuldu.");
        } catch (SQLException e) {
            System.out.println("Tablo oluşturma hatası: " + e.getMessage());
        }
    }
}