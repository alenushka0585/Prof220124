//package org.example.lesson7;
//
//import java.util.Iterator;
//
//public class MyLinkedListImpl implements MyLinkedList {
//    // на голову листа
//    private Node head;
//
//    @Override
//    public String toString() {
//        // [1,3]
//        String result = "[";
//        Node n = head;
//        while (n != null) {
//            int v = n.getValue();
//            result += v;
//            n = n.getNext();
//            if (n != null) {
//                result += ", ";
//            }
//        }
//        result += "]";
//        return result;
//    }
//
//    //    узел листа, содержит ссылки и значения на предыдущий/следующий эл
//    private static class Node {
//        private int value;
//        private Node next;
//        private Node previous;
//
//        public Node(int value, Node next, Node previous) {
//            this.value = value;
//            this.next = next;
//            this.previous = previous;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public Node getNext() {
//            return next;
//        }
//
//        public void setNext(Node next) {
//            this.next = next;
//        }
//
//        public Node getPrevious() {
//            return previous;
//        }
//
//        public void setPrevious(Node previous) {
//            this.previous = previous;
//        }
//    }
//
//    private int size = 0;
//
//    @Override
//    public int size() {
//        return size;
//    }

//    @Override
//    public boolean contains(int value) {
//        Node n = head;
//        while (n != null) {
//            if (n.getValue() == value) {
//                return true;
//            } else {
//                n = n.getNext();
//            }
//        }
//        return false;
//    }

//    private Node getNodeByIndex(int index) {
//        if (index < 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        Node n = head;
//        for (int i = 0; i < index; i++) {
//            if (n != null) {
//                n = n.getNext();
//            } else {
//                throw new IndexOutOfBoundsException();
//            }
//        }
//        if (n == null) {
//            throw new IndexOutOfBoundsException();
//        }
//        return n;
//    }

//    @Override
//    public void set(int index, int value) {
//        Node n = getNodeByIndex(index);
//        if (n != null) {
//            n.setValue(value);
//        }
//    }

    // добавляет значение в конец
//    @Override
//    public void add(int value) {
//        size++;
//        Node newNode = new Node(value, null, null);
//        Node n = head;
//
//        if (n == null) {
//            head = newNode;
//        } else {
//            while (n.getNext() != null) {
//                n = n.getNext();
//            }
//            n.setNext(newNode);
//        }
//    }

//    @Override
//    public void add(int index, int value) {
//        if (index < 0 || (index > size())) {
//            throw new IndexOutOfBoundsException();
//        }
//        size++;
//        //элементов нет - вставляем новый узел в head
//        if (index == 0) {
//            Node h = head;
//            head = new Node(value, h, null);
//        }else {
//            Node prev = getNodeByIndex(index -1);
//            Node next = prev.next;
//            Node newNode = new Node(value, next, prev);
//            prev.setNext(newNode);
//        }
//    }

//    @Override
//    public void remove(int index) {
//        if (index < 0 || (index > size())) {
//            throw new IndexOutOfBoundsException();
//        }
//
//        if (index == 0) {
//           if (head == null){
//               return;
//           }
//           head = head.next;
//           size--;
//           return;
//        } else {
//            Node prev = getNodeByIndex(index -1);
//            Node next = getNodeByIndex(index).getNext();
//            prev.setNext(next);
//            size--;
//        }
//    }

//    @Override
//    public int get(int index) {
//        Node n = getNodeByIndex(index);
//        return n.getValue();
//    }

//    @Override
//    public Iterator<Integer> iterator() {
//
//        return new Iterator<>() {
//
//            Node node = head;
//
//            @Override
//            public boolean hasNext() {
//                return node != null;
//            }
//
//            @Override
//            public Integer next() {
//                int result = node.getValue();
//                node = node.getNext();
//                return result;
//            }
//
//        };
//    }

//    @Override
//    public Iterator<Integer> backward() {
//        return null;
//    }
//
//    @Override
//    public int removeFirst() {
//        int result = get(0);
//        remove(0);
//        return result;
//    }

//    @Override
//    public void addFirst(int i) {
//        add(0, i);
//    }
//
//    @Override
//    public int getFirst() {
//        return get(0);
//    }
//
//    @Override
//    public int removeLast() {
//        int result = get(size()-1);
//        remove(size()-1);
//        return result;
//    }

//    @Override
//    public void addLast(int i) {
//        add(size(), i);
//    }
//
//    @Override
//    public int getLast() {
//        return get(size()-1);
//    }
//}
