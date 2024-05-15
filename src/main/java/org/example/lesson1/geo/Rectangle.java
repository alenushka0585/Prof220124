package org.example.lesson1.geo;

public class Rectangle {
    private Point sw;
    private Point ne;

    public Rectangle(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public Point getSw() {
        return sw;
    }

    public void setSw(Point sw) {
        this.sw = sw;
    }

    public Point getNe() {
        return ne;
    }

    public void setNe(Point ne) {
        this.ne = ne;
    }

    public double area() {
        double y = ne.getY() - sw.getY();
        double x = ne.getX() - sw.getX();
        return y * x;
    }
}
