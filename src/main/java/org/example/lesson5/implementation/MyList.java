package org.example.lesson5.implementation;

import java.util.Iterator;

//интефейс ArrayList для хранения целых
public interface MyList <T>  extends Iterable<T>{

//    https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html
    int size();
    boolean contains (T value);
    void set(int index, T value);
    void add(T value);
    void add(int index, T value);
    void remove(int index);
    T get(int index);

    Iterator<T> iterator();
    Iterator<T> backward();
}
