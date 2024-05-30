package org.example.lesson9;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {
    public static void main(String[] args) {
// Queue - очередь - элементы добавляются в конец а получаются из начала

// добавление в конец
// boolean add(E) - выбрасывает IllegalStateException если нет места
// boolean offer(E) - возвращает false если элемент не получилось добавить

// получение элемента из начала
// E remove() - убирает и возвращает первый элемент из очереди NoSuchElementException
// E poll() - убирает и возвращает первый элемент из очереди null если элементов нет

// инспекция
// E element() возвращает первый элемент NoSuchElementException
// E peek() возвращает первый элемент либо null если очередь пуста
//        PriorityQueue - очередь с приоритетом, храняться в порядке по возрастанию

//        boolean isEmpty();

        Queue<String> bankQueue = new LinkedList<>();

        bankQueue.add("Max");
        bankQueue.add("Marta");
        bankQueue.add("Ivan");
        bankQueue.offer("Petra");

        while (!bankQueue.isEmpty()){
            System.out.println(bankQueue.poll());
        }

        System.out.println(bankQueue);


        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("One");
        priorityQueue.add("Two");
        priorityQueue.add("Three");
        priorityQueue.add("Four");
        priorityQueue.add("Fife");


        while (!priorityQueue.isEmpty())
        {
            System.out.println("digit: " + priorityQueue.poll());
        }
    }
}
