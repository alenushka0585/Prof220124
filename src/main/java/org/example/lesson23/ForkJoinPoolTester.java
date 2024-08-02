package org.example.lesson23;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTester {
    public static void main(String[] args) {
        // стандартный пул потоков Executors.newFixedThreadPool(3)
        // нужно останавливать
        // самостоятельно настраивать
        // main его не ждет, но можно воспользоваться awaitTermination
        // завершается самостоятельно когда больше нет никаких задач


        ExecutorService service = ForkJoinPool.commonPool();

        // service.submit()

        // создайте Runnable который ждет 200 мс
        // и печатает на экране рандомный Integer от 0 до 100
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Random().nextInt(100));
            }
        };


        // 10 раз запустите на service этот Runnable
        for (int i = 0; i < 10; i++) {
            service.submit(r);
        }

        try {
            service.awaitTermination(20, TimeUnit.SECONDS);
        } catch (Exception e) {
        }
    }
}
