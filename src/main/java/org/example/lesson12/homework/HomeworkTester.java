package org.example.lesson12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkTester {
    public static void main(String[] args) {
//        выберите только элементы длиной меньше 7 символов
//        преобразуйте их в верхний регистр
//        добавьте к ним длину
//        вызовите функцию которая преобразует строки в обратный порядок
//
//        Пример: ["Dima", "Max", "Alexander"] -> ["4-AMID", "3-XAM"]

        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Max", "Alexander", "Masha", "Oxana", "Vasilisa", "Dima"
                )
        );

        System.out.println("Names before: " + names);
        System.out.println("Names after: " +
                names
                        .stream().filter(s -> s.length() <7)
                        .map(String::toUpperCase)
                        .map(s-> s + "-" + s.length())
                        .map(s -> new StringBuilder(s).reverse())
                        .toList());
    }
}
