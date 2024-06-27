package org.example.lesson16;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Scanner считывает типизированные значения из дескриптора

        System.out.println("Введите целое число и нажмите ввод");
        int n = scanner.nextInt();

        System.out.println("Введите сумму");
        double d = scanner.nextDouble();

        System.out.println("Введите имя");
        String s = scanner.next();

        System.out.printf("Число: %d, сумма: %f, имя: %s\n", n, d, s);
    }

}

