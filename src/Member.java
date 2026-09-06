import java.util.ArrayList;
import java.util.List;

/**
 * Class Member merepresentasikan anggota perpustakaan.
 * Relasi: satu Member dapat meminjam banyak Buku secara bersamaan (one-to-many / asosiasi),
 * dan satu Buku hanya dapat dipinjam oleh satu Member pada satu waktu.
 */
public class Member {
    private String idMember;
    private String nama;
    private String email;
    private List<Buku> daftarBukuDipinjam;

    public Member(String idMember, String nama, String email) {
        this.idMember = idMember;
        this.nama = nama;
        this.email = email;
        this.daftarBukuDipinjam = new ArrayList<>();
    }

    public String getIdMember() {
        return idMember;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public List<Buku> getDaftarBukuDipinjam() {
        return daftarBukuDipinjam;
    }

    /**
     * Member meminjam sebuah Buku. Hanya berhasil jika buku berstatus TERSEDIA.
     */
    public void pinjamBuku(Buku buku) {
        if (buku.getStatus() == StatusBuku.TERSEDIA) {
            buku.tandaiDipinjam(this);
            daftarBukuDipinjam.add(buku);
            System.out.println(nama + " berhasil meminjam buku \"" + buku.getJudul() + "\".");
        } else {
            System.out.println(nama + " GAGAL meminjam \"" + buku.getJudul()
                    + "\" karena sedang dipinjam oleh " + buku.getPeminjamSaatIni().getNama() + ".");
        }
    }

    /**
     * Member mengembalikan sebuah Buku yang sedang dipinjamnya.
     */
    public void kembalikanBuku(Buku buku) {
        if (daftarBukuDipinjam.remove(buku)) {
            buku.tandaiTersedia();
            System.out.println(nama + " mengembalikan buku \"" + buku.getJudul() + "\".");
        } else {
            System.out.println(nama + " tidak sedang meminjam buku \"" + buku.getJudul() + "\".");
        }
    }

    public void tampilkanBukuDipinjam() {
        System.out.println("Daftar buku yang dipinjam oleh " + nama + ":");
        if (daftarBukuDipinjam.isEmpty()) {
            System.out.println("  (tidak ada buku yang sedang dipinjam)");
        } else {
            for (Buku b : daftarBukuDipinjam) {
                System.out.println("  - " + b.getJudul());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", idMember, nama, email);
    }
}
