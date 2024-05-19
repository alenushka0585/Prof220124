package org.example.lesson6;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {
    public ArrayIterator(int[] data) {
        this.data = data;
    }

    private int[] data;
    private int position = -1;

    @Override
    public boolean hasNext() {
        return ++position < data.length;
    }

    @Override
    public Integer next() {
        return data[position];
    }
}
