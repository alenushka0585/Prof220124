package org.example.lesson19.homework;

import org.example.lesson19.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HomeWork {
    public static void main(String[] args) {
//        1. Напишите шаблонный метод getMax
//        который принимает на вход массив произвольного типа и компаратор
        Integer[] intArray = {3, 5, 1, 4, 2};
        String[] strArray = {"apple", "pear", "orange", "banana"};

        Comparator<Integer> intComparator = Integer::compareTo;
        Integer maxInt = getMax(intArray, intComparator);
        System.out.println("Max integer: " + maxInt);

        Comparator<String> strComparator = String::compareTo;
        String maxStr = getMax(strArray, strComparator);
        System.out.println("Max string: " + maxStr);

        //        2.Напишите шаблонный метод equals который принимает две пары
        //        и проверяет их на эквивалентность, сравнивая по значениям все их поля

        // см. в классе PairImpl


        //        3. (xxxxx) Перепишите любую из ранее написанных коллекций (ArrayList, ArrayDeque, etc) в шаблонную.
        //        На всякий случай, вот так можно создать шаблонный массив:
        //        private T [] source;
        //        source = (T[]) new Object[CAPACITY];
        // см. lesson 5 MyArrayList
    }

    public static <T> T getMax(T[] arr, Comparator<T> comp){
//        if (arr == null || arr.length == 0) {
//            throw new IllegalArgumentException("Array must not be null or empty");
//        }

//        T max = arr[0];
//        for (T element : arr) {
//            if (comp.compare(element, max) > 0) {
//                max = element;
//            }
//        }

        return Arrays.stream(arr)
                .max(comp)
                .orElse(null);

    }

    public static <K,V> boolean equals(Pair<K,V> p1, Pair<K,V> p2) {
        return p1.first().equals(p2.first()) && p2.second().equals(p2.second());
    }
}
