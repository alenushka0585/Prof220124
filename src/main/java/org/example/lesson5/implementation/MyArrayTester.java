package org.example.lesson5.implementation;

public class MyArrayTester {
    public static void main(String[] args) {
        MyList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.contains(5));
        System.out.println(list.contains(3));
        System.out.println(list);

        list.add(4);
        list.add(5);
        System.out.println(list);

        list.set(4,50);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);

        list.add(2,10);
        System.out.println(list);
    }
}
