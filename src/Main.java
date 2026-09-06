/**
 * Main class untuk mensimulasikan alur sistem perpustakaan sederhana
 * yang merelasikan Member, Buku, dan GenreBuku.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULASI SISTEM PERPUSTAKAAN ===\n");

        // 1. Data dummy GenreBuku
        GenreBuku fiksi = new GenreBuku("G01", "Fiksi", "Cerita rekaan/imajinatif");
        GenreBuku sains = new GenreBuku("G02", "Sains", "Buku ilmu pengetahuan populer");

        // 2. Data dummy Buku, masing-masing terhubung ke satu GenreBuku
        Buku buku1 = new Buku("B01", "Laskar Pelangi", "Andrea Hirata", 2005, fiksi);
        Buku buku2 = new Buku("B02", "Sapiens", "Yuval Noah Harari", 2011, sains);
        Buku buku3 = new Buku("B03", "Bumi Manusia", "Pramoedya Ananta Toer", 1980, fiksi);

        // 3. Data dummy Member
        Member member1 = new Member("M01", "Fatir", "fatir@example.com");
        Member member2 = new Member("M02", "Dinda", "dinda@example.com");

        System.out.println("-- Daftar Buku Awal --");
        System.out.println(buku1);
        System.out.println(buku2);
        System.out.println(buku3);

        System.out.println("\n-- Proses Peminjaman --");
        member1.pinjamBuku(buku1);
        member1.pinjamBuku(buku2);
        member2.pinjamBuku(buku3);
        member2.pinjamBuku(buku1); // akan gagal, buku1 sudah dipinjam member1

        System.out.println("\n-- Status Buku Setelah Peminjaman --");
        System.out.println(buku1);
        System.out.println(buku2);
        System.out.println(buku3);

        System.out.println();
        member1.tampilkanBukuDipinjam();
        System.out.println();
        member2.tampilkanBukuDipinjam();

        System.out.println("\n-- Proses Pengembalian --");
        member1.kembalikanBuku(buku1);

        System.out.println("\n-- Buku1 Dipinjam Ulang oleh Member2 --");
        member2.pinjamBuku(buku1);

        System.out.println("\n-- Status Akhir --");
        System.out.println(buku1);
        System.out.println();
        member1.tampilkanBukuDipinjam();
        System.out.println();
        member2.tampilkanBukuDipinjam();
    }
}
