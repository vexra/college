import pandas as pd

# Fungsi yang digunakan untuk mengekstrak bilangan dari sebuah string
def parse_string_to_number(string):
    try:
        if not isinstance(string, str):
            raise TypeError("Input parameter must be a string")

        number_str = ''
        is_negative = False

        for char in string:
            if char.isdigit():
                number_str += char
            elif char == '-' and not number_str:
                is_negative = True

        if '.' in number_str:
            number_str = number_str.replace('.', '')

        number = int(number_str) if number_str else 0
        return -number if is_negative else number

    except TypeError as e:
        print(f"Error: {e}")

# fungsi yang digunakan untuk menghitung total dari soal 
def calculate_total(row):
    try:
        duration = parse_string_to_number(row['Duration'])
        discount = parse_string_to_number(row['Percentage Discount'])

        if row['Categories'] == 'PI':
            total_discount = (discount + 2) / 100 * (row['Fee'] * duration)
        else:
            total_discount = discount / 100 * (row['Fee'] * duration)

        total = row['Fee'] * duration - total_discount

        return total
    except KeyError as e:
        raise KeyError(f"Missing key in row: {e}")
    except Exception as e:
        raise Exception(f"Error in calculating total: {e}")

# Fungsi yang digunakan untuk menambahkan kolom Total pada data
def add_total_column(df):
    if not isinstance(df, pd.DataFrame):
        raise TypeError("Input harus berupa objek DataFrame pandas")
    
    df['Total'] = df.apply(calculate_total, axis=1)
    return df