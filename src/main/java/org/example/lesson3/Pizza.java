package org.example.lesson3;

public class Pizza {
    private int size; //1 - маленькая, 2 - средняя, 3 - большая
    private String type; // маргарита, гавайская, салями, барбекю
    private int mashrooms = 0;
    private int salami = 0;

    public Pizza(int size, String type, int mashrooms, int salami) {
        this.size = size;
        this.type = type;
        this.mashrooms = mashrooms;
        this.salami = salami;
    }

    public double calculatePrice() {
        int sum = 0;

        if (size == 1) {
            sum += 10;
        } else if (size == 2) {
            sum += 12;
        } else if (size == 3){
            sum += 14;
        }
        sum += (mashrooms + salami) * 2;
        return sum;
    }
}
