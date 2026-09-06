/**
 * Class Buku merepresentasikan entitas Buku dalam sistem perpustakaan.
 * Relasi:
 *  - Buku memiliki (agregasi) satu GenreBuku -> banyak Buku bisa berbagi satu GenreBuku.
 *  - Buku dapat direferensikan oleh satu Member sebagai peminjam saat ini (asosiasi).
 */
public class Buku {
    private String idBuku;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private GenreBuku genre;
    private StatusBuku status;
    private Member peminjamSaatIni; // null jika buku tidak sedang dipinjam siapa pun

    public Buku(String idBuku, String judul, String penulis, int tahunTerbit, GenreBuku genre) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
        this.genre = genre;
        this.status = StatusBuku.TERSEDIA;
        this.peminjamSaatIni = null;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public GenreBuku getGenre() {
        return genre;
    }

    public StatusBuku getStatus() {
        return status;
    }

    public Member getPeminjamSaatIni() {
        return peminjamSaatIni;
    }

    /**
     * Menandai buku sebagai dipinjam oleh member tertentu.
     * Dipanggil oleh Member.pinjamBuku(), bukan dipanggil langsung dari luar.
     */
    void tandaiDipinjam(Member peminjam) {
        this.status = StatusBuku.DIPINJAM;
        this.peminjamSaatIni = peminjam;
    }

    /**
     * Menandai buku sebagai tersedia kembali (setelah dikembalikan).
     */
    void tandaiTersedia() {
        this.status = StatusBuku.TERSEDIA;
        this.peminjamSaatIni = null;
    }

    @Override
    public String toString() {
        String infoPeminjam = (status == StatusBuku.DIPINJAM && peminjamSaatIni != null)
                ? ", dipinjam oleh: " + peminjamSaatIni.getNama()
                : "";
        return String.format("[%s] \"%s\" - %s (%d) | Genre: %s | Status: %s%s",
                idBuku, judul, penulis, tahunTerbit, genre.getNamaGenre(), status, infoPeminjam);
    }
}
