package org.example.lesson3;

public enum Color {
    YELLOW (255,255,0),
    MAGENTA(255,0,255),
    ORANGE (255, 165, 0),
    RED(255, 0,0),
    GREEN(0,255,0),
    BLUE(0,0,255);
    private int r;
    private int g;
    private int b;

    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
