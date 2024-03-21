package Praktikum7;

import java.util.ArrayList;

public class Mahasiswa {
    public String npm;
    public String nama;

    private double nilaiTugas;
    private double nilaiUas;
    private double nilaiUts;
    private double NA;

    public Mahasiswa (String nama, String npm, double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nama = nama;
        this.npm = npm;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public void printData(String jurusan) {
        System.out.println("NPM : " + this.npm);
        System.out.println("Nama : " + this.nama);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Nilai tugas : " + this.nilaiTugas);
        System.out.println("Nilai UTS : " + this.nilaiUts);
        System.out.println("Nilai UAS : " + this.nilaiUas);
        System.out.println("Nilai akhir : " + this.NA);
    }

    public void printData() {
        System.out.println("NPM : " + this.npm);
        System.out.println("Nama : " + this.nama);
        System.out.println("Nilai tugas : " + this.nilaiTugas);
        System.out.println("Nilai UTS : " + this.nilaiUts);
        System.out.println("Nilai UAS : " + this.nilaiUas);
        System.out.println("Nilai akhir : " + this.NA);
    }

    public int sumValue(int x, int y) {
        return x + y;
    }

    public void hitungNA() {
        this.NA = (this.nilaiTugas * 0.3) + (this.nilaiUts * 0.35) + (this.nilaiUas * 0.35);
    }

    public void hitungNA(double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.NA = (nilaiTugas * 0.3) + (nilaiUts * 0.35) + (nilaiUas * 0.35);
    }

    public void hitungNA(String pesan) {
        System.out.println("Nilai tidak valid");
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return this.nama;
    }

    public void hitungTugas(ArrayList<Double> arr) {
        double sum = 0;

        for (int i = 0; i < arr.size(); ++i) {
            sum += arr.get(i);
        }

        this.nilaiTugas = sum / arr.size();
    }

    public double getNilaiTugas() {
        return this.nilaiTugas;
    }
}