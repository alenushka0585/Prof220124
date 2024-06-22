package org.example.lesson15.homework;

import org.example.lesson14.Emp;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
        List<Emp> emps = List.of(
                new Emp("Max Petrov", 22, "programmer"),
                new Emp("Ivan Peregudov", 33, "analyst"),
                new Emp("Semen Dezhnev", 55, "manager"),
                new Emp("Katerina Drogova", 31, "programmer"),
                new Emp("Oleg Petrov", 19, "intern"),
                new Emp("Nicolas Spivakov", 23, "analyst"),
                new Emp("Boris Moiseev", 48, "manager"),
                new Emp("Alex Reingard", 33, "analyst"),
                new Emp("Olga Filimonova", 27, "programmer")
        );

//        1. Посчитать средний возраст всех работников используя Collectors.averagingDouble()
//
        System.out.println(
                emps.stream()
                        .collect(Collectors.averagingDouble(
                                Emp::getAge
                        ))
        );

//
//        2. Найдите самого молодого работника используя Collectors.minBy() и компаратор

        System.out.println(
                emps.stream()
                        .collect(Collectors.minBy(
                                (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())
                        )).orElse(null)
        );

//
//        3. Разбейте пользователей на группы по возрасту - 10-19 (1), 20-29 (2), 30-39 (3), 40-49 (4), 50-59 (5)
//        и так далее лет - Map<Integer, List<Emp>> - ключи мапы  1,2,3,4,5  и т.п. - количество полных десятков лет в возрасте
//
        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.getAge() / 10,
                                Collectors.counting()
                        ))

        );

//        4. (xx) Вернуть средний возраст мужчин и женщин в виде Map - ключ "true" соответствует женщинам
//        - воспользуйтесь Collectors.partitioningBy и Collectors.averagingDouble

        System.out.println(
                emps.stream()
                        .collect(Collectors.partitioningBy(
                                emp -> emp.getName().endsWith("a"),
                                Collectors.averagingDouble(Emp::getAge)
                        ))
        );


//
//        5. (xx) Верните Map - работников с самым большим возрастом в каждой профессии
//        - воспользуйтесь Collectors.groupingBy и Collectors.maxBy

        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.getPosition(),
                                Collectors.maxBy(
                                        Comparator.comparingInt(Emp::getAge)
                                )
                        ))
                        .entrySet().stream()
//                        .filter(entry -> entry.getValue().isPresent())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().get()
                        ))

        );
//
//        6. (xxx) Распечатать работников с самым часто встречающимся возрастом

        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                        e -> e.getAge(),
                                Collectors.counting()
                                ))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .map(maxAge -> emps.stream()
                                .filter(emp -> emp.getAge() == maxAge)
                                .toList()).orElse(Collections.emptyList())

        );
//
//        7. (xxxxx) Найдите пару работников с самой большой разницей в возрасте
//        - воспользуйтесь flatMap для создания потока всех возможных пар каждого работника со всеми остальными

        System.out.println(
                emps.stream()
                        .flatMap(emp1 -> emps.stream().map(emp2 -> new AbstractMap.SimpleEntry<>(emp1, emp2)))
                        .filter(pair -> !pair.getKey().equals(pair.getValue()))
                        .max(Comparator.comparingInt(pair -> Math.abs(pair.getKey().getAge() - pair.getValue().getAge())))
                        .map(pair -> "Pair with max age difference: " + pair.getKey() + " and " + pair.getValue())
                        .orElse("No pairs found")
        );
    }
}
