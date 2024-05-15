package org.example.lesson3;

public class NewPizza {
    private PizzaSize size;
    private PizzaType type;
    private int salami = 0;
    private int mashrooms = 0;

    public NewPizza(PizzaSize size, PizzaType type, int salami, int mashrooms) {
        this.size = size;
        this.type = type;
        this.salami = salami;
        this.mashrooms = mashrooms;
    }

    public double calculatePrice() {
        double sum = 0;
        switch (size) {
            case SMALL -> sum += 10;
            case MEDIUM -> sum += 12;
            case BIG -> sum += 14;
        }


        sum += (mashrooms + salami) * 2;
        return sum;
    }
}
