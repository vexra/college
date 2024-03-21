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
public class TransaksiPengembalian {
    private AnggotaPerpustakaan peminjam;
    private Buku buku;
    private LocalDateTime tanggal;

    public TransaksiPengembalian(AnggotaPerpustakaan peminjam, Buku buku) {
        this.peminjam = peminjam;
        this.buku = buku;
        this.tanggal = LocalDateTime.now();
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
    
        
}
