package org.example.lesson5.implementation;

import org.example.lesson2.A;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

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
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < size();
            }

            @Override
            public Integer next() {
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
    public Iterator<Integer> backward() {
        return new Iterator<Integer>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = size();

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return --position >= 0;
            }

            @Override
            public Integer next() {
                // должна возвращать текущий элемент MyArrayList
                return get(position);
            }
        };
    }

    public void sort() {
        int n = size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Обмен arr[j] и arr[j+1]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Если элементы уже отсортированы
        }
    }

    public Iterator<Integer> sortedIterator() {
        int[] source = new int[size()];
        System.arraycopy(data, 0, source, 0, size());
        Arrays.sort(source);

        return new Iterator<Integer>() {

            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < source.length;
            }

            @Override
            public Integer next() {
                // должна возвращать текущий элемент MyArrayList
                return source[position];
            }
        };
    }

    public ListIterator<Integer> listIterator() {
        return new ListIterator<Integer>() {
            // индекс элемента из MyArrayList который мы обходим
            private int position = -1;

            @Override
            public boolean hasNext() {
                // увеличиваем позицию и проверяем что она внутри MyArrayList
                return ++position < size();
            }

            @Override
            public Integer next() {
                // должна возвращать текущий элемент MyArrayList
                return get(position);
            }

            @Override
            public boolean hasPrevious() {
                return --position >= 0;
            }

            @Override
            public Integer previous() {
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
            public void set(Integer integer) {
                MyArrayList.this.set(position, integer);
            }

            @Override
            public void add(Integer integer) {
                MyArrayList.this.add(integer);
            }

        };
    }
}