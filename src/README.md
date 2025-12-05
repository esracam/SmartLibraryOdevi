SmartLibrary - Kütüphane Yönetim Sistemi

Bu projeyi *Nesne Yönelimli Programlama (OOP)* dersi için vize projesi olarak hazırladım. Proje, basit bir kütüphanedeki kitap alışverişini takip etmeyi sağlayan bir konsol uygulamasıdır.

- Proje Hakkında
Bu uygulamayı geliştirirken Java dili ve veritabanı olarak SQLite kullandım. Verilerin program kapansa bile kaybolmaması için yerel bir veritabanı dosyası (`.db`) üzerinde çalışıyor.

- Benden istenen şu teknik şartları projede uyguladım:
* *OOP Prensipleri:* Sınıf yapısı, nesne ilişkileri.
* *JDBC:* Java'nın veritabanı ile konuşması için.
* *Katmanlı Yapı:* Kodları karıştırmamak için Repository (Depo) sınıfları kullandım.

- Neler Yapılabilir?
Uygulamayı çalıştırdığınızda karşınıza çıkan menüden şunları yapabilirsiniz:

1.  *Kitap İşlemleri:* Kütüphaneye yeni kitap ekleyip listeyebilirsiniz.
2.  *Öğrenci İşlemleri:* Sisteme öğrenci kaydedip görebilirsiniz.
3.  *Ödünç Verme:* Hangi öğrenci hangi kitabı ne zaman aldı kaydedebilirsiniz. (Stok kontrolü yapar, kitap başkasındaysa vermez).
4.  *İade Alma:* Kitap geri geldiğinde sisteme işleyebilirsiniz.

- Kurulum ve Çalıştırma

Projeyi çalıştırmak için:
1.  Bilgisayarınızda Java (JDK) yüklü olmalı.
2.  Projeyi IntelliJ IDEA ile açmanız tavsiye edilir.
3.  Projenin çalışması için `sqlite-jdbc` kütüphanesinin ekli olması gerekiyor.
4.  `Main.java` dosyasını açıp çalıştırabilirsiniz.

*Not: Program ilk kez çalıştığında `SmartLibrary.db` dosyasını otomatik olarak kendisi oluşturacaktır.*

---
Hazırlayan: Esra Çam
Bölüm/No: Bilgisayar Programcılığı - 20240108003