package org.example.lesson23;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTester {
    public static void main(String[] args) {

      MyCallable callable = new MyCallable();
      //не работает, так как callable это не runnable
     // new Thread(callable).start();

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        String result = null;
        try {
            //main поток заблокируется до готовности результата
            result = futureTask.get();
           // futureTask.isDone() готов ли результат
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("result: " + result);
    }

    public static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            Thread.sleep(500);

            return ""  + System.currentTimeMillis();
        }
    }
}
