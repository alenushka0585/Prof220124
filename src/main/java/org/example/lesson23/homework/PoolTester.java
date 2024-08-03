package org.example.lesson23.homework;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class PoolTester {
    //    Создайте класс PoolTester и
//    a. в main создайте ForkJoinPool и
//    b. запустите на нем 5 Runnable каждая из которых
//    c. ждет рандомное время от 0 до 500 и распечатывает это время на экране
//    d. дождитесь в main остановки ForkJoinPool
    public static void main(String[] args) {
        ExecutorService service = ForkJoinPool.commonPool();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                int time = random.nextInt(0,500);

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                System.out.println(time);
            }
        };

        for (int i = 0; i < 5; i++) {
            service.submit(runnable);
        }

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
