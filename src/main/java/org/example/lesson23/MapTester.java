package org.example.lesson23;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) throws InterruptedException {
        //HashMap не потокобезопасен!
        // Map<String, Integer> map = new HashMap<>();

        // Hashtable несколько медленная
        //Map<String, Integer> map = new Hashtable<>();

        //Лучше использовать ConcurrentHashMap
         Map<String, Integer> map = new ConcurrentHashMap<>();

        //можно обернуть стандартный контейнер оберткой поддерживающей многопоточность
        //Map<String,Integer> map = Collections.synchronizedMap(new HashMap<>());

        //не потокобезопасен - ArrayList
        //потокобезопасная устаревшая и медленная
        //List<String> names = new Vector<>();
        //потокобезопасная обертка над ArrayList
        List<String> names = Collections.synchronizedList(new ArrayList<>());

        List<Integer> result = parallelAdd(map, 100);



        System.out.println(result);
    }

    public static List<Integer> parallelAdd(Map<String, Integer> map, int times) throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < times; j++) {
            map.put("test", 0);
            ExecutorService service = Executors.newFixedThreadPool(4);

            for (int i = 0; i < 10; i++) {
                service.submit(new MyRunnable(map));
            }

            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            result.add(map.get("test"));
        }
        return result;
    }

    @AllArgsConstructor
    public static class MyRunnable implements Runnable {
        private Map<String, Integer> map;

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                map.computeIfPresent("test", (k, v) -> v + 1);
            }
        }
    }
}
