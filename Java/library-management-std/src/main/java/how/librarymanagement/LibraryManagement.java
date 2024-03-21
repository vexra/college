/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package how.librarymanagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class LibraryManagement {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Buku> daftarBuku = new ArrayList<Buku>();
        daftarBuku.add(new Buku("11111", "Titanic", "Aldo", 3));
        daftarBuku.add(new Buku("11112", "Nature", "Anta", 1));
        daftarBuku.add(new Buku("11113", "Forest", "Alka", 2));
        
        ArrayList<AnggotaPerpustakaan> daftarAnggota = new ArrayList<AnggotaPerpustakaan>();
        daftarAnggota.add(new AnggotaPerpustakaan("001", "Aldo", "Tanjung karang"));
        daftarAnggota.add(new AnggotaPerpustakaan("002", "Anta", "Tangerang"));
        daftarAnggota.add(new AnggotaPerpustakaan("003", "Alka", "Kemiling"));
        
        ArrayList<TransaksiPeminjaman> daftarTransaksiPeminjaman = new ArrayList<TransaksiPeminjaman>();
        ArrayList<TransaksiPengembalian> daftarTransaksiPengembalian = new ArrayList<TransaksiPengembalian>();
        
        Admin admin = new Admin("admin", daftarBuku, daftarAnggota, daftarTransaksiPeminjaman, daftarTransaksiPengembalian);
        AnggotaPerpustakaan user;
        
        System.out.println(">>> Selamat Datang pada Management Library <<<");
        System.out.println("Untuk melanjutkan silakan login terlebih dahulu");
        
        while (true) {    
            System.out.print("Masukan nomor anggota : ");
            String nomorAnggota = input.nextLine();
            
            System.out.print("Masukan nama anda : ");
            String nama = input.nextLine();
            
            boolean check = admin.findMember(nomorAnggota, nama);
            
            if (check) {
                user = admin.getAnggotaByNomorAnggota(nomorAnggota);
                System.out.println("Login Sukses");
                System.out.println("Selamat datang " + user.getNama());
                break;
            } else {
                System.out.println("Anggota tidak ditemukan");
                System.out.println("Silahkan coba lagi");
               
            }
        }
        
        OUTER:
        while (true) {
            printMenu();
            System.out.print("Silahkan pilih menu : ");
            String menu = input.nextLine();
            
            switch (menu) {
                case "1":
                    System.out.print("Silahkan masukkan judul buku yang ingin dicari : ");
                    String judul = input.nextLine();
                    
                    if (admin.findBuku(judul)) {
                        Buku buku = admin.getBukuByJudul(judul);
                        
                        if (buku.checkAvailability()) {
                            System.out.println("Buku " + judul + " Tersedia");
                        } else {
                            System.out.println("Maaf buku " + judul + " tidak tersedia");
                        }
                        
                    } else {
                        System.out.println("Maaf buku " + judul + " tidak ada");
                    }
                    break;
                    
                case "2":
                    admin.tampilkanDaftarBuku();
                    break;
                case "3":
                    System.out.print("Silahkan masukkan judul buku yang ingin dipinjam : ");
                    judul = input.nextLine();
                    System.out.print("Silahkan masukkan durasi peminjaman buku : ");
                    String durasi = input.nextLine();
                    
                    admin.pinjamBuku(user, judul, durasi);
                    
                    break;
                case "4":
                    System.out.print("Silahkan masukkan judul buku yang ingin dikembalikan : ");
                    judul = input.nextLine();
                    admin.kembalikanBuku(user, judul);
                    
                    break;
                case "5":
                    break OUTER;
                default:
                    System.out.println("Menu tidak tersedia!");
                    break;
            }
        }
        
        input.close();
    }
    
    public static void printMenu() {
        System.out.println("Daftar Menu");
        System.out.println("1. Cari Buku");
        System.out.println("2. Tampilkan Daftar Buku");
        System.out.println("3. Pinjam Buku");
        System.out.println("4. Kembalikan Buku");
        System.out.println("5. Keluar");
    }
}
