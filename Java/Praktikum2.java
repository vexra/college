import java.util.Scanner;
import javax.swing.JOptionPane;

public class Praktikum2 {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Input Nama anda");
        String alamat = JOptionPane.showInputDialog("Input Alamat anda");
        String tahun = JOptionPane.showInputDialog("Input Tahun Angkatan anda");

        JOptionPane.showMessageDialog(null, "nama " + name + "\nAlamat " + alamat + "\nangkatan " + tahun);

        int angka = 5;
        double angkaDouble = 2.5;
        float floatVal = 2.5f;
        long longVal = 20L;

        System.out.println(angka);
        System.out.println(angkaDouble);
        System.out.println(floatVal);
        System.out.println(longVal);

        char ch = 'c';
        String word = "hell oworld";

        System.out.println(ch);
        System.out.println(word);

        boolean state = true;
        System.out.println(state);

        double fromInt = angka;
        int fromDouble = (int) angkaDouble;

        System.out.println(fromInt);
        System.out.println(fromDouble);

        Scanner inputUser = new Scanner(System.in);

        System.out.println("Tahun Angkatan: ");
        int age = inputUser.nextInt();
        inputUser.nextLine();

        System.out.println("Nama: ");
        String nama = inputUser.nextLine();

        System.out.println("Alamat: ");
        String address = inputUser.nextLine();

        System.out.println("Nama: " + nama);
        System.out.println("Tahun angkatan: " + age);
        System.out.println("Alamat: " + address);
        inputUser.close();

    }
}


 