package org.example.lesson5.implementation;

public class MyArrayList implements MyList {
    // количество элементов;
    private int size = 0;
    //    массив для хранения
    private int[] data;
    //    начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    public MyArrayList() {
        data = new int[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size(); i++) {
            if (value == data[i]) {
                return true;
            }
        }
        return false;
    }

    //изменение элемента по индексу

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public void add(int value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapacity() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size(); i++) {
            if (i != size() - 1) {
                result = result + data[i] + ",";
            } else {
                result = result + data[i] + "]";
            }
        }
        return result;
    }

    @Override
    public void add(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size() - 1; i >= index ; i--)  {
            data[i + 1] = data[i];
        }

        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index + 1; i < size(); i++) {
            data[i - 1] = data[i];
        }
        size--;
    }


@Override
public int get(int index) {
    if (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }
    return data[index];
}

}