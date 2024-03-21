import pandas as pd
import unittest
import util
from data import Data

class TestUtil(unittest.TestCase):
    # Menginisiasi data dengan sample
    def setUp(self):
        df = pd.DataFrame({'Courses': ["Spark", "Hadoop", "Pandas", "Java", "Pyspark", "Atom", "Iron", "Carbon", "Hydrogen", "React"],
                       'Categories': ["DS", "DS", "PI", "PI", "DS", "NA", "NA", "NA", "NA", "WB"],
                       'Fee': [20000, 25000, 30000, 22000, 26000, 27000, 35000, 30000, 10000, 50000],
                       'Duration': ["30days", "40days", "35days", "60days", "50days", "10days", "20days", "35days", "45days", "20days"],
                       'Percentage Discount': ["5%", "10%", "5%", "5%", "5%", "5%", "10%", "10%", "5%", "10%"]})
        df = util.add_total_column(df)
        self.data = Data(df)

    
    def test_parse_string_to_number(self):
        # Test case 1: string dengan angka
        string = "abc123def"
        expected = 123
        result = util.parse_string_to_number(string)
        self.assertEqual(result, expected)

        # Test case 2: string tanpa angka
        string = "abcdef"
        expected = 0
        result = util.parse_string_to_number(string)
        self.assertEqual(result, expected)

        # Test case 3: string dengan angka negatif
        string = "abc-123def"
        expected = -123
        result = util.parse_string_to_number(string)
        self.assertEqual(result, expected)

        # Test case 4: string dengan angka desimal
        string = "abc12.34def"
        expected = 1234
        result = util.parse_string_to_number(string)
        self.assertEqual(result, expected)

    def test_calculate_total(self):
        # data row kategori PI
        row = pd.Series({
            'Courses': 'Pandas',
            'Categories': 'PI',
            'Fee': 30000,
            'Duration': '35days',
            'Percentage Discount': '5%'
        })

        # Test case 1: category PI
        result = util.calculate_total(row)
        self.assertEqual(result, 976500)

        # data row bukan kategori PI
        row = pd.Series({
            'Courses': 'Spark',
            'Categories': 'DS',
            'Fee': 20000,
            'Duration': '30days',
            'Percentage Discount': '5%'
        })

        # Test case 2: category selain PI
        result = util.calculate_total(row)
        self.assertEqual(result, 570000)

    def test_add_total_column(self):
        # Membuat DataFrame sample
        df = pd.DataFrame({'Courses': ["Spark", "Hadoop", "Pandas", "Java", "Pyspark"],
                       'Categories': ["DS", "DS", "PI", "PI", "DS"],
                       'Fee': [20000, 25000, 30000, 22000, 26000],
                       'Duration': ["30days", "40days", "35days", "60days", "50days"],
                       'Percentage Discount': ["5%", "10%", "5%", "5%", "5%"]})

        # Menambahkan kolom "Total" menggunakan fungsi add_total_column
        df_with_total = util.add_total_column(df)

        # Memeriksa apakah kolom "Total" telah ditambahkan dengan benar
        self.assertIn('Total', df_with_total.columns)

        # Memeriksa tipe data kolom "Total"
        self.assertEqual(df_with_total['Total'].dtype, float)

        # Memeriksa nilai pada kolom "Total"
        self.assertTrue(df_with_total['Total'].equals(pd.Series([570000.0, 900000.0, 976500.0, 1227600.0, 1235000.0], name='Total')))

    def test_mean(self):
        self.assertAlmostEqual(self.data.mean('Fee'), 27500.0)
        self.assertAlmostEqual(self.data.mean('Total'), 806810.0)

    def test_mode(self):
        self.assertEqual(self.data.mode('Fee'), 30000)
        self.assertEqual(self.data.mode('Total'), 900000.0)

    def test_median(self):
        self.assertAlmostEqual(self.data.median('Fee'), 26500.0)
        self.assertAlmostEqual(self.data.median('Total'), 900000.0)

if __name__ == '__main__':
    unittest.main()