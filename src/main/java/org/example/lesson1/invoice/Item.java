package org.example.lesson1.invoice;

public class Item {
    private String name;
    private int count;
    private double unitPrice;

    public Item(String name, int count, double unitPrice) {
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
