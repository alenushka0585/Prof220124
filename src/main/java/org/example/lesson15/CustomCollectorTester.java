package org.example.lesson15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorTester {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );

        // https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/stream/Collector.html
        // https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/stream/Collectors.html


        // Напишем кастомный коллектор который просуммирует возраст студентов
        // Collector<T, A, R>
        // T - тип входного потока
        // A - тип аккумулятора
        // R - тип на выходе

        Collector<Student, List<Integer>, Integer> studentAgeSumCollector = new Collector<Student, List<Integer>, Integer>() {
            // supplier - отвечает за создание экземпляра аккумулятора
            @Override
            public Supplier<List<Integer>> supplier() {
                return ArrayList::new;
            }

            // отразить характеристику каждого из студентов в аккумуляторе
            @Override
            public BiConsumer<List<Integer>, Student> accumulator() {
                return (list, student) -> list.add(student.getAge());
            }

            // нужен чтобы объеденить данные из нескольких аккумуляторов
            // в случае параллельной обработке потока данных
            @Override
            public BinaryOperator<List<Integer>> combiner() {
                return (list, list2) -> {
                    list.addAll(list2);
                    return list;
                };
            }

            //вычисление результата на базе финального аккумулятора
            @Override
            public Function<List<Integer>, Integer> finisher() {
                return list -> list.stream().mapToInt(i -> i).sum();
            }

            // возвращает информацию о том как коллектор может запускаться
            // может ли запускаться параллельно и тп
            // Characteristics.CONCURRENT - коллектор может запускаться параллельно
            // Characteristics.IDENTITY_FINISH - finish() не выполняется
            // Characteristics.UNORDERED - элементы могут обрабатываться в произвольном порядке
            @Override
            public Set<Characteristics> characteristics() {
                return Set.of();
            }
        };

        System.out.println(
                students.stream()
                        .collect(studentAgeSumCollector));


    }
}
