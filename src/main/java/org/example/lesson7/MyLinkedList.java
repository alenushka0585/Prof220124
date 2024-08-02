package org.example.lesson7;

import org.example.lesson5.implementation.MyList;

public interface MyLinkedList<T> extends MyList <T> {
    T removeFirst();
    void addFirst(T i);
    T getFirst();

    T removeLast();
    void addLast(T i);
    T getLast();
}
