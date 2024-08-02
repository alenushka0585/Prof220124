package org.example.lesson23;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {
    //потокобезопасный счетчик
    private static AtomicInteger inside = new AtomicInteger(0);
    private static AtomicInteger all = new AtomicInteger(0);

    public static void main(String[] args) {
        runner(10);
        runner(10);
        runner(10);

        runner(1);
        runner(2);
        runner(5);
        runner(10);
        runner(20);
        runner(40);
        runner(100);

        System.out.println(Runtime.getRuntime().availableProcessors());


    }
 static void runner(int numberOfThreads){
        long before = System.currentTimeMillis();
     ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
     Runnable r = new PiRunnable();
     for (int i = 0; i < 1_000_000; i++) {
         service.submit(r);
     }
     service.shutdown();
     try {
         service.awaitTermination(10, TimeUnit.SECONDS);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
     long after = System.currentTimeMillis();

     System.out.printf(
             "threads: %d, t: %d, i: %d, a: %d, pi: %f\n",
             numberOfThreads,
             (after - before),
             inside.get(),
             all.get(),
             4.0*inside.get()/all.get()
     );
 }
    private static Random r = new Random();
    //рандомно генерировать с координатами от [0,0] до [1,1]
    //ычислять лежит ли точка внутри окружности

    static class PiRunnable implements Runnable{

        @Override
        public void run() {
            all.incrementAndGet();
            //генерирует точку с координатами
            double x = r.nextDouble(1);
            double y = r.nextDouble(1);
            //расстояние до центра по теореме Пифагора
            double radius = Math.sqrt(x*x + y*y);
            if (radius <= 1.0){
                inside.incrementAndGet();
            }
        }
    }
}
