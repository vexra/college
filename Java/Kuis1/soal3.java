package Kuis1;

import java.util.Scanner;
import java.util.Arrays;

public class soal3 {
    public static void main(String args[]) {
        Scanner inputUser = new Scanner(System.in);
        
        int n = inputUser.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; ++i) {
            arr[i] = inputUser.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }

        inputUser.close();
    }
}
