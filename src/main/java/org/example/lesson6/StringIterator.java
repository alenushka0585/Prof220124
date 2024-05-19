package org.example.lesson6;

import java.util.Iterator;

public class StringIterator implements Iterator<Character> {

    private char[] data;
    private int position = -1;

    public StringIterator(String s) {
        data = s.toCharArray();
    }

    @Override
    public boolean hasNext() {
        return ++position < data.length;
    }

    @Override
    public Character next() {
        return data[position];
    }
}
