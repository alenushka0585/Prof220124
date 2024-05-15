package org.example.lesson3;

public class PizzaTester {
    public static void main(String[] args) {
        Pizza p1 = new Pizza(1, "margarita", 2, 2);
        System.out.println(p1.calculatePrice());

        Pizza p2 = new Pizza(10, "my own", 1, 1);
        System.out.println(p2.calculatePrice());

        NewPizza n1 = new NewPizza(
                PizzaSize.SMALL,
                PizzaType.MARGARITA,
                2,
                2);
        System.out.println(n1.calculatePrice());
    }
}
