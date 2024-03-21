package Kuis1;

import java.util.Scanner;

public class soal1 {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        
        int n = inputUser.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = inputUser.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        System.out.println(sum);

        inputUser.close();

    }
}
