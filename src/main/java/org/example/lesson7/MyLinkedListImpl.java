package org.example.lesson7;

import java.util.Iterator;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
    // на голову листа
    private Node head;

    @Override
    public String toString() {
        // [1,3]
        String result = "[";
        Node<T> n = head;
        while (n != null) {
            T v = n.getValue();
            result += v;
            n = n.getNext();
            if (n != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    //    узел листа, содержит ссылки и значения на предыдущий/следующий эл
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        Node<T> n = head;
        while (n != null) {
            if (n.getValue().equals(value)) {
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            if (n != null) {
                n = n.getNext();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        if (n == null) {
            throw new IndexOutOfBoundsException();
        }
        return n;
    }

    @Override
    public void set(int index, T value) {
        Node <T> n = getNodeByIndex(index);
        if (n != null) {
            n.setValue(value);
        }
    }

//     добавляет значение в конец
    @Override
    public void add(T value) {
        size++;
        Node <T> newNode = new Node(value, null, null);
        Node<T> n = head;

        if (n == null) {
            head = newNode;
        } else {
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(newNode);
        }
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || (index > size())) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        //элементов нет - вставляем новый узел в head
        if (index == 0) {
            Node<T> h = head;
            head = new Node<T>(value, h, null);
        }else {
            Node<T> prev = getNodeByIndex(index -1);
            Node<T> next = prev.next;
            Node<T> newNode = new Node<T>(value, next, prev);
            prev.setNext(newNode);
        }
    }

    @Override
    public void remove(int index) {
        if (index < 0 || (index > size())) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
           if (head == null){
               return;
           }
           head = head.next;
           size--;
           return;
        } else {
            Node<T> prev = getNodeByIndex(index -1);
            Node<T> next = getNodeByIndex(index).getNext();
            prev.setNext(next);
            size--;
        }
    }

    @Override
    public T get(int index) {
        Node<T> n = getNodeByIndex(index);
        return n.getValue();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T result = node.getValue();
                node = node.getNext();
                return result;
            }

        };
    }

    @Override
    public Iterator<T> backward() {
        return null;
    }

    @Override
    public T removeFirst() {
        T result = get(0);
        remove(0);
        return result;
    }

    @Override
    public void addFirst(T i) {
        add(0, i);
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T removeLast() {
        T result = get(size()-1);
        remove(size()-1);
        return result;
    }

    @Override
    public void addLast(T i) {
        add(size(), i);
    }

    @Override
    public T getLast() {
        return get(size()-1);
    }
}
