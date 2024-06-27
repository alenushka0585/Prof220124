package org.example.algoritms.hm5;

import java.util.Arrays;

public class HomeWork {
//    Level 1
//    а. Приведите пример использования амортизированного анализа в практике.

//    Пример амортизированного анализа можно увидеть в реализации стека с использованием двух очередей.
//    Рассмотрим операцию pop, которая требует перемещения всех элементов из одной очереди в другую,
//    что может занять время O(n). Однако, если рассматривать последовательность операций,
//    можно доказать, что среднее время выполнения операции будет O(1).


//    b. Написать код, который принимает на вход массив и число элементов,
//    и возвращает новый массив, который содержит все элементы исходного массива
//    и заданное число новых элементов.
    public static int[] expandArray(int[] originalArray, int newElements) {
        // Создаем новый массив большего размера
        int[] newArray = new int[originalArray.length + newElements];

        // Копируем элементы исходного массива в новый массив
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        // Возвращаем новый массив
        return newArray;
    }

    public static void main(String[] args) {
// Пример использования
        int[] originalArray = {1, 2, 3, 4, 5};
        int newElements = 3;

        int[] newArray = expandArray(originalArray, newElements);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("New Array: " + Arrays.toString(newArray));
    }
}


