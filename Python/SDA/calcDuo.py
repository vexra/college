while True:
    print("\nSilakan pilih menu operasi yang ingin digunakan: ")
    print("1. Penjumlahan")
    print("2. Perkalian")
    print("3. Pengurangan")
    print("4. Pembagian")
    print("5. Tekan X untuk keluar dari program\n")
    menu = input("Silakan masukan menu: ")

    if menu == "X":
        print("\n>>> Terima kasih. Sampai Jumpa <<<")
        break
    
    menu = int(menu)

    if menu < 1 or menu > 4:
        print("Menu tidak valid")
        continue
    
    while True:
        ival1 = int(input("\nMasukan bilangan pertama: "))
        ival2 = int(input("Masukan bilangan kedua: "))

        if menu == 1:
            print(f"{ival1} + {ival2} = {ival1 + ival2}")
        elif menu == 2:
            print(f"{ival1} * {ival2} = {ival1 * ival2}")
        elif menu == 3:
            print(f"{ival1} - {ival2} = {ival1 - ival2}")
        else:
            print(f"{ival1} / {ival2} = {ival1 / ival2}")

        cmd = input("\nAnda ingin menghitung lagi? (Y/T) : ")

        if cmd == "T":
            break
        
