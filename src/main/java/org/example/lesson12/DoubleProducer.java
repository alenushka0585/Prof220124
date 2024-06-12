package org.example.lesson12;

@FunctionalInterface // проверяет, что абстрактный метод только 1
public interface DoubleProducer {
    double produce(); // абстрактный метод
//    void hello();
    default void time(){ // дефолтный метод
        System.out.println(System.currentTimeMillis());
    }
}
