package org.example.lesson8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetTester {
    // HashSet
    // если мы хотим наш класс в хэш-контейнере, нужно соблюдать правила
    // 1. реализовать equals() + hashCode() (целое число)
    // 2. hashCode не менялся во время жизни объекта
    // 3. если объекты эквиваленты, то hashCode должны быть одинаковы

    public static void main(String[] args) {
        Set<Point> points = new HashSet<>(
                Arrays.asList(
                        new Point(10,20), // разные адреса в памяти
                        new Point(200,200),
                        new Point(10,20)) // не эквивалентны
        );

        System.out.println("points size: " + points.size());

        Set<GoodPoint> goodPoints = new HashSet<>(
                Arrays.asList(
                        new GoodPoint(10,20),
                        new GoodPoint(200,200),
                        new GoodPoint(10,20))
        );

        System.out.println("goodpoints: " + goodPoints);

        Set<GoodPoint> newGoodPoints = new HashSet<>();
        GoodPoint gp1 = new GoodPoint(10, 20);
        newGoodPoints.add(gp1);
        System.out.println("newGoodPoints size: " + newGoodPoints.size());

        gp1.setX(100);
        gp1.setY(200);
        newGoodPoints.add(gp1);
        System.out.println(newGoodPoints);
    }


}
