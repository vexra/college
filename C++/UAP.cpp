/* Ujian Akhir Praktikum - Structured Programming
 * Restaurant Management
 * Contributor
 * Cakrawangsa Veda Alkautsar (2217051004)
 * Muhammad Heru (2217051071)
 * M.Febri Ardiyan Saputra (2217051019)
 */
#include <algorithm>
#include <map>
#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

vector<string> listMakanan = {"Ayam Geprek original", "Ayam Geprek level 1", "Ayam Geprek level 2", "Ayam Geprek level 3", "Ayam Geprek level 4", "Ayam Geprek level 5", "Es Teh", "Es Alpukat", "Air Putih", "Kopi", "Susu"};

void merge(vector<int> &arr, int left, int mid, int right)
{
    int n1 = mid - left + 1;
    int n2 = right - mid;

    // Buat vektor sementara untuk menyimpan bagian kiri dan kanan
    vector<int> L(n1);
    vector<int> R(n2);

    // Salin elemen-elemen dari vektor utama ke vektor sementara
    for (int i = 0; i < n1; ++i)
    {
        L[i] = arr[left + i];
    }
    for (int j = 0; j < n2; ++j)
    {
        R[j] = arr[mid + 1 + j];
    }

    // Gabungkan kedua bagian secara terurut
    int i = 0;    // Indeks untuk bagian kiri
    int j = 0;    // Indeks untuk bagian kanan
    int k = left; // Indeks untuk vektor utama

    while (i < n1 && j < n2)
    {
        if (L[i] <= R[j])
        {
            arr[k] = L[i];
            ++i;
        }
        else
        {
            arr[k] = R[j];
            ++j;
        }
        ++k;
    }

    // Salin elemen yang tersisa dari bagian kiri jika ada
    while (i < n1)
    {
        arr[k] = L[i];
        ++i;
        ++k;
    }

    // Salin elemen yang tersisa dari bagian kanan jika ada
    while (j < n2)
    {
        arr[k] = R[j];
        ++j;
        ++k;
    }
}

// Fungsi rekursif untuk melakukan Merge Sort pada vektor
void mergeSort(vector<int> &arr, int left, int right)
{
    if (left < right)
    {
        int mid = left + (right - left) / 2;

        // Memanggil mergeSort rekursif untuk bagian kiri dan kanan
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Menggabungkan kedua bagian yang terurut
        merge(arr, left, mid, right);
    }
}

class Order
{
private:
    string name;
    vector<int> listOfOrders;

    void sortOrders()
    {
        mergeSort(listOfOrders, 0, listOfOrders.size() - 1);
    }

public:
    Order() {}

    Order(const string &str) : name(str) {}

    void setName(const string &newName)
    {
        this->name = newName;
    }

    void setListOfOrders(const vector<int> &ls)
    {
        this->listOfOrders = ls;
    }

    string getName()
    {
        return this->name;
    }

    vector<int> getListOfOrders()
    {
        return this->listOfOrders;
    }

    int countOrder()
    {
        return this->listOfOrders.size();
    }

    void addOrder(int newOrder)
    {
        this->listOfOrders.push_back(newOrder);
    }

    bool cancelOrder(int orderName)
    {
        vector<int>::iterator it = find(this->listOfOrders.begin(), this->listOfOrders.end(), orderName);

        if (it != this->listOfOrders.end())
        {
            this->listOfOrders.erase(it);
            return true;
        }

        return false;
    }

    void printOrders()
    {
        this->sortOrders();

        cout << "Daftar Pesanan Oleh " << this->name << endl;
        for (size_t i = 0, n = this->listOfOrders.size(); i < n; ++i)
        {
            int index = this->listOfOrders[i] - 1;
            cout << i + 1 << ". " << listMakanan[index] << endl;
        }

        cout << endl;
    }
};

void printFoodMenu()
{
    cout << "==== Menu ====" << endl;

    for (int i = 0; i < listMakanan.size(); ++i)
    {
        cout << i + 1 << ". " << listMakanan[i] << endl;
    }
}

void printMenu()
{
    cout << "Pilih Menu: " << endl;
    cout << "1. Tambah Pesanan" << endl;
    cout << "2. Tampilkan Daftar Antrian" << endl;
    cout << "3. Hitung Jumlah Antrian" << endl;
    cout << "0. Keluar\n" << endl;
}

int main()
{
    map<string, Order> orderMap;
    queue<string> antrian;

    string menu;
    while (true)
    {
        printMenu();
        cout << "Masukan menu: ";
        cin >> menu;

        if (menu == "1")
        {
            printFoodMenu();
            cout << endl;

            string nama;
            int food;

            cout << "Masukan nama customer: ";
            cin >> nama;

            cout << "Masukan menu makanan/minuman: ";
            cin >> food;

            if (food < 0 || food > listMakanan.size())
            {
                cout << "Menu tidak tersedia! Silakan Coba Lagi" << endl;
            }

            else if (orderMap.find(nama) != orderMap.end())
            {
                orderMap[nama].addOrder(food);
            }

            else
            {
                antrian.push(nama);
                orderMap[nama];
                orderMap[nama].setName(nama);
                orderMap[nama].addOrder(food);
            }
        }

        else if (menu == "2")
        {
            queue<string> tmp(antrian);

            while (!tmp.empty())
            {
                string customer = tmp.front();
                orderMap[customer].printOrders();

                tmp.pop();
            }
        }

        else if (menu == "3")
        {
            cout << "Jumlah antrian saat ini adalah: " << antrian.size() << endl;
        }
        else if (menu == "0")
        {
            cout << "Terimakasih telah berlangganan";
            break;
        }
        else
        {
            cout << "Menu tidak tersedia" << endl;
        }
    }
}