package org.example.lesson3;

public enum Fruit {
    APPLE(52), ORANGE(47), BANANA(89), GRAPES(67), KIWI(61);
    private int calories;

    Fruit(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}
