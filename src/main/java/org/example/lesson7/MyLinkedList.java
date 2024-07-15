package org.example.lesson7;

import org.example.lesson5.implementation.MyList;

public interface MyLinkedList<T> extends MyList <T> {
    int removeFirst();
    void addFirst(T i);
    int getFirst();

    int removeLast();
    void addLast(T i);
    int getLast();
}
