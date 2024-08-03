package org.example.lesson23.homework;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeWorkCallable {
//    2. Создайте класс HomeWorkCallable
//    a. создайте в нем метод public static int waitSomeTime который
//    спит рандомное время от 0 до 1000 мс и
//    возвращает это время в качестве результата
//    b. Создайте и запустите два Callable каждый из которых выполняет waitSomeTime и возвращает результат
//    с. В main получите и сложите эти результаты, запустив эти Callable на двух потоках используя FutureTask

    public static int waitSomeTime(){
        Random random = new Random();
        int sleepingTime = random.nextInt(0,1000);
        try {
            Thread.sleep(sleepingTime);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        return sleepingTime;
    }

    public static void main(String[] args) {
        Callable<Integer> callable1 = () -> waitSomeTime();
        Callable<Integer> callable2 = () -> waitSomeTime();


        FutureTask<Integer> futureTask1 = new FutureTask<>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable2);

        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);

        thread1.start();
        thread2.start();

        try {
           int result1 = futureTask1.get();
            int result2 = futureTask2.get();

            int sum = result1 + result2;
            System.out.println("Результат callable1: " + result1);
            System.out.println("Результат callable2: " + result2);
            System.out.println("Сумма результатов: " + sum);
        } catch (InterruptedException |ExecutionException e) {
            System.out.println(e);
        }
    }
}
