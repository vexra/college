package Nomor5;

import java.util.ArrayList;
import java.util.List;

public class Penulis {
    private List<Buku> daftarBuku = new ArrayList<Buku>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}
