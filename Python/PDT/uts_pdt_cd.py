# -*- coding: utf-8 -*-
"""UTS_PDT_CD.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/1TBk1bK9zyh57vDBiUpzHmDYi5G0a1d4l

# UTS Pemrosesan Data Terdistribusi

## Soal 1

### Import Libray
"""

import pandas as pd
import cv2
import numpy as np
import matplotlib.pyplot as plt
import requests
import urllib

"""### Load Data"""

# Membaca data dari CSV
df = pd.read_csv("https://raw.githubusercontent.com/vexra/college/main/AI/Datasets/flight-price-dataset.csv")
df = df.drop(columns=['Unnamed: 0'])

"""### Exploratory Data Analysis"""

# Menampilkan informasi data
print(df.info())

# Menampilkan lima baris pertama data
print(df.head())

# statistik
df.describe()

"""### Jawaban"""

# Jumlah penerbangan
jumlah_penerbangan = len(df)
print("Jumlah penerbangan:", jumlah_penerbangan)

# Rata-rata harga
rata_rata_harga = df['price'].mean()
print("Rata-rata harga:", rata_rata_harga)

# Median harga
median_harga = df['price'].median()
print("Median harga:", median_harga)

"""## Soal 2"""

# Function to load image from URL
def url_to_image(url):
    # Download the image using urllib
    resp = urllib.request.urlopen(url)
    # Convert the image to a NumPy array
    image = np.asarray(bytearray(resp.read()), dtype="uint8")
    # Decode the image from the array
    image = cv2.imdecode(image, cv2.IMREAD_COLOR)
    return image

# Load image from URL
image_url = "https://raw.githubusercontent.com/vexra/college/main/Images/banana-with-apple.png"
image = url_to_image(image_url)

# Convert the image to grayscale
gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

# Apply Gaussian blur
blur = cv2.GaussianBlur(gray, (11, 11), 0)

# Apply Canny edge detection
canny = cv2.Canny(blur, 30, 150, 3)

# Dilate the edges
dilated = cv2.dilate(canny, (1, 1), iterations=1)

# Find contours
(cnt, hierarchy) = cv2.findContours(
    dilated.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)

# Draw contours on the original image
rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
cv2.drawContours(rgb, cnt, -1, (0, 255, 0), 2)

# Print the number of contours (objects) found
print("Objects in the image:", len(cnt))

# Display the original image with contours
plt.imshow(rgb)
plt.axis('off')
plt.show()
