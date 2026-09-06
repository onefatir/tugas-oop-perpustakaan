# Sistem Perpustakaan - Tugas OOP

Program Java sederhana yang mendemonstrasikan konsep Object-Oriented Programming (OOP)
dengan merelasikan tiga entitas: `Member`, `Buku`, dan `GenreBuku`.

## Struktur Kelas
- `GenreBuku` - kategori/genre sebuah buku
- `Buku` - entitas buku, terhubung ke satu `GenreBuku`
- `Member` - anggota perpustakaan yang dapat meminjam banyak `Buku`
- `StatusBuku` - enum status ketersediaan buku (TERSEDIA / DIPINJAM)
- `Main` - class utama untuk menjalankan simulasi

Detail relasi antar kelas ada di [class-diagram.md](./class-diagram.md).

## Cara Menjalankan
```bash
cd src
javac *.java
java Main
```
