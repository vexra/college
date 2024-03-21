package Nomor5;

import java.util.List;

public class main {
    public static void main(String[] args) {
        Penulis penulis = new Penulis();

        // Menambahkan buku baru
        Buku bukuBaru = new Buku("Judul Buku", 2022, "Penerbit Terbit", "ISBN123456");
        penulis.tambahBuku(bukuBaru);

        // Menampilkan informasi buku setelah penambahan
        List<Buku> daftarBuku = penulis.getDaftarBuku();
        for (Buku buku : daftarBuku) {
            System.out.println("Judul: " + buku.getJudul());
            System.out.println("Tahun Terbit: " + buku.getTahunTerbit());
            System.out.println("Penerbit: " + buku.getPenerbit());
            System.out.println("ISBN: " + buku.getISBN());
            System.out.println("--------------");
        }
    }
}
