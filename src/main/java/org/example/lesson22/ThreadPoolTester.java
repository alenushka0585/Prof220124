package org.example.lesson22;

import java.util.Random;
import java.util.concurrent.*;

/*
Thread pool - пул потоков
набор потоков выполнения (Thread)
очередь заданий (Runnable, Callable
 */
public class ThreadPoolTester {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2); // набор из 2 и более потоков

        //Runnable r = new Work();
        //переменные созданные внутри методов, тип которых очевиденб
        //можно создавать как var

        var r = new Work();
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);
        service.submit(r);

        //создаем экземпляр Callable
        var c = new Job();
        //Future - будущий результат
        Future<String> future = service.submit(c);

        //Future.get() блокирует поток, в котором выполняется, пока результат не станет доступен
//        try {
//            System.out.println("Callable result: " + future.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        if (future.isDone()){
            System.out.println("Result is ready");
        } else {
            System.out.println("Result is not ready");
        }

        service.shutdown(); // дожидается выполнения всех заданий в очереди
     //   service.shutdownNow()// остановить пул потоков не дожидаясь завершения всех заданий

    }

    static class Job implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            return "" +  System.currentTimeMillis();

        } // String  - тип того, что нужно возвратить

    }

    static class Work implements Runnable{

        @Override
        public void run() {
            Random r = new Random();
            try {
                Thread.sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread with id: " +
                    Thread.currentThread().getId());
        }
    }
}
