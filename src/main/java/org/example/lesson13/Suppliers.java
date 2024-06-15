package org.example.lesson13;

import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Suppliers {
    public static void main(String[] args) {
        //Supplier - функциональный интерфейс без параметров, который что-то возвращает

        Supplier<String> stringSupplier = () -> "123";

//        Supplier<Double> lazyDouble = new Supplier<Double>() {
//            @Override
//            public Double get() {
//                try {
//                    Thread.sleep(500); // способ отправить текущий поток в сон
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return Math.random()*100;
//            }
//        };

        Supplier<Double> lazyDouble = () -> {
            try {
                Thread.sleep(500); // способ отправить текущий поток в сон
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Math.random() * 100;
        };

        //Supplier<int>
        IntSupplier fib = new IntSupplier() {
            private int prev = 0;
            private int curr = 1;

            @Override
            public int getAsInt() {
                int next = prev + curr;
                prev = curr;
                curr = next;
                return prev;
            }
        };

        //Supplier можно применить для создания последовательностей
        IntStream.generate(fib).limit(10).forEach(n ->
                System.out.println("fib number " + n));
    }
}
