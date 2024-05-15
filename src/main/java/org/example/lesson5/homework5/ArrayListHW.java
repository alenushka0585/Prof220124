package org.example.lesson5.homework5;

import java.util.*;

public class ArrayListHW {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(1, 2, 6, 8, 15, 3)
        );
        System.out.println(evenList(list));


        List<Integer> list2 = new ArrayList<>(
                Arrays.asList(1, 3, 4, 2)
        );
        System.out.println(secondOrdinalNum(list2));


        List<Integer> list3 = new ArrayList<>(
                Arrays.asList(1, 2, 3)
        );
        System.out.println(reverseOrder(list3));

        List<String> list4 = new ArrayList<>(
                Arrays.asList("Dima", "Sam", "Dima", "Alina")
        );
        System.out.println(withoutDuplicate(list4));
    }


    //    1. Напишите метод, который принимает список целых и возвращает список только из четных:
//    {1,2,6,8,15,3} -> {2,6,8}
    public static List<Integer> evenList(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                result.add(i);
            }
        }
        return result;
    }


//    Напишите функцию, возвращающую второй по величине элемент списка целых.
//    Например, {1,3,4,2} -> 3

    private static int secondOrdinalNum(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        list.sort(Comparator.reverseOrder());
        return list.get(1);
    }

    //    Напишите функцию, меняющую порядок следования элементов в списке на противоположный
//    например, {1,2,3} -> {3,2,1}
    private static List<Integer> reverseOrder(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        list.sort(Comparator.reverseOrder());
        return list;
    }
//** 4. Напишите функцию, удаляющие дубликаты из передаваемого в нее списка строк.
//            Например {"Dima", "Sam", "Dima", "Alina"} -> {"Alina", "Dima", "Sam"}

    private static List<String> withoutDuplicate(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (String s : list) {
            // Если строка еще не содержится в результирующем списке, добавляем её
            if (!result.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
