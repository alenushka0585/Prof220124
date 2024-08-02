package org.example.lesson22.homework;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTester {
//    3. Создайте класс AtomicTester
//    a. создайте в нем статическое поле counter типа AtomicInteger со значением 10
//    b. создайте в нем статический метод decrease5 который принимает на вход AtomicInteger и
//    пять раз уменьшает его (decrementAndGet)
//    c. Создайте и запустите два потока, каждый из которых выполняет метод decrease5 передавая туда counter
//    d. В методе main дождитесь окончания работы потоков (join()) и
//    распечатайте значение counter
    private static AtomicInteger counter = new AtomicInteger(10);

    private static void decrease5(AtomicInteger atomicInt){
        for (int i = 0; i < 5; i++) {
            atomicInt.decrementAndGet();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> decrease5(counter));
        Thread thread2 = new Thread(()-> decrease5(counter));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);
    }
}
