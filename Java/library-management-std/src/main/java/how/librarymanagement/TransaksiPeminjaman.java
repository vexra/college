/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package how.librarymanagement;

import java.time.LocalDateTime;

/**
 *
 * @author user
 */
public class TransaksiPeminjaman {
    private AnggotaPerpustakaan peminjam;
    private Buku buku;
    private LocalDateTime tanggal;
    private String durasiPeminjaman;

    public TransaksiPeminjaman(AnggotaPerpustakaan peminjam, Buku buku, String durasiPeminjaman) {
        this.peminjam = peminjam;
        this.buku = buku;
        this.tanggal = LocalDateTime.now();
        this.durasiPeminjaman = durasiPeminjaman;
    }

    public AnggotaPerpustakaan getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(AnggotaPerpustakaan peminjam) {
        this.peminjam = peminjam;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public String getDurasiPeminjaman() {
        return durasiPeminjaman;
    }

    public void setDurasiPeminjaman(String durasiPeminjaman) {
        this.durasiPeminjaman = durasiPeminjaman;
    }
    
}
