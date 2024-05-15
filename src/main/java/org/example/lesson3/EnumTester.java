package org.example.lesson3;

import java.util.Arrays;

public class EnumTester {
    public static void main(String[] args) {
        System.out.println(Fruit.KIWI);
        System.out.println(Fruit.KIWI.ordinal());


        Fruit f = Fruit.valueOf("GRAPES");
        System.out.println(f);
//        Fruit f1 = Fruit.valueOf("PINEAPPLE");
//        System.out.println(f1);

        System.out.println(Arrays.toString(Fruit.values()));

        System.out.println(Fruit.GRAPES.getCalories());

        Fruit t = Fruit.values()[3];
        System.out.println(t);

        System.out.println(Weekday.MONDAY.isWeekDay());
        System.out.println(Weekday.SUNDAY.isWeekDay());

        System.out.println(Weekday.SUNDAY.isWeekEnd());
    }
}
