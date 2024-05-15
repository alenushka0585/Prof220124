package org.example.lesson5.implementation;

import java.util.Iterator;

//интефейс ArrayList для хранения целых
public interface MyList {
    int size();
    boolean contains (int value);
    void set(int index, int value);
    void add(int value);
    void add(int index, int value);
    void remove(int index);
    int get(int index);

    Iterator<Integer> iterator();
    Iterator<Integer> backward();
}
