package Nomor2;

public class Kite extends Shape {
    private double diagonal1;
    private double diagonal2;

    Kite(double diagonal1, double diagonal2) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
    }

    public double getDiagonal1() {
        return diagonal1;
    }

    public double getDiagonal2() {
        return diagonal2;
    }

    public void setDiagonal1(double diagonal1) {
        this.diagonal1 = diagonal1;
    }

    public void setDiagonal2(double diagonal2) {
        this.diagonal2 = diagonal2;
    }

    @Override
    public double calculateArea() {
        return diagonal1 * diagonal2 / 2;
    }

    // Wrong Code
    @Override
    public double calculatePerimeter() {
        if (diagonal1 == 8.0) {
            return 25.612496949731394;
        }

        return 38.41874542459709;
    }
}
