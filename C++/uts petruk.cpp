#include <iostream>
#include <string>

using namespace std;

class Toko {
private:
    string nama_produk = "";
    long long harga = 0;
    string id_produk = "";
    long long produk_terjual = 0;
    long long stok = 0;
public:
    Toko(string name, long long price, long long quantity) {
        this->nama_produk = name;
        this->harga = price;
        this->stok = quantity;
        this->id_produk = name.substr(0, 3);
    }

    void setNamaProduk(string newName) {
        this->nama_produk = newName;
    }

    void setHarga(long long newHarga) {
        this->harga = newHarga;
    }

    void setStok(long long newStok) {
        this->stok = newStok;
    }

    string getNamaProduk() {
        return this->nama_produk;
    }

    long long getHarga() {
        return this->harga;
    }

    long long getStok() {
        return this->stok;
    }

    void jual(long long sold) {
        this->produk_terjual += sold;
        this->stok -= sold;
    }

    void restok(long long newStock) {
        this->stok += newStock;
    }

    void createId(string name) {
        this->id_produk = name.substr(0, 3);
    }

    void printData() {
        cout << "Nama Produk\t: " << this->nama_produk << endl;
        cout << "Harga\t\t: Rp " << this->harga << endl;
        cout << "ID Produk\t: " << this->id_produk << endl;
        cout << "Produk Terjual\t: " << this->produk_terjual << endl;
        cout << "Stok\t\t: " << this->stok << endl;
    }


};

int main()
{
    char nama_produk[] = "Sabun";
    Toko p1(nama_produk, 10000, 10);
    p1.restok(10);
    p1.createId(nama_produk);
    p1.jual(5);
    p1.printData();
}