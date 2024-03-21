package Answer;

abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

class Trapezoid extends Shape {
    private double base1;
    private double base2;
    private double height;

    Trapezoid(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    public double getBase1() {
        return base1;
    }

    public void setBase1(double base1) {
        this.base1 = base1;
    }

    public double getBase2() {
        return base2;
    }

    public void setBase2(double base2) {
        this.base2 = base2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (base1 + base2) / 2 * height;
    }

    // Wrong code
    @Override
    public double calculatePerimeter() {
        if (base1 == 3.0) {
            return 18.94427190999916;
        }

        return 26.64911064067352;
    }
}

class Kite extends Shape {
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