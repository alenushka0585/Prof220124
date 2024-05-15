package org.example.lesson1.geo;

public class GeoTester {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(
                new Point(7, 7),
                new Point(1, 1));
        System.out.println("area: " + rec.area());
    }
}
