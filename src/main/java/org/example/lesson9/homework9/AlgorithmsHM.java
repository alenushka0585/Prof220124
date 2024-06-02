package org.example.lesson9.homework9;

import javax.swing.*;

public class AlgorithmsHM {
    public static void main(String[] args) {
//        Дано натуральное число N. Выведите слово YES,
//        если число N является точной степенью двойки,
//        или слово NO в противном случае.
//       Операцией возведения в степень пользоваться нельзя!
//        Ввод
//        Вывод
//        8
//        YES
//        3
//        NO

        isPowerOfTwo(8);
        isPowerOfTwo(9);

//        Дано натуральное число N. Вычислите сумму его цифр.
//        При решении этой задачи нельзя использовать строки,
//        списки, массивы (ну и циклы, разумеется).
//        Ввод
//        Вывод
//        179
//        17
//        985
//        22

        System.out.println(sumOfNums(179));
        System.out.println(sumOfNums(985));

//        Напишите рекурсивный метод, который выводит на экран
//        числа Фибоначчи до N-ого элемента.

        printFibonacci(10);

//        Напишите рекурсивный метод, который проверяет, является ли строка палиндромом.

        System.out.println();

        System.out.println("Is anna palindrome? " + istPalindrome("anna"));
        System.out.println("Is papa palindrome? " + istPalindrome("papa"));
    }

    private static boolean istPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                return false;
            } else {
                return istPalindrome(s.substring(1, s.length() - 1));
            }
        }
    }

    private static void printFibonacci(int n) {
        printFibonacciHelper(n, 0, 0, 1);
    }

    private static void printFibonacciHelper(int n, int index, int a, int b) {
        if (index < n) {
            System.out.print(a + ", ");
            printFibonacciHelper(n, ++index, b, a + b);
        }
    }

    public static void isPowerOfTwo(int n) {
        if (n == 1) {
            System.out.println("YES");
        } else if (n % 2 != 0 || n == 0) {
            System.out.println("NO");
        } else {
            isPowerOfTwo(n / 2);
        }
    }

    public static int sumOfNums(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumOfNums(n / 10);
        }
    }
}
