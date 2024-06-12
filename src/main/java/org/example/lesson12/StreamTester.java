package org.example.lesson12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamTester {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Max", "Alexander", "Masha", "Oxana", "Vasilisa", "Dima"
                )
        );

        List<Integer> ints = List.of(1, 5, -10, 14, 11, -3, 0, 45);

        System.out.println("names: " + names);

        names
                .stream()
                .map(String::length
        );

        System.out.println("Names length: " +
                names
                .stream()
                .map(
                a -> a.length()
        ).toList());


        names.stream().map(
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }
        );

        System.out.println(
                names
                .stream()
                .map(String::toUpperCase)
                .toList());


        System.out.println(ints);
        System.out.println("ints in ^2 " +
                ints
                        .stream()
                        .map(i -> (i * i))
                        .toList());

        System.out.println("more than 0: " +
                ints
                        .stream()
                        .filter(a -> a > 0)//вниз по потоку пропускаются только элементы, для которых предикат только true
                        .map(i -> (i * i))
                        .toList());

        System.out.println("less than 0: " +
                ints
                        .stream()
                        .filter(a -> a < 0)
                        .map(i -> (i * i))
                        .toList());


        names.stream()
                .forEach(System.out::println);

        names.stream()
                .forEach( // Consumer - выполняет действие для каждого элемента
                        n -> System.out.println("name: " + n)
                );


        System.out.println("names containing 'i' to upper case: " +
                names.stream()
                        .filter(s -> s.contains("i"))
                        .map(s -> s + ":" + s.length())
                        .map(s -> s.toUpperCase())
                        .toList());

    }
}
