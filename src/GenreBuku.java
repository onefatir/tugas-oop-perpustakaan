/**
 * Class GenreBuku merepresentasikan kategori/genre dari sebuah Buku.
 * Relasi: satu GenreBuku dapat dimiliki oleh banyak Buku (one-to-many / agregasi),
 * sehingga GenreBuku dapat berdiri sendiri walau tidak ada Buku yang mereferensikannya.
 */

public class GenreBuku {
    private String idGenre;
    private String namaGenre;
    private String deskripsi;

    public GenreBuku(String idGenre, String namaGenre, String deskripsi) {
        this.idGenre = idGenre;
        this.namaGenre = namaGenre;
        this.deskripsi = deskripsi;
    }

    public String getIdGenre() {
        return idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    @Override
    public String toString() {
        return namaGenre + " (" + idGenre + ")";
    }
}