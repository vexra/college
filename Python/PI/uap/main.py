import pandas as pd
import util
from data import Data

if __name__ == "__main__":    
    # Membuat 10 row data
    df = pd.DataFrame({'Courses': ["Spark", "Hadoop", "Pandas", "Java", "Pyspark", "Atom", "Iron", "Carbon", "Hydrogen", "React"],
                       'Categories': ["DS", "DS", "PI", "PI", "DS", "NA", "NA", "NA", "NA", "WB"],
                       'Fee': [20000, 25000, 30000, 22000, 26000, 27000, 35000, 30000, 10000, 50000],
                       'Duration': ["30days", "40days", "35days", "60days", "50days", "10days", "20days", "35days", "45days", "20days"],
                       'Percentage Discount': ["5%", "10%", "5%", "5%", "5%", "5%", "10%", "10%", "5%", "10%"]})

    # Print 10 row tanpa kolom total
    print(df)

    # Menambahkan kolom total pada setiap row data
    df = util.add_total_column(df)

    # Membuat instance dari class Data yang berisi Pandas DataFrame
    data = Data(df)

    # Print 10 row yang sudah ditambah dengan kolom total 
    print(data)

    # Print mode, mean, dan median dari kolom Fee
    print("modus dari Fee:", data.mode('Fee'))
    print("mean dari Fee:", data.mean('Fee'))
    print("median dari Fee:", data.median('Fee'))

    # Print mode, mean, dan median dari kolom Total
    print("modus dari Total:", data.mode('Total'))
    print("mean dari Total:", data.mean('Total'))
    print("median dari Total:", data.median('Total'))
