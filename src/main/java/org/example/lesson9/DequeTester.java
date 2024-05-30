package org.example.lesson9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DequeTester {
    public static void main(String[] args) {
        //Deque - Double-Ended Queue
        Deque<Integer> deque = new ArrayDeque<>(
                Arrays.asList(1,2,3,4,5)
        );

        System.out.println(deque);

        deque.addFirst(0);
        deque.addLast(6);
        System.out.println(deque);

        System.out.println("remove first: " + deque.removeFirst());
        System.out.println("remove last: " + deque.removeLast());
    }
}
