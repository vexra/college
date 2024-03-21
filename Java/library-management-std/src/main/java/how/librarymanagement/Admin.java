/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package how.librarymanagement;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author user
 */
public class Admin {
    private String id;
    private String nama;
    
    private ArrayList<Buku> daftarBuku;
    private ArrayList<AnggotaPerpustakaan> daftarAnggota;
    private ArrayList<TransaksiPeminjaman> daftarPeminjaman;
    private ArrayList<TransaksiPengembalian> daftarPengembalian;

    public Admin(String nama, ArrayList<Buku> daftarBuku, ArrayList<AnggotaPerpustakaan> daftarAnggota, ArrayList<TransaksiPeminjaman> daftarPeminjaman, ArrayList<TransaksiPengembalian> daftarPengembalian) {
        this.id = UUID.randomUUID().toString();
        this.nama = nama;
        this.daftarBuku = daftarBuku;
        this.daftarAnggota = daftarAnggota;
        this.daftarPeminjaman = daftarPeminjaman;
        this.daftarPengembalian = daftarPengembalian;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    public void setDaftarBuku(ArrayList<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public ArrayList<AnggotaPerpustakaan> getDaftarAnggota() {
        return daftarAnggota;
    }

    public void setDaftarAnggota(ArrayList<AnggotaPerpustakaan> daftarAnggota) {
        this.daftarAnggota = daftarAnggota;
    }

    public ArrayList<TransaksiPeminjaman> getDaftarPeminjaman() {
        return daftarPeminjaman;
    }

    public void setDaftarPeminjaman(ArrayList<TransaksiPeminjaman> daftarPeminjaman) {
        this.daftarPeminjaman = daftarPeminjaman;
    }

    public ArrayList<TransaksiPengembalian> getDaftarPengembalian() {
        return daftarPengembalian;
    }

    public void setDaftarPengembalian(ArrayList<TransaksiPengembalian> daftarPengembalian) {
        this.daftarPengembalian = daftarPengembalian;
    }
    
    
    
    public void addBook(Buku buku) {
        daftarBuku.add(buku);
    }
    
    public void removeBook(Buku buku) {
        daftarBuku.remove(buku);
    }

    public void addMember(AnggotaPerpustakaan newMember) {
        daftarAnggota.add(newMember);
    }
    
    public void removeMember(AnggotaPerpustakaan member) {
        daftarAnggota.remove(member);
    }
    
    public boolean findMember(String nomorAnggota, String nama) {
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            if (anggota.getNomorAnggota().equalsIgnoreCase(nomorAnggota) && anggota.getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        
        return false;
    }

    public boolean findBuku(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return true;
            }
        }

        return false;
    }
    
    public AnggotaPerpustakaan getAnggotaByNomorAnggota(String nomorAnggota) {
        for (AnggotaPerpustakaan anggota : daftarAnggota) {
            if (anggota.getNomorAnggota().equalsIgnoreCase(nomorAnggota)) {
                return anggota;
            }
        }

        return new AnggotaPerpustakaan("", "", "");
    }
    
    public Buku getBukuByJudul(String judul) {
        for (Buku buku : daftarBuku) {
            if (buku.getJudul().equalsIgnoreCase(judul)) {
                return buku;
            }
        }

        return new Buku("", "", "", 0);
    }
    
    public void tampilkanDaftarBuku() {
        System.out.println(">>> Daftar Buku <<<");
       
        for (Buku buku : daftarBuku) {
            System.out.println("#" + buku.getIsbn() + " " + buku.getJudul() + " - " + buku.getPengarang() + ". Stock = " + buku.getStock());            
        }
    }
    
    public void pinjamBuku(AnggotaPerpustakaan peminjam, String judul, String durasiPeminjaman) {
        Buku buku = getBukuByJudul(judul);
        
        if (buku.getIsbn().isEmpty()) {
            System.out.println("Maaf buku tidak ada");
        } else {
            if (buku.checkAvailability()) {
                buku.reduceStock(1);
                TransaksiPeminjaman temp = new TransaksiPeminjaman(peminjam, buku, durasiPeminjaman);
                daftarPeminjaman.add(temp);
                
                System.out.println("Berhasil meminjam buku " + judul);
            } else {
                System.out.println("Maaf buku " + judul + " habis");
            }
        }
    }
    
    public void kembalikanBuku(AnggotaPerpustakaan pengembali, String judul) {
        Buku buku = getBukuByJudul(judul);
        
        if (buku.getIsbn().isEmpty()) {
            System.out.println("Maaf buku tidak ada");
        } else {
            buku.addStock(1);
            TransaksiPengembalian temp = new TransaksiPengembalian(pengembali, buku);
            daftarPengembalian.add(temp);
            
            System.out.println("Berhasil mengembalikan buku " + judul);
        }
    }
}
