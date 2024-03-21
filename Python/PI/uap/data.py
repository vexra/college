import numpy

# class Data digunakan untuk menyimpan Pandas DataFrame dengan tambahan method mode, mean, dan median
class Data:
    # Constructor
    def __init__(self, df):
        self.df = df

    # Konversi ke dalam bentuk string
    def __str__(self):
        return self.df.to_string()

    # Mencari mean dari sebuah kolom pada Pandas DataFrame
    # panggil dengan argumen kolom yang ingin dicari misal data.mean('Fee')
    def mean(self, column):
        try:
            values = self.df[column].tolist()
            return numpy.sum(values) / len(values)
        except KeyError:
            return f"Column '{column}' does not exist in the DataFrame."

    # Mencari median dari sebuah kolom pada Pandas DataFrame
    # USAGE : panggil dengan argumen kolom yang ingin dicari misal data.median('Fee')
    def median(self, column):
        try:
            values = self.df[column].tolist()
            values.sort()

            n = len(values)

            if n % 2 == 0:
                return (values[n//2] + values[n//2-1]) / 2
            else:
                return values[n//2]
        except KeyError:
            return f"Column '{column}' does not exist in the DataFrame."

    # Mencari modus dari sebuah kolom pada Pandas DataFrame
    # USAGE : panggil dengan argumen kolom yang ingin dicari misal data.mode('Fee')
    def mode(self, column):
        try:
            values = self.df[column].tolist()

            frekuensi = {}
            for elemen in values:
                if elemen in frekuensi:
                    frekuensi[elemen] += 1
                else:
                    frekuensi[elemen] = 1

            # Mencari elemen-elemen dengan frekuensi tertinggi
            max_frekuensi = max(frekuensi.values())
            modus = [elemen for elemen, frek in frekuensi.items() if frek == max_frekuensi]
            return modus[0]
        except KeyError:
            return f"Column '{column}' does not exist in the DataFrame."