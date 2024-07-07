package org.example.lesson5.implementation;

import org.example.lesson2.A;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyArrayList<T> implements MyList <T>, Comparable<T> {
    // количество элементов;
    private int size = 0;
    //    массив для хранения
    private T[] data;
    //    начальный размер массива
    private static final int INITIAL_CAPACITY = 4;

    public MyArrayList() {
        data = (T[]) new Object [INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i++) {
            if (value == data[i]) {
                return true;
            }
        }
        return false;
    }

    //изменение элемента по индексу

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public void add(T value) {
        if (size == data.length) {
            increaseCapacity();
        }
        data[size] = value;
        size++;
    }

    private void increaseCapacity() {
        T[] newData = (T[]) new Object[data.length * 2];
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
    public void add(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            increaseCapacity();
        }
        for (int i = size() - 1; i >= index; i--) {
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
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < size();
            }

            @Override
            public T next() {
                // должна возвращать текущий элемент MyArrayList
                return get(position);
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(position--); //для ссылки на экземпляр класса, а не итератора
            }
        };
    }

    @Override
    public Iterator<T> backward() {
        return new Iterator<T>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = size();

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return --position >= 0;
            }

            @Override
            public T next() {
                // должна возвращать текущий элемент MyArrayList
                return get(position);
            }
        };
    }

//    public void sort() {
//        int n = size();
//        boolean swapped;
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (data[j] > data[j + 1]) {
//                    // Обмен arr[j] и arr[j+1]
//                    T temp = data[j];
//                    data[j] = data[j + 1];
//                    data[j + 1] = temp;
//                    swapped = true;
//                }
//            }
//            if (!swapped) break; // Если элементы уже отсортированы
//        }
//    }

    public Iterator<T> sortedIterator() {
        T[] source = (T[]) new Object[size()];
        System.arraycopy(data, 0, source, 0, size());
        Arrays.sort(source);

        return new Iterator<T>() {

            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < source.length;
            }

            @Override
            public T next() {
                // должна возвращать текущий элемент MyArrayList
                return source[position];
            }
        };
    }

    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < size();
            }

            @Override
            public T next() {
                // должна возвращать текущий элемент MyArrayList
                return get(position);
            }

            @Override
            public boolean hasPrevious() {
                return --position >= 0;
            }

            @Override
            public T previous() {
                return get(position);
            }

            @Override
            public int nextIndex() {
                return position + 1;
            }

            @Override
            public int previousIndex() {
                return position - 1;
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(position--);
            }

            @Override
            public void set(T integer) {
                MyArrayList.this.set(position, integer);
            }

            @Override
            public void add(T integer) {
                MyArrayList.this.add(integer);
            }

        };
    }

    @Override
    public int compareTo(T o) {
        return 0;
    }
}