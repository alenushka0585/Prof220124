package org.example.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTester {
    public static void main(String[] args) {
        //Collection - https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
        // List - https://docs.oracle.com/javase/8/docs/api/java/util/List.html

        List<String> capitals = new ArrayList<>();
        capitals.add("Vienna");
        capitals.add("Prague");
        System.out.println(capitals);
        System.out.println("size? " + capitals.size());

//        не пуст?
        System.out.println("isEmpty? " + capitals.isEmpty());
//        добавдение в конкретное место
        capitals.add(1, "Riga");
        System.out.println(capitals);

//        заменить элемент
        capitals.set(0, "Budapest");
        System.out.println(capitals);

//        Удаление по индексу
        capitals.remove(0);
//        удалить по значению
        capitals.remove("London");
        System.out.println(capitals);

//        проверка наличия элемента
        System.out.println("Riga? " + capitals.contains("Riga"));
//        индекс первого вхождения
        System.out.println("Prague? " + capitals.indexOf("Prague"));
        System.out.println("Amsterdam? " + capitals.indexOf("Amsterdam"));

//        индекс последнего вхождения
        System.out.println("London? " + capitals.lastIndexOf("London"));

//        удаление элементов
//        capitals.clear();

//        обращение по индексу
        System.out.println("0" + capitals.get(0));
        List<Integer> a = new ArrayList<>(
                Arrays.asList(1, 2, 3)
        );
        List<Integer> b = new ArrayList<>(
                Arrays.asList(4, 5, 6)
        );

        System.out.println("concat: " + concat(a, b));
        System.out.println(a);

// добавление коллекции в коллекцию
// Collections.addAll(Collection)
// удалить все элементы из коллекции
// capitals.removeAll(Collection)
// содержатся ли все элементы из коллекции
// capitals.containsAll(Collection)
// оставить только те элементы которые присутствуют в коллекции
// capitals.retainAll(Collection)

        System.out.println("maxLength: " +
                maxLength(Arrays.asList("Max", "Marina", "Alexandr")));
        System.out.println(compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(6, 7, 3)
        ));

    }

    public static List<Boolean> compare(List<Integer> a, List<Integer> b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty() || a.size() != b.size()) {
            return null;
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
                result.add(
                        a.get(i).equals(b.get(i)));
        }
        return result;
    }

    public static String maxLength(List<String> s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        String result = s.get(0);
        for (String string : s) {
            if (string.length() > result.length()) {
                result = string;
            }
        }
        return result;
    }

    public static List<Integer> concat(List<Integer> a, List<Integer> b) {
//        for (Integer i: b) {
//            a.add(i);
//        }
        List<Integer> r = new ArrayList<>();
        r.addAll(a);
        r.addAll(b);
        return r;
    }
}
