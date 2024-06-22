package org.example.lesson15;

import java.util.AbstractMap;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorTester {
    public static void main(String[] args) {
        // Collector - мехаизм для выполнения операций над потоками
        //Механизм преобразования потоков во что угодно
        //collect - терминальная функция, которая принимает Collector

        List<String> names = List.of("Masha", "Alexander", "Sveta", "Vlad", "Alice", "Xenia");


        System.out.println(names.stream()
                .map(name -> name.toUpperCase())
                //.toList());
                .collect(Collectors.toList())
        );

        System.out.println(
                names.stream()
                        .collect(Collectors.groupingBy( // собирает в мапу, указывая ключ
                                s -> s.length()
                        ))
        );


        // соберем все элементы в Map<длины, количества элементов с такой длиной>
        System.out.println(
                names.stream()
                        .collect(
                                Collectors.groupingBy(
                                        s -> s.length()
                                )
                        ) // Map<Integer, List<String>>
                        .entrySet() // Set<Pair<Integer, List<String>>
                        .stream()
                        .map(pair -> new AbstractMap.SimpleEntry(pair.getKey(), pair.getValue().size()))
                        .collect(
                                Collectors.toMap(
                                        pair -> pair.getKey(),
                                        pair -> pair.getValue()
                                )
                        )
        );

        // counting - подсчет
        System.out.println(
                names.stream()
                        .collect(Collectors.counting())
        );

        System.out.println(
                names.stream()
                        .collect(Collectors.partitioningBy( // группирует по предикату
                                        s -> s.endsWith("a")
                                )
                        )
        );

        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );


        // toCollection - выбрать в какую коллекцию собирать поток
        names.stream()
                .collect(Collectors.toCollection(
                        TreeSet::new
                ));

// соберите не повторяющиеся фамилии студентов в контейнер по
// возрастанию
        System.out.println("" +
                students.stream()
                        .map(student -> student.getLastName())
                        .collect(
                                Collectors.toCollection(
                                        TreeSet::new
                                )
                        )
        );

        System.out.println("" +
                students.stream()
                        .collect(
                                Collectors.groupingBy(
                                      student -> student.getAge()
                                )
                        )
        );


        System.out.println("" +
                students.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        student -> student.getLastName().endsWith("a")
                                )
                        )
        );

        System.out.println("" +
                students.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        student -> student.getLastName().endsWith("a"),
                                        Collectors.counting()
                                )
                        )
        );

        //joining - объединение элементов в строку через разделитель

        System.out.println(
                students.stream()
                        .map(student -> student.getFirstName())
                        .collect(
                                Collectors.joining(
                                        ", ",
                                        "{",
                                        "}"
                                )
                        )
        );











    }
}
