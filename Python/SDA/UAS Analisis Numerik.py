def linear_interpolation(x1, y1, x2, y2, x3):
    """
    Fungsi untuk melakukan interpolasi linear.

    Parameter:
    x1 (float): Nilai x pertama.
    y1 (float): Nilai y pertama.
    x2 (float): Nilai x kedua.
    y2 (float): Nilai y kedua.
    x3 (float): Nilai x yang ingin diinterpolasi.

    Return:
    float: Hasil interpolasi linear dari nilai x3.
    """

    # Menghitung persentase jarak antara x3 dan x1 terhadap jarak antara x2 dan x1
    interpolation_factor = (x3 - x1) / (x2 - x1)

    # Melakukan interpolasi linear
    interpolated_value = y1 + interpolation_factor * (y2 - y1)

    return interpolated_value

def quadratic_interpolation(x1, y1, x2, y2, x3):
    """
    Fungsi untuk melakukan interpolasi kuadratik.

    Parameter:
    x1 (float): Nilai x pertama.
    y1 (float): Nilai y pertama.
    x2 (float): Nilai x kedua.
    y2 (float): Nilai y kedua.
    x3 (float): Nilai x yang ingin diinterpolasi.

    Return:
    float: Hasil interpolasi kuadratik dari nilai x3 (y3).
    """

    # Menghitung koefisien a, b, c untuk persamaan kuadratik
    a = ((y2 - y1) / ((x2 - x1) * (x2 - x3))) - ((y1 - y2) / ((x1 - x2) * (x1 - x3)))
    b = ((y2 - y1) / (x2 - x1)) - a * (x1 + x2)
    c = y1 - (a * x1**2) - (b * x1)

    # Menghitung nilai y3 menggunakan interpolasi kuadratik
    y3 = a * x3**2 + b * x3 + c

    return y3


if __name__ == '__main__':
    # Penyelesaian problem pertama dengan menggunakan metode interpolasi
    # Diketahui :
    # Titik 1: Hari ke - 1 ((x1 = 1)) dengan jumlah pengunjung 200 ((y1 = 200))
    # Titik 2: Hari ke - 2 ((x2 = 2)) dengan jumlah pengunjung 400 ((y2 = 400))
    # Titik 3: Hari ke - 3 ((x3 = 3)) dengan jumlah pengunjung y3 = ?

    # Menggunakan fungsi linear_interpolation untuk mencari nilai y3 atau jumlah pengunjung pada hari ke 3

    x1 = 1
    y1 = 200
    x2 = 2
    y2 = 400
    x3 = 3
    y3 = linear_interpolation(x1, y1, x2, y2, x3)

    print("Jumlah pengunjung pada hari ke 3 adalah", y3)

    #######################################################################################################################################

    # Penyelesaian problem kedua dengan menggunakan metode interpolasi
    # Diketahui :
    # Titik 1: Hari ke − 1 ((x1) )dengan jumlah pengguna 3,6 juta ((y1) )
    # Titik 2: Hari ke − 3 ((x2) )dengan jumlah pengguna 3,8 juta ((y2) )
    # Titik 3: Hari ke − 5 ((x3) ) yang ingin dihitung ((y3) )

    # Menggunakan fungsi quadratic_interpolation untuk mencari nilai y3 atau jumlah pengguna pada hari ke 5

    x1 = 1
    y1 = 3600000
    x2 = 3
    y2 = 3800000
    x3 = 5
    y3 = quadratic_interpolation(x1, y1, x2, y2, x3)

    print("Jumlah pengguna pada hari ke 5 adalah", y3)
