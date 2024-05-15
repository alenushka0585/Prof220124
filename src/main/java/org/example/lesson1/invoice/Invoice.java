package org.example.lesson1.invoice;

import java.util.Arrays;

public class Invoice {
    private Item[] items;

    public Invoice(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public double calculate() {
        double sum = 0;

        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                sum += items[i].getUnitPrice() * items[i].getCount();
            }
        }
        return sum;
    }
}
