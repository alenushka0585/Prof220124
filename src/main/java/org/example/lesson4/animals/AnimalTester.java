package org.example.lesson4.animals;

public class AnimalTester {
    public static void main(String[] args) {
        BigDog doggy = new BigDog("Barbos");
        Cat kitty = new Cat("Kitty");

        Animal [] animals = {doggy, kitty};

        for (Animal a: animals){ // for-each
            a.greets();
        }
    }
}
