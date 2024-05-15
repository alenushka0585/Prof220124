package org.example.lesson1.invoice;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class InvoiceTester {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Coca-cola", 2, 0.6),
                new Item("Hummer", 2, 4.5),
                new Item("Nails", 35, 0.05)};

        Invoice invoice = new Invoice(items);
        System.out.println(invoice.calculate());


        System.out.println(Arrays.stream(items)
                .map(item -> item.getUnitPrice() * item.getCount()).
                reduce(0.0, Double::sum));
    }
}
