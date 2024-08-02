package org.example.lesson22.homework;

import java.util.Random;

public class HomeWorkThreads {
//    2. Создайте класс HomeWorkThreads
//    a создайте в нем два целых статических поля result1 и result2
//    b. создайте в нем метод public static int waitSomeTime который
//    спит рандомное время от 0 до 1000 мс и
//    возвращает это время в качестве результата
//    c. Создайте и запустите два потока, каждый из которых выполняет метод waitSomeTime и
//    первый сохраняет результат в поле поля result1
//    второй сохраняет результат в поле поля result2
//    d. В методе main дождитесь окончания работы потоков (join()) и
//    распечатайте сумму result1 и result2

    private static int result1;
    private static int result2;

    public static int waitSomeTime() {
        Random random = new Random();
        int sleepTime = random.nextInt(0,1000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return sleepTime;
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                result1 = waitSomeTime();
            }
        };

        Thread thread2 = new Thread(() -> result2 = waitSomeTime());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);;
        }

        System.out.println("Sum of result1 and result2: " + (result1 + result2));
    }
}
