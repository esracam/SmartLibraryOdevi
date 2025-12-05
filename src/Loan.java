public class Loan {
    private int id;
    private int bookId;
    private int studentId;
    private String dateBorrowed;
    private String dateReturned;

    public Loan(int id, int bookId, int studentId, String dateBorrowed, String dateReturned) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.dateBorrowed = dateBorrowed;
        this.dateReturned = dateReturned;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | KitapID: " + bookId + " | ÖğrenciID: " + studentId +
                " | Alış: " + dateBorrowed + " | Teslim: " + (dateReturned == null ? "Teslim Edilmedi" : dateReturned);
    }
}