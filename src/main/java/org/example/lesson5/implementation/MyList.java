package org.example.lesson5.implementation;

//интефейс ArrayList для хранения целых
public interface MyList {
    int size();
    boolean contains (int value);
    void set(int index, int value);
    void add(int value);
    void add(int index, int value);
    void remove(int index);
    int get(int index);
}
