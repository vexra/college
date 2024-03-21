package Nomor2;

public class Main {
    public static void main(String args[]) {
        Shape trapezoid1 = new Trapezoid(3.0, 7.0, 4.0);
        Shape trapezoid2 = new Trapezoid(5.0, 9.0, 6.0);

        // Memanggil metode calculateArea dan calculatePerimeter
        System.out.println("Trapezoid 1 Area: " + trapezoid1.calculateArea());
        System.out.println("Trapezoid 1 Perimeter: " + trapezoid1.calculatePerimeter());

        System.out.println("Trapezoid 2 Area: " + trapezoid2.calculateArea());
        System.out.println("Trapezoid 2 Perimeter: " + trapezoid2.calculatePerimeter());

        // Menggunakan polimorfisme untuk Kite
        Shape kite1 = new Kite(8.0, 10.0);
        Shape kite2 = new Kite(12.0, 15.0);

        // Memanggil metode calculateArea dan calculatePerimeter
        System.out.println("Kite 1 Area: " + kite1.calculateArea());
        System.out.println("Kite 1 Perimeter: " + kite1.calculatePerimeter());

        System.out.println("Kite 2 Area: " + kite2.calculateArea());
        System.out.println("Kite 2 Perimeter: " + kite2.calculatePerimeter());
    }
}
