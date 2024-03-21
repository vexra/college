package Nomor1;
public class main {
    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(3, 4);

        double distance = point1.distance(point2);
        System.out.println("Distance between points: " + distance);
    }
}
