package org.example.lesson14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmpTester {
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

        System.out.println(
                emps.stream()
                        .filter(e -> e.getAge() > 41)
                        .toList()
        );

        // распечатайте только имена всех программистов
        // Olga Filimonova -> Olga
        System.out.println(
                emps.stream()
                        .filter(e -> e.getPosition().equals("programmer"))
                        .map(e -> e.getName())
                        .map(name -> name.split(" ")[0])
                        .toList()
        );

        System.out.println(
                emps.stream()
                        .filter(e -> e.getPosition().equals("analyst"))
                        .count()
        );

        // найдите самого молодого работника
//        System.out.println(
//                emps.stream()
//                        .min(
//                                (e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())
//                        )
//                        .orElse(null)
//        );

        // найдите самого молодого работника
        System.out.println(
                emps.stream()
                        .min(
                                Comparator.comparingInt(Emp::getAge)
                        )
                        .orElse(null)
        );


        System.out.println(
                emps.stream()
                        .map(a-> a.getPosition())
                        .distinct()
                        .count()
        );


        System.out.println(
                emps.stream()
                        .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                        .limit(3).toList()
        );


        System.out.println(
                emps.stream()
                        .allMatch(s -> s.getAge() > 18)
        );


        System.out.println(
                emps.stream()
                        .filter(s -> s.getName().endsWith("a"))
                        .map(s -> s.getName().split(" ")[1])
                        .toList()
        );


        System.out.println(
                emps.stream()
                        .mapToDouble(s -> s.getAge())
                        .average()
                        .orElse(-1)
        );
        System.out.println(
                emps.stream()
                        .filter(s -> !s.getName().endsWith("a"))
                        .filter(s -> s.getPosition().equals("programmer"))
                        .count()
        );

        System.out.println(
                emps.stream()
                        .sorted(
                                Comparator
                                        .comparing(Emp::getPosition)
                                        .thenComparing(Emp::getAge))
                        .toList()
        );

        System.out.println(
                emps.stream()
                        .mapToInt(Emp::getAge)
                        .sum()
        );


        System.out.println(
                emps.stream()
                        .flatMap(
                                e -> Stream.of(
                                        e.getName().split(" ")[0],
                                        e.getName().split(" ") [1],
                                        e.getPosition()
                                )
                        ).toList()
        );


        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getAge() > 40
                        ))
        );

        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getPosition()
                        ))
        );

        System.out.println(
                emps.stream()
                        .collect(Collectors.groupingBy(
                                e -> e.getPosition(),
                                Collectors.counting()
                        ))
        );


        System.out.println(
                emps.stream()
                        .collect(Collectors.toMap(
                                pair -> pair.getName(),
                                pair -> pair.getAge()
                        ))
        );

    }
}
