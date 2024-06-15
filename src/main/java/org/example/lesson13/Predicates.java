package org.example.lesson13;

import java.util.List;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        //Predicate принимает на вход значение, анализирует и возвращает true/false
        // тест на соответствие элемента определенному условию

        List<String> names = List.of("John", "Max", "Alexander", "Vasilisa");

        Predicate<String> moreThan5Letters = s -> s.length() > 5;

        System.out.println("Names longer than 5 letters: "
                + names.stream().filter(moreThan5Letters).toList());

        Predicate<String> containsX = s -> s.toLowerCase().contains("x");

        Predicate<String> complex = moreThan5Letters.and(containsX);

       // moreThan5Letters.or(containsX)
        //moreThan5Letters.negate()

        System.out.println(names.stream()
                .filter(complex).toList());
    }
}
