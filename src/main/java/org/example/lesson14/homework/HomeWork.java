package org.example.lesson14.homework;

import org.example.lesson14.Emp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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

//        1. Объедините в строку имена всех работников
//        "Max, Ivam, Semen, …"
//
//
        System.out.println(
                emps.stream()
                        .flatMap( emp -> Stream.of(emp.getName().split(" ")[0]))
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("")
        );



//        Найдите профессию самого старшего из тех работников, кому менее чем 40 лет

        System.out.println(
                emps.stream()
                        .filter(emp -> emp.getAge() < 40)
                        .sorted(((Comparator<Emp>) (o1, o2) -> Integer.compare(o2.getAge(), o1.getAge())))
                        .limit(1)
                        .map(emp -> emp.getPosition())
                        .toList()

        );

    }
}
