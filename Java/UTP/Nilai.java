package UTP;

public class Nilai {
    public String mataKuliah;
    public double nilaiTugas;
    public double nilaiUts;
    public double nilaiUas;

    public Nilai() {
        this.mataKuliah = null;
        this.nilaiTugas = 0;
        this.nilaiUts = 0;
        this.nilaiUas = 0;
    }

    public Nilai(String matkul) {
        this.mataKuliah = matkul;
        this.nilaiTugas = this.nilaiUas = this.nilaiUts = 0;
    }

    public Nilai(String matkul, double a, double b, double c) {
        this.mataKuliah = matkul;
        this.nilaiTugas = a;
        this.nilaiUts = b;
        this.nilaiUas = c;
    }

    public String mutuNilai() {
        double NA = this.hitungNA();
        if (NA >= 76) {
            return "A";
        } else if (NA >= 71 && NA <= 75) {
            return "B+";
        } else if (NA >= 66 && NA <= 72) {
            return "B";
        } else if (NA >= 61 && NA <= 65) {
            return "C+";
        } else if (NA >= 56 && NA <= 60) {
            return "C";
        } else if (NA >= 50 && NA <= 55) {
            return "D";
        } else {
            return "E";
        }
    }

    public double hitungNA() {
        return this.nilaiTugas * 0.3 + this.nilaiUts * 0.3 + this.nilaiUas * 0.4;
    }

    public void setMataKuliah(String matkul) {
        this.mataKuliah = matkul;
    }

    public void setNilaiTugas(double tugas) {
        this.nilaiTugas = tugas;
    }

    public void setNilaiUts(double uts) {
        this.nilaiUts = uts;
    }

    public void setNilaiUas(double uas) {
        this.nilaiUas = uas;
    }

    public String getMataKuliah() {
        return this.mataKuliah;
    }

    public double getNilaiTugas() {
        return this.nilaiTugas;
    }

    public double getNilaiUts() {
        return this.nilaiUts;
    }

    public double getNilaiUas() {
        return this.nilaiUas;
    }
}
