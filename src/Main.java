import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Önce veritabanını ve tabloları hazırla
        Database.createNewDatabase();

        Scanner scanner = new Scanner(System.in);

        // 2. Depo (Repository) nesnelerini oluştur
        BookRepository bookRepo = new BookRepository();
        StudentRepository studentRepo = new StudentRepository();
        LoanRepository loanRepo = new LoanRepository();

        // 3. Menü Döngüsü
        while (true) {
            System.out.println("\n=== 📚 SMART LIBRARY SYSTEM ===");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Öğrenci Ekle");
            System.out.println("4. Öğrencileri Listele");
            System.out.println("5. Kitap Ödünç Ver");
            System.out.println("6. Ödünç Listesini Görüntüle");
            System.out.println("7. Kitap Geri Teslim Al");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Hata önleyici (buffer temizleme)

            switch (choice) {
                case 1:
                    System.out.print("Kitap Adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Yıl: ");
                    int year = scanner.nextInt();
                    bookRepo.add(new Book(title, author, year));
                    break;
                case 2:
                    System.out.println("-- KİTAP LİSTESİ --");
                    for (Book b : bookRepo.getAll()) {
                        System.out.println(b);
                    }
                    break;
                case 3:
                    System.out.print("Öğrenci Adı: ");
                    String name = scanner.nextLine();
                    System.out.print("Bölüm: ");
                    String dept = scanner.nextLine();
                    studentRepo.add(new Student(name, dept));
                    break;
                case 4:
                    System.out.println("-- ÖĞRENCİ LİSTESİ --");
                    for (Student s : studentRepo.getAll()) {
                        System.out.println(s);
                    }
                    break;
                case 5:
                    System.out.print("Öğrenci ID: ");
                    int sId = scanner.nextInt();
                    System.out.print("Kitap ID: ");
                    int bId = scanner.nextInt();
                    System.out.print("Tarih (GG.AA.YYYY): ");
                    String date = scanner.next();
                    loanRepo.borrowBook(bId, sId, date);
                    break;
                case 6:
                    System.out.println("-- ÖDÜNÇ GEÇMİŞİ --");
                    for (Loan l : loanRepo.getAll()) {
                        System.out.println(l);
                    }
                    break;
                case 7:
                    System.out.print("İade Edilen Kitap ID: ");
                    int returnBookId = scanner.nextInt();
                    System.out.print("İade Tarihi (GG.AA.YYYY): ");
                    String returnDate = scanner.next();
                    loanRepo.returnBook(returnBookId, returnDate);
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor... Güle güle! 👋");
                    return;
                default:
                    System.out.println("❌ Geçersiz seçim! Tekrar dene.");
            }
        }
    }
}