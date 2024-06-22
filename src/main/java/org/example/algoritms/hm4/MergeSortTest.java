package org.example.algoritms.hm4;

import java.util.Arrays;

public class MergeSortTest {
    public static void main(String[] args) {
//        У вас есть список из n элементов, которые представляют собой оценки студентов по математике.
//        Вам нужно отсортировать этот список в порядке убывания оценок с использованием алгоритма сортировки Merge sort.
//        Для решения этой задачи напишите функцию, которая принимает на вход список оценок и возвращает новый список,
//        отсортированный в порядке убывания.
//        {3, 8, 1, 9, 4, 2, 7, 6, 5 };

        int[] grades = new int[]{3, 8, 1, 9, 4, 2, 7, 6, 5};

        System.out.println("Before sort: " + Arrays.toString(grades));

        mergeSort(grades);
        System.out.println("After sort: " + Arrays.toString(grades));


//        Дан массив объектов типа Person, который содержит поля name (тип String) и age (тип int).
//        Необходимо отсортировать этот массив по возрасту в порядке убывания, используя алгоритм Merge sort.
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 20),
                new Person("Charlie", 30),
                new Person("David", 35),
                new Person("Eve", 28)
        };

        System.out.println("Before sort: " + Arrays.toString(people));

        mergeSort(people);
        System.out.println("After sort: " + Arrays.toString(people));
    }

    private static void mergeSort(Person[] arr) {
        int lengthArr = arr.length;

        if (lengthArr == 1) {
            return;
        }

        int mid = lengthArr / 2;
        Person[] leftArr = new Person[mid];
        Person[] rightArr = new Person[lengthArr - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = 0; i < lengthArr - mid; i++) {
            rightArr[i] = arr[i + mid];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(Person[] arr, Person[] leftArr, Person[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex].getAge() > rightArr[rightIndex].getAge()) {
                arr[arrIndex] = leftArr[leftIndex];
                leftIndex++;
                arrIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
                arrIndex++;
            }
        }

        while (leftIndex < leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while (rightIndex < rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }

    private static void mergeSort(int[] arr) {
        int lengthArr = arr.length;

        if (lengthArr == 1) {
            return;
        }

        int mid = lengthArr / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[lengthArr - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = 0; i < lengthArr - mid; i++) {
            rightArr[i] = arr[i + mid];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;

        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex] > rightArr[rightIndex]) {
                arr[arrIndex] = leftArr[leftIndex];
                leftIndex++;
                arrIndex++;
            } else {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
                arrIndex++;
            }
        }

        while (leftIndex < leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while (rightIndex < rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }
}
