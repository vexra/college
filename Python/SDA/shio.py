shio = ["Dragon", "Snake", "Horse", "Sheep", "Monkey", "Rooster", "Dog", "Pig", "Rat", "Ox", "Tiger", "Rabbit"]
year = int(input("Masukan tahun lahir kamu: "))

print(f"Tahun {year} memiliki shio {shio[(year-8) % 12]}")