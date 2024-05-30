package org.example.lesson7;

import org.example.lesson5.implementation.MyList;

public interface MyLinkedList extends MyList {
    int removeFirst();
    void addFirst(int i);
    int getFirst();

    int removeLast();
    void addLast(int i);
    int getLast();
}
