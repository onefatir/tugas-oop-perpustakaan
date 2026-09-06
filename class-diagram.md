# Class Diagram - Sistem Perpustakaan

```mermaid
classDiagram
    class GenreBuku {
        -String idGenre
        -String namaGenre
        -String deskripsi
        +getIdGenre() String
        +getNamaGenre() String
        +getDeskripsi() String
    }

    class Buku {
        -String idBuku
        -String judul
        -String penulis
        -int tahunTerbit
        -GenreBuku genre
        -StatusBuku status
        -Member peminjamSaatIni
        +getIdBuku() String
        +getJudul() String
        +getStatus() StatusBuku
        +tandaiDipinjam(Member) void
        +tandaiTersedia() void
    }

    class Member {
        -String idMember
        -String nama
        -String email
        -List~Buku~ daftarBukuDipinjam
        +pinjamBuku(Buku) void
        +kembalikanBuku(Buku) void
        +tampilkanBukuDipinjam() void
    }

    class StatusBuku {
        <<enumeration>>
        TERSEDIA
        DIPINJAM
    }

    GenreBuku "1" --o "many" Buku : mengklasifikasikan
    Member "1" --> "0..many" Buku : meminjam
    Buku --> StatusBuku : memiliki
```

**Penjelasan relasi:**
- **GenreBuku – Buku** (Agregasi, 1 ke banyak): satu genre dapat dimiliki oleh banyak buku, dan genre tetap bisa berdiri sendiri walau belum ada buku yang memakainya.
- **Member – Buku** (Asosiasi, 1 ke banyak): satu member dapat meminjam banyak buku sekaligus, tetapi satu buku hanya bisa dipinjam oleh satu member pada satu waktu (dilacak lewat atribut `peminjamSaatIni` di kelas `Buku`).
- **Buku – StatusBuku**: setiap buku memiliki status `TERSEDIA` atau `DIPINJAM` yang berubah lewat method `tandaiDipinjam()` / `tandaiTersedia()`.
