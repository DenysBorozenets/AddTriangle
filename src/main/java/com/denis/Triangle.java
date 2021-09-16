package com.denis;

public class Triangle extends Shape {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point top, Point left, Point right) {
        this.a = top;
        this.b = left;
        this.c = right;
    }

    public double getSide(Point a, Point b) {
        double first = Math.pow(a.getX() - b.getX(), 2);
        double second = Math.pow(a.getY() - b.getY(), 2);
        double res = Math.sqrt(first + second);
        return res;
    }

    public void checkSide(Point a, Point b, Point c) {
        double firstSide = getSide(a,b);
        double secondSide = getSide(b,c);
        double thirdSide = getSide(a,c);

        if ((firstSide > (secondSide + thirdSide))
                || (secondSide > (firstSide + thirdSide))
                || (thirdSide > (firstSide + secondSide))) {
            throw new IllegalArgumentException("Incorrect side");
        }
    }

    public double halfPerimeter(Point a, Point b, Point c) {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(a, c);

        return (sideA + sideB + sideC) / 2;
    }



    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public double perimeter() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(a, c);
        return sideA + sideB + sideC;
    }

    @Override
    public double square() {
        double half = halfPerimeter(a, b, c);
        double firstParam = half - getSide(a, b);
        double secondParam = half - getSide(b, c);
        double thirdParam = half - getSide(a,c);
        double underSqr = half * firstParam
                * secondParam * thirdParam;
        return Math.sqrt(underSqr);
    }

    @Override
    public void move(double dx, double dy) {
        a.setX(a.getX() + dx);
        b.setX(b.getX() + dx);
        c.setX(c.getX() + dx);
        a.setY(a.getY() + dy);
        b.setY(b.getY() + dy);
        c.setY(c.getY() + dy);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
