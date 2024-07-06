package org.example.lesson19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/*
E - Element
K - Key
V - Value
N - Number
T - Type

S,U,V ... - 2-й, 3-й, 4-й типы
 */

public class GenericTester {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Max");
        //names.add(34.44); компилятор может проверить тип добавляемого на соответствие

        List something = new ArrayList();
        something.add("Max");
        something.add(33.58);

        something.forEach(o -> System.out.println("something: " + o));

        String name = (String) something.get(0);
//        String anotherName = (String) something.get(1);

        debug(123);
        debug("It's a string!");

        info(123);
        info("Hallo world!");

        String[] countries = {"Cuba", "Venezuela", "Salvador"};
        System.out.println(
                firstElement(countries)
        );

        System.out.println(
                Arrays.toString(countries)
        );
        swap(countries, 0, 1);
        System.out.println(
                Arrays.toString(countries)
        );

        Holder<String> stringHolder = new Holder<>("Hello, world!");
        Holder<Double> piHolder = new Holder<>(3.14159);
        System.out.println("StringHolder: " + stringHolder);

        Pair<String, Integer> masha = new PairImpl<>("Masha", 24);
        System.out.println(masha);

        System.out.println(firstAndLast(countries));
        System.out.println(fromArrayToList(countries));

        System.out.println(
                fromArrayToList(
                        countries,
                        s -> s.toLowerCase().contains("v"),
                        String::length
                )
        );
        Double[] doubles = {3.14, 2.77, -1.2};

        System.out.println(fromArrayNumbersToList(doubles));
        System.out.println(fromArrayNumbersToList(doubles, 1.3));


    }

    //Generic
    //T - типовой параметр
    // инстанциируется исходя из типа передаваемого значения

    public static <T> void info(T t) {
        System.out.println("It's a " + t.getClass().getSimpleName()
                + ", value is: " + t);
    }

    public static void debug(Integer i) {
        System.out.println("debug int: " + i);
    }

    public static void debug(String s) {
        System.out.println("debug String: " + s);
    }

    public static <T> T firstElement(T[] list) {
        return list[0];
    }

    public static <T> void swap(T[] arr, int a, int b) {
        T x = arr[a];

        arr[a] = arr[b];
        arr[b] = x;
    }

    public static <T> Pair<T, T> firstAndLast(T[] arr) {
        return new PairImpl<>(arr[0], arr[arr.length - 1]);
    }

    public static <T> List<T> fromArrayToList(T[] arr){
        return Arrays.stream(arr).toList();
    }

    public static <T, K> List<K> fromArrayToList(T[] arr, Predicate<T> pr, Function<T, K> funk){
        return Arrays.stream(arr).filter(pr).map(funk).toList();
    }

    public static <T extends Number> List<T> fromArrayNumbersToList (T[] t){
        return Arrays.stream(t)
                .peek(n -> System.out.println("number: " + n.doubleValue()))
        .toList();
    }

    public static <T extends Number & Comparable> List<T> fromArrayNumbersToList (T[] t, T bound){
        return Arrays.stream(t)
                .filter(n -> n.compareTo(bound) > 0)
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .toList();
    }
}
