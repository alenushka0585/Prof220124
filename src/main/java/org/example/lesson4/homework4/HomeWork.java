package org.example.lesson4.homework4;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        int[][] c = new int[][]{
                {1, 3, 5},
                {6},
                {-10, 20, -40, 5}
        };


        printArrays(c);
        maxNumberInArray(c);
    }

    public static void printArrays(int[][] a) {
        System.out.println("[");
        for (int i = 0; i < a.length; i++) {
            System.out.println("\t" +Arrays.toString(a[i]));
        }
        System.out.println("]");
    }

//    Напишите метод, который найдет максимум в двухмерном масиве целых.
//    Добавьте проверки на null ( если передаваемый массив null, если одномерные массивы null).

    public static void maxNumberInArray(int[][] a) {
        if (a == null || a.length == 0) {
            System.out.println("Двухмерный массив пуст!!!");
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                System.out.println("Mассив [" + i + "] пуст!!!");
            } else {
                Arrays.sort(a[i]);
                if (max < a[i][a[i].length-1]){
                    max = a[i][a[i].length-1];
                }
            }
        }
        System.out.println("Max number in Arrays is " + max);
    }
}
