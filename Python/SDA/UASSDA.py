"""
Ujian Akhir Praktikum - Structured Programming
Restaurant Management
Contributor
Cakrawangsa Veda Alkautsar (2217051004)
Muhammad Heru (2217051071)
M.Febri Ardiyan Saputra (2217051019)
"""

import copy

daftarMenu = ["Ayam Geprek original", "Ayam Geprek level 1", "Ayam Geprek level 2", "Ayam Geprek level 3", "Ayam Geprek level 4", "Ayam Geprek level 5", "Es Teh", "Es Alpukat", "Air Putih", "Kopi", "Susu"]
harga_menu = [10, 12, 15, 18, 20, 25, 3, 5, 1, 2, 4]

class Order:
    def __init__(self, nama = "", pesanan = []):
        self.nama = nama
        self.pesanan = pesanan

    def __len__(self):
        return len(self.pesanan)
    
    def size(self):
        return len(self.pesanan)

    def empty(self):
        return len(self.pesanan) == 0

    def printOrder(self):
        print(f"Pesanan oleh {self.nama}: ")

        for item in self.pesanan:
            print(f"\t- {daftarMenu[item-1]}")
        print("")

    def removeOrder(self, nomorPesanan):
        del self.pesanan[nomorPesanan]

    def calculateTotalPrice(self):
        total_price = 0
        for item in self.pesanan:
            
            harga_menu = [10, 12, 15, 18, 20, 25, 3, 5, 1, 2, 4]
            total_price += harga_menu[item-1]
        return total_price
    
    def processPayment(self):
        print("Pesanan:")
        self.printOrder()
        total_price = self.calculateTotalPrice()
        print("Total harga: $", total_price)
    
        while True:
            try:
                payment = float(input("Jumlah pembayaran: $"))
                if payment >= total_price:
                    change = payment - total_price
                    print(f"Kembalian: $ {change}\n")
                    break
                else:
                    print("Jumlah pembayaran tidak cukup.")
            except ValueError:
                print("Input tidak valid. Silakan coba lagi.")

class Queue:
    def __init__(self):
        self.items = []

    def empty(self):
        return len(self.items) == 0
    
    def enqeueu(self, data):
        self.items.append(data)

    def dequeue(self):
        if not self.empty():
            return self.items.pop(0)
        else:
            print("Antrian sedang kosong!")

    def size(self):
        return len(self.items)

    
def printMenu():
    print("Pilih Menu: ")
    print("1. Tambah Pesanan")
    print("2. Hapus Pesanan")
    print("3. Tampilkan Daftar Antrian")
    print("4. Hitung Jumlah Antrian")
    print("5. Bayar")
    print("0. Keluar\n")

if __name__ == "__main__":
    antrian = Queue()
    daftarAntrian = dict()
    
    while True:
        printMenu()
        menu = int(input("Pilih menu: "))

        if menu == 1:
            print("\n========= Menu =========")
            for i in range(len(daftarMenu)):
                print(f"{i+1}. {daftarMenu[i]}")

            nama = str(input("\n>>> Masukkan nama customer: "))
            pesanan = []

            while True:
                tmp = int(input(">>> Masukkan menu makanan atau 0 untuk keluar: "))
                if tmp == 0:
                    break
                else:
                    pesanan.append(tmp)

            print("")

            if len(pesanan) != 0:
                antrian.enqeueu(nama)
                daftarAntrian[nama] = Order(nama, pesanan)

        elif menu == 2:
            nama = str(input("\n>>> Masukkan nama customer: "))
            order = daftarAntrian[nama]

            for i in range(order.size()):
                print(f"{i+1}. {daftarMenu[order.pesanan[i]-1]}")

            nomor = int(input("\n>>> Masukkan pesanan yang ingin dihapus: "))

            print(f">>> Pesanan {daftarMenu[daftarAntrian[nama].pesanan[nomor-1]-1]} oleh {nama} telah dibatalkan!\n")
            daftarAntrian[nama].removeOrder(nomor-1)

        elif menu == 3:
            antrianTmp = copy.deepcopy(antrian)
            i = 1
            while not antrianTmp.empty():
                nama = antrianTmp.dequeue()
                print(f"#{i} ", end="")
                daftarAntrian[nama].printOrder()
                i += 1
                

        elif menu == 4:
            print(f">>> Jumlah antrian saat ini adalah: {antrian.size()}\n")

        elif menu == 5:
            customer = antrian.dequeue()
            daftarAntrian[customer].processPayment()
            daftarAntrian.pop(customer)

            
        elif menu == 0:
            print("\n>>> Terimakasih telah berlangganan <<<")
            break

        else:
            print(">>> Menu tidak tersedia! Silakan coba lagi")


