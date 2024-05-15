package org.example.lesson1;

public class DogTester {
    public static void main(String[] args) {
        Dog sharik = new Dog();
//        System.out.println(sharik.breed);

        Dog pushok = new Dog("Pushok");

        pushok.bark();
        pushok.info();

        System.out.println("Dog " + pushok.getName() +
                ",age " + pushok.getAge());

//        pushok.setName("Barbos");
        pushok.info();

    }
}
