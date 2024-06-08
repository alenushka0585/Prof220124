package org.example.lesson11;

public class MyHashMap implements MyMap {
    private int size = 0; //колличество пар в Map
    private static final int INITIAL_CAPACITY = 4; // начальное количество ведер
    private static final double LOAD_FACTOR = 0.75; // коэф. загрузки

    // если количество пар больше чем кол-во пар * LOAD_FACTOR, то увеличит в 2 раза

    private Pair[] source = new Pair[INITIAL_CAPACITY];

    private int capacity() {
        return source.length;
    }

    private static class Pair {
        String k;
        String v;
        Pair next;


        public Pair(String k, String v, Pair next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        @Override
        public String toString() {
            return k + ":" + v;
        }
    }

    @Override
    public void put(String k, String v) {
        Pair pair = findPair(k);
        if (pair != null) {
            pair.v = v;
            return;
        }
        if (size() > LOAD_FACTOR * capacity()) {
            resize();
        }

        int bucket = findBucket(k);
        pair = new Pair(k, v,source[bucket]);
        source[bucket] = pair;
        size++;
    }

    private void resize() {
        Pair[] newSource = new Pair[capacity() * 2];
        for (Pair p : source) {
            Pair c = p;
            while (c != null) {
                Pair n = c.next;
                int bucket = Math.abs(c.k.hashCode()) % newSource.length;
                c.next = newSource[bucket];
                newSource[bucket] = c;
                c = n;
            }
        }
        source = newSource;
    }

    @Override
    public String get(String k) {
        // вернуть значение v из пары с этим ключом
        Pair p = findPair(k);
        if (p == null)
            return null;
        return p.v;
    }

    @Override
    public String remove(String k) {
        Pair c = findPair(k);
        if (c == null){
            return null;
        }
        int bucket = findBucket(k);
        c = source[bucket];
        if (c.k.equals(k)){
            source[bucket] = c.next;
            size--;
            return c.v;
        }
        while (c.next != null){
            if(c.next.k.equals(k)){
                Pair d = c.next;
                size--;
                c.next = d.next;
                return d.v;
            }
        }
        return null;
    }

    @Override
    public boolean contains(String k) {
        // проверяет если ли в Map пара с ключом
        return findPair(k) != null;
    }

    private Pair findPair(String k) {
        int bucket = findBucket(k);
        Pair current = source[bucket];
        while (current != null) {
            if (current.k.equals((k))) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private int findBucket(String k) {
        int h = Math.abs(k.hashCode());// делаем положительным
        int r = h % capacity();
        return r;
    }

    @Override
    public int size() {
        return size;
    }
}
