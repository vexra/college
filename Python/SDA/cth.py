from datetime import datetime, date

from win10toast import ToastNotifier
import time 

class JadwalKuliah:
    def __init__(self, nama_mata_kuliah, ruangan, waktu_mulai, waktu_selesai):
        self.nama_mata_kuliah = nama_mata_kuliah
        self.ruangan = ruangan
        self.waktu_mulai = waktu_mulai
        self.waktu_selesai = waktu_selesai
        

class PengingatJadwal:
    def __init__(self):
        self.jadwal = []

    def tambah_jadwal(self, jadwal_kuliah):
        self.jadwal.append(jadwal_kuliah)


    def tampilkan_jadwal(self):
        for i, jadwal_kuliah in enumerate(self.jadwal):
            print(f"{i+1}. {jadwal_kuliah.nama_mata_kuliah} ({jadwal_kuliah.ruangan}) {jadwal_kuliah.waktu_mulai.strftime('%H:%M')} - {jadwal_kuliah.waktu_selesai.strftime('%H:%M')}")


    def hapus_jadwal(self):
        self.tampilkan_jadwal()
        while True:
            try:
                indeks_hapus = int(input("Pilih nomor jadwal yang ingin dihapus: "))
                if indeks_hapus < 1 or indeks_hapus > len(self.jadwal):
                    raise ValueError("Nomor jadwal tidak valid")
                self.jadwal.pop(indeks_hapus - 1)
                print("Jadwal kuliah berhasil dihapus")
                break
            except ValueError as e:
                print(str(e))
                continue

    def tampilkan_jadwal_terdekat(self):
        if not self.jadwal:
            print("Anda belum memasukkan jadwal apapun")
            return

        indeks_jadwal_terdekat = cari_jadwal_terdekat(self)
        jadwal_terdekat = self.jadwal[indeks_jadwal_terdekat]
        waktu_saat_ini = datetime.now().time()

        print(f"Jadwal kuliah terdekat:")
        print(f"{jadwal_terdekat.nama_mata_kuliah} ({jadwal_terdekat.ruangan}) {jadwal_terdekat.waktu_mulai.strftime('%H:%M')} - {jadwal_terdekat.waktu_selesai.strftime('%H:%M')}")
        print(f"Saat ini jam {waktu_saat_ini.strftime('%H:%M')}")
        
        
def cari_jadwal_terdekat(pengingat_jadwal, indeks=0):
    if len(pengingat_jadwal.jadwal) == 0:
        return None

    if indeks == len(pengingat_jadwal.jadwal) - 1:
        return indeks

    indeks_selanjutnya = cari_jadwal_terdekat(pengingat_jadwal, indeks + 1)
    waktu_saat_ini = datetime.now().time()
    waktu_mulai_kuliah_saat_ini = pengingat_jadwal.jadwal[indeks].waktu_mulai

    waktu_mulai_kuliah_selanjutnya = pengingat_jadwal.jadwal[indeks_selanjutnya].waktu_mulai
    selisih_waktu_saat_ini_dan_saat_mulai_kuliah_saat_ini = (datetime.combine(date.min, waktu_mulai_kuliah_saat_ini) - datetime.combine(date.min, waktu_saat_ini)).total_seconds()
    selisih_waktu_saat_ini_dan_saat_mulai_kuliah_selanjutnya = (datetime.combine(date.min, waktu_mulai_kuliah_selanjutnya) - datetime.combine(date.min, waktu_saat_ini)).total_seconds()

    if selisih_waktu_saat_ini_dan_saat_mulai_kuliah_saat_ini < selisih_waktu_saat_ini_dan_saat_mulai_kuliah_selanjutnya:
        return indeks
    else:
        return indeks_selanjutnya



def main():
    pengingat_jadwal = PengingatJadwal()

    while True:
        print("\n=== Menu ===")
        print("1. Tambah Jadwal Kuliah")
        print("2. Tampilkan Jadwal Kuliah")
        print("3. Tampilkan Jadwal Kuliah Terdekat")
        print("4. Hapus Jadwal Kuliah")
        print("5. Buat Notifikasi Jadwal")
        print("6. Keluar")

        pilihan = input("Pilih menu: ")

        if pilihan == "1":
            nama_mata_kuliah = input("Masukkan nama mata kuliah: ")
            ruangan = input("Masukkan ruangan: ")
            waktu_mulai = datetime.strptime(input("Masukkan waktu mulai (HH:MM): "), "%H:%M").time()
            waktu_selesai = datetime.strptime(input("Masukkan waktu selesai (HH:MM): "), "%H:%M").time()

            jadwal_kuliah = JadwalKuliah(nama_mata_kuliah, ruangan, waktu_mulai, waktu_selesai)
            pengingat_jadwal.tambah_jadwal(jadwal_kuliah)
            print("Jadwal kuliah berhasil ditambahkan!")

        elif pilihan == "2":
            pengingat_jadwal.tampilkan_jadwal()

        elif pilihan == "3":
            if not pengingat_jadwal.jadwal:
                print("Anda belum memasukkan jadwal apapun")
            else:
                indeks_jadwal_terdekat = cari_jadwal_terdekat(pengingat_jadwal)
                jadwal_terdekat = pengingat_jadwal.jadwal[indeks_jadwal_terdekat]
                waktu_saat_ini = datetime.now().time()

                print(f"Jadwal kuliah terdekat:")
                print(f"{jadwal_terdekat.nama_mata_kuliah} ({jadwal_terdekat.ruangan}) {jadwal_terdekat.waktu_mulai.strftime('%H:%M')} - {jadwal_terdekat.waktu_selesai.strftime('%H:%M')}")
                print(f"Saat ini jam {waktu_saat_ini.strftime('%H:%M')}")
        
        elif pilihan == "4":
            pengingat_jadwal.hapus_jadwal()

        elif pilihan == "5" :
            toaster = ToastNotifier()

            Toasttitle = input("\nMasukan Nama Mata Kuliah : ")
            msg = input("Catatan : ")
            minutes = float(input("Set Timer untuk menampilkan Notifikasi : "))

            seconds = minutes * 60
            print("\nnotifikasi berhasil dibuat\n")
            

            time.sleep(seconds)
            toaster.show_toast(Toasttitle, msg, duration=10, threaded=True)

            while toaster.notification_active:
                time.sleep(0.1)
                
        elif pilihan == "6":
            print("Terima kasih telah menggunakan program ini!")
            break

        else:
            print("Pilihan tidak valid, silahkan coba lagi!")

if __name__ == '__main__':
    main()