package org.example.lesson12;

import org.example.lesson10.homework.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// @FunctionalInterface - аннтотация
// FunctionalInterface - интерфейс с одним абстрактным методом, сколько угодно default и статических методов
// SAM - SingleAbstract Method

//https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
public class FunctionalTester {
    public static void main(String[] args) {
        DoubleProducer returns10 = new DoubleProducer() {
            @Override
            public double produce() {
                return 10;
            }
        };

//        DoubleProducer randomProducer = new DoubleProducer() {
//            @Override
//            public double produce() {
//                return Math.random()*256;
//            }
//        };


// лямбда выражение - это реализация только функционального выражения
        DoubleProducer randomProducer = () -> Math.random() * 256; // лямбда выряжение

        System.out.println("Random double: " + randomProducer.produce());

//        Comparator<Student> nameComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };

        Comparator<Student> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        TwoIntsReturnBoolean areEquals = (a, b) -> a == b;

        System.out.println("50 and 10 are equals? " + areEquals.check(50, 10));


        TwoIntsReturnBoolean isDividedBy = (a, b) -> a % b == 0;
        System.out.println("50 and 10 are equals? " + process(50, 10, areEquals)); // false
        System.out.println("50 is divided by 10 are ? " + process(50, 10, isDividedBy)); // false

        List<String> names = new ArrayList<>(
                Arrays.asList(
                        "Max", "Alexander", "Masha", "Oxana", "Vasilisa", "Dima"
                )
        );

        StringToInt toLength = (a) -> a.length();
        System.out.println("names: " + names);
        System.out.println("Length of names: " + map(names, toLength));

        StringPredicate containsR = a -> a.contains("r");
        System.out.println("Contains r? " + filter(names, containsR));

        System.out.println("More than 6? " + filter(names, (a) -> (a.length() > 6)));

    }

    public static List<String> filter(List<String> strings, StringPredicate predicate) {
        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (predicate.check(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static boolean process(int i, int j, TwoIntsReturnBoolean t) {
        return t.check(i, j);
    }

    public static List<Integer> map(List<String> s, StringToInt i) {
        List<Integer> list = new ArrayList<>();
        for (String word : s) {
            list.add(i.process(word));
        }
        return list;
    }
}
