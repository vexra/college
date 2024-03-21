import java.util.Scanner;

public class Cakrawangsa_Veda_Alkautsar_Praktikum3 {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Masukan NPM: ");
            String npm = input.nextLine();

            if (npm.equals("2217051004")) {
                System.out.println("successfully logging you in");
                break;
            }

            else {
                System.out.println("NPM anda salah. Silakan coba lagi!");
            }
        }

        while (true) {
            System.out.print("Masukan Nilai: ");
            int nilai = input.nextInt();    

            if (nilai > 100) {
                System.out.println("Input tidak sesuai");
                break;
            }

            String huruf_mutu = "";

            if (nilai >= 76 && nilai <= 100) {
                huruf_mutu = "A";
            }
            else if (nilai >= 71 && nilai < 76) {
                huruf_mutu = "B+";
            }
            else if (nilai >= 66 && nilai < 71) {
                huruf_mutu = "B";
            }
            else if (nilai >= 61 && nilai < 66) {
                huruf_mutu = "C+";
            }
            else if (nilai >= 56 && nilai < 61) {
                huruf_mutu = "C";
            }
            else if (nilai >= 50 && nilai < 56) {
                huruf_mutu = "D";
            }
            else if (nilai >= 0 && nilai < 50) {
                huruf_mutu = "E";
            }
            else {
                huruf_mutu = "Tidak Ada";
            }

            switch (huruf_mutu) {
                case "A":
                    System.out.println("Lulus");
                    break;
                case "B+":
                    System.out.println("Lulus");
                    break;
                case "B":
                    System.out.println("Lulus");
                    break;
                case "C+":
                    System.out.println("Lulus");
                    break;
                case "C":
                    System.out.println("Lulus");
                    break;
                case "D":
                    System.out.println("Lulus");
                    break;
                case "E":
                    System.out.println("Tidak Lulus");
                    break;
                default:
                    System.out.println("Huruf mutu tidak sesuai");
            }
        }

        input.close();
    }
}
