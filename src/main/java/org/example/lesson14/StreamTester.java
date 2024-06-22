package org.example.lesson14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        List<Integer> years = List.of(2000, 2022, 2021, 2027, 2021, 2000);

//        years.stream();
//        Arrays.stream();
//        Stream.of();
//        Stream.generate();

        Stream<Integer> yearsStream = years.stream()
                .filter((y -> y % 2 == 00))
                .filter(y -> y > 2010);


        String[] names = {"Alexander", "Max", "Xenia", "Maria"};

        Arrays.stream(names).filter(s -> s.toUpperCase().contains("X"))
                .forEach(s -> System.out.println(s));

        DoubleStream.generate(() -> new Random().nextDouble(200))
                .limit(5)// хотим только 5 значений
                .forEach(d -> System.out.println("double: " + d));

        // rangeClosed(1,5) // [1, 2, 3, 4, 5]
        System.out.println(
                Arrays.toString(
                        IntStream.range(1, 20) // 1 2 3 4... 20
                                .toArray()
                )
        );

        //skip(5) - отбрасывает первые 5 потоков элементов

        years.stream()
                .skip(1)
                .limit(2)
                .forEach(s -> System.out.println(s));

        //distinct - не повторяющиея элементы в потоке

        System.out.println(years);
        System.out.println(
                years.stream().distinct().toList());

        //sorted - сортировка
        System.out.println(
                years.stream().sorted().toList());

        // peek
        System.out.println(
                years.stream()
//                        .map(y -> {
//                                    System.out.println("year: " + y);
//                                    return y;
//                                }
//                        )
                        .peek(y -> System.out.println("year: " + y))
                        .toList()
        );


// промежуточная  - возвращает поток
        // терминальная операция - только они запускают поток
        //count
        //forEach
        //toList

        // запросы потоку целиком - true/false
        //anyMatch - хотябы 1 удовлетворяет
        //allMatch - все удовлетворяют
        //noneMatch - ни один е удовлетворяет

        System.out.println(Arrays.stream(names)
                .allMatch(s -> s.length() > 2));

        //reduce - действие, которое последовательно выполняется с каждым элементом
        // и результат этого действия сохраняется в некой временной переменной,
        // которая применяется в дальнейшей операции со следующим элементом
        // и выдает 1 конечный результат

        int[] numbers = {2, 4, 5, 8, 3};

        System.out.println(Arrays.stream(numbers)
                .reduce(0, (a, b) -> a + b));

        System.out.println(Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b));


        System.out.println(
                Arrays.stream(names)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse(""));

        // Optional<T> - возможность иметь или не иметь значени

        System.out.println(Arrays.stream(numbers)
                .reduce((a, b) -> a > b ? a : b)
                .orElse(-1));


        //min max average

        System.out.println(
                Arrays.stream(numbers).max().orElse(-1)
        );

        System.out.println(Arrays.stream(names)
                .max((o1, o2) -> Integer.compare(o1.length(),o2.length()))
                .orElse(""));


        //mapToInt() - конвертация в примитивные типы
        //mapToDouble()






    }
}
