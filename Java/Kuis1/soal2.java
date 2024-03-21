package Kuis1;

import java.util.Scanner;

public class soal2 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        
        int n = inputUser.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = inputUser.nextInt();
        }

        int query = inputUser.nextInt();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == query) {
                found = true;
                break;
            }
        }

        if (found) System.out.println("Nilai ditemukan");
        else System.out.println("Nilai tidak ditemukan");


        inputUser.close();

    }
}
