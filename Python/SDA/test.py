def gaussian_elimination(matrix):
    rows = len(matrix)
    columns = len(matrix[0])

    for i in range(rows):
        # Mencari baris dengan elemen terbesar pada kolom i
        max_row = i
        for j in range(i + 1, rows):
            if abs(matrix[j][i]) > abs(matrix[max_row][i]):
                max_row = j

        # Menukar baris dengan elemen terbesar ke baris i
        matrix[i], matrix[max_row] = matrix[max_row], matrix[i]

        # Membuat elemen diagonal pada kolom i menjadi 1
        for j in range(i + 1, rows):
            ratio = matrix[j][i] / matrix[i][i]
            for k in range(columns):
                matrix[j][k] -= ratio * matrix[i][k]

    # Proses substitusi mundur untuk mencari solusi
    solution = [0] * rows
    for i in range(rows - 1, -1, -1):
        solution[i] = matrix[i][columns - 1] / matrix[i][i]
        for j in range(i - 1, -1, -1):
            matrix[j][columns - 1] -= matrix[j][i] * solution[i]

    return solution

# Contoh pemanggilan fungsi dengan matriks 3 x 4
matrix = [[5, 5, 7, 5],
          [9, 1, 9, 7],
          [7, 5, 4, 9]]

solution = gaussian_elimination(matrix)
print("Solusi:")
for i in range(len(solution)):
    print(f"x{i + 1} =", solution[i])



