package org.example.lesson22.homework;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MyRunnable implements Runnable {

//    1. Создать класс MyRunnable который
//    a. принимает на вход список строк
//    b. распечатывает каждый элемент и ждет одну секунду перед распечатыванием следующего элемента
//    c. создать и запустить поток, принимающий экземпляр этого Runnable с произвольным списком

    private List<String> list;

    @Override
    public void run() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                List.of("Petra", "Ivan", "Gesela", "Yelena")
        );
        Thread thread = new Thread(new MyRunnable(list));
        thread.start();
    }
}
