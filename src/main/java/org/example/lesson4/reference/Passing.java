package org.example.lesson4.reference;

import org.example.lesson4.animals.Cat;

public class Passing {
    public static void main(String[] args) {
        int number = 12;
        System.out.println("Number before " + number);

        changeNumber(number);

        System.out.println("Number after " + number);

        Cat cat = new Cat("Trifon");
        System.out.println("Cat before " + cat);
        changeCat(cat);
        System.out.println("Cat after " + cat);

        changeCatForANew(cat);
        System.out.println("Cat after change " + cat);
    }

    private static void changeCatForANew(Cat c) {
        c = new Cat("Masha");
    }

    private static void changeCat(Cat c) {
        c.setName("puma");
    }

    private static void changeNumber(int number){
        //передается копия значения
        number = 30;
    }
}
