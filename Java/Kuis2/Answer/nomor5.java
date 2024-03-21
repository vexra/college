package Answer;

import java.util.ArrayList;
import java.util.List;

class Buku {
    private String judul;
    private int tahunTerbit;
    private String penerbit;
    private String isbn;

    Buku(String judul, int tahunTerbit, String penerbit, String isbn) {
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.penerbit = penerbit;
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}


class Penulis {
    private List<Buku> daftarBuku = new ArrayList<Buku>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}
