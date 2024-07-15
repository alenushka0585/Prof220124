//package org.example.lesson7;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//
//public class MyLinkedListTester {
//    public static void main(String[] args) {
//        MyLinkedList list = new MyLinkedListImpl();
//        list.add(10);
//        list.add(5);
//
//        System.out.println(list);
//        System.out.println(list.contains(20));
//        System.out.println(list.contains(10));
//
//        list.set(0, 100);
//        System.out.println(list);
//
//        System.out.println(list.get(0));
//
//        list.add(0,1000);
//        System.out.println(list);
//
//        list.add(3,1);
//        System.out.println(list);
//
//        list.add(2,2);
//        System.out.println(list);
//
//        list.remove(0);
//        System.out.println(list);
//        list.remove(1);
//        System.out.println(list);
//
//        System.out.println("__________________");
//
//        Iterator<Integer> listIterator = list.iterator();
//
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }
//
//        list.removeFirst();
//        System.out.println("After removing first " +list);
//        list.removeLast();
//        System.out.println("After removing last " +list);
//
//        list.addFirst(50);
//        System.out.println("After adding first " +list);
//        list.addLast(55);
//        System.out.println("After adding last " +list);
//
//    }
//}
