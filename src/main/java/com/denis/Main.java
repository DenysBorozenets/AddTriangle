package com.denis;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Triangle(new Point(3, 4), new Point(7, 6), new Point(5,2));
        System.out.println(shape);
    }
}
