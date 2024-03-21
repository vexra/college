package UTP;

public class Mahasiswa {
    public String nama;
    public String npm;
    public Nilai nilai;

    public Mahasiswa() {
        this.nama = null;
        this.npm = null;
        this.nilai = new Nilai();
    }

    public Mahasiswa(String nama, String npm, Nilai nilai) {
        this.nama = nama;
        this.npm = npm;
        this.nilai = nilai;
    }

    public void print() {
        System.out.println("Nama : " + this.nama);
        System.out.println("NPM : " + this.npm);
        System.out.println("Mata Kuliah : " + this.nilai.mataKuliah);
        System.out.println("Nilai Tugas : " + this.nilai.nilaiTugas);
        System.out.println("Nilai UTS : " + this.nilai.nilaiUts);
        System.out.println("Nilai UAS : " + this.nilai.nilaiUas);
        System.out.println("Nilai Akhir : " + this.nilai.hitungNA());
        System.out.println("Mutu Nilai : " + this.nilai.mutuNilai());
    }
}
