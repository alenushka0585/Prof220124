package org.example.lesson10;

import org.example.lesson3.NewPizza;

import java.util.*;

public class ComparatorTester {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        boolean isEqualsPrimitive = a == b; // примитивные типы и соотв боксинговые типы сравнение работает со значениями

        System.out.println("a == b: " + isEqualsPrimitive);

        Cat one = new Cat();
        Cat two = new Cat();

        System.out.println("one == two: " + (one== two));
        System.out.println("one == two: " + (one.equals(two)));

        List<String> groups = new ArrayList<>(
                Arrays.asList("Ramones", "Aerosmith", "Rolling Stones", "Beatles", "Roxette","Inxs")
        );

        System.out.println(groups);
        Collections.sort(groups);
        System.out.println(groups);

        // Comparator - критерии сортировки
        //compare

        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // критерий сортировки
                // как относятся между собой s1 и s2 - больше, меньше или равно
                // если s1 "меньше" чем s2 возвращаем любое отрицательное целое
                // если s1 эквивалентен s2 возвращаем 0
                // если s1 "больше" чем s2 то возвращаем любое положительное целое

                return s1.length()- s2.length();
            }
        };

        Collections.sort(groups, stringLengthComparator);
        System.out.println(groups);

        Comparator<String> thirdLetterComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.substring(2,3).compareTo(o2.substring(2,3));
            }
        };

        Collections.sort(groups, thirdLetterComparator);
        System.out.println(groups);

        List<Cat> cats = new ArrayList<>(
                Arrays.asList(new Cat("Amir", 3),
                        new Cat("Murzik", 2),
                        new Cat("Pushok", 4),
                        new Cat("Junior", 1),
                        new Cat("Alex", 2),
                        new Cat("Zack", 2)
                )
        );

        System.out.println(cats);
        Comparator<Cat> catAgeComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                //return o1.age - o2.age; // -2 млр до 2 млн
                return Integer.compare(o1.age,o2.age);
            }
        };

        Comparator<Cat> myCatAgeComparator = (o1, o2) -> Integer.compare(o1.age, o2.age);
        
        Collections.sort(cats,catAgeComparator);
        System.out.println(cats);

        Collections.sort(cats,catAgeComparator.reversed()); // обратный компаратор
        System.out.println(cats);

        Comparator<Cat> catNameComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(cats);
        System.out.println(cats);

        Collections.sort(cats,Comparator.reverseOrder());
        System.out.println(cats);

        Comparator<Cat> ageNameComparator = new Comparator<Cat>() { // двойная сортировка
            @Override
            public int compare(Cat c1, Cat c2) {
                int ageCompare = c1.age - c2.age;
                int nameCompare = c1.name.compareTo(c2.name);
                return ageCompare == 0 ? nameCompare : ageCompare;
            }
        };

        Collections.sort(cats, ageNameComparator);
        System.out.println(cats);

        Comparator<Cat> complexComparator =
                catAgeComparator.thenComparing(catNameComparator);

        cats.sort(complexComparator);
        System.out.println(cats);

        Comparator<Cat> reverseComparator =
                catAgeComparator.thenComparing(catNameComparator).reversed();

        cats.sort(reverseComparator);
        System.out.println(cats);

        System.out.println(Collections.min(cats, catNameComparator)); // min по имени
        System.out.println(Collections.max(cats, ageNameComparator)); // max по возрасту
        System.out.println(Collections.max(cats, Cat.catAgeComparator));

        TreeSet<Cat> catTreeSet = new TreeSet<>(Cat.catAgeComparator.reversed());
        catTreeSet.addAll(cats);

        System.out.println(catTreeSet);

        System.out.println(catTreeSet.tailSet(new Cat("Max", 2)));


    }
}
