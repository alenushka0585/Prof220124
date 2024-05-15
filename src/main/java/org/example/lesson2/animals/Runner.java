package org.example.lesson2.animals;

public interface Runner {
    int id = 2; // может быть состояние
    default void run(){
        System.out.println("I'm running");
    }
}
