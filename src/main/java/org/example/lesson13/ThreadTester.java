package org.example.lesson13;

public class ThreadTester {
    public static void main(String[] args) {
        Runnable r = new Runnable() { // заготовка
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Thread t = new Thread(r);// поток

        t.start(); // запуск потока на параллельное выполнение
    }
}
