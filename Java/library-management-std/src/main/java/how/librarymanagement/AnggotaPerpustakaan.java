/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package how.librarymanagement;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class AnggotaPerpustakaan {
    private String nomorAnggota;
    private String nama;
    private String alamat;
    private ArrayList<TransaksiPeminjaman> sejarahPeminjaman;
    
    public AnggotaPerpustakaan(String nomorAnggota, String nama, String alamat) {
        this.nomorAnggota = nomorAnggota;
        this.nama = nama;
        this.alamat = alamat;
        this.sejarahPeminjaman = new ArrayList<TransaksiPeminjaman>();
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<TransaksiPeminjaman> getSejarahPeminjaman() {
        return sejarahPeminjaman;
    }

    public void setSejarahPeminjaman(ArrayList<TransaksiPeminjaman> sejarahPeminjaman) {
        this.sejarahPeminjaman = sejarahPeminjaman;
    }
}
