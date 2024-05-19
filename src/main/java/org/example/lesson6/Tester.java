package org.example.lesson6;

import org.example.lesson5.implementation.MyArrayList;
import org.example.lesson5.implementation.MyList;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        //Iterator - это интерфейс  https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
        //позволяет обойти любой набор элементов использую - hasNext и next

        //Set, Map коллекции без индекса

        List<String> capitals = new ArrayList<>(
//                Arrays.asList("Bogota", "Brazilia", "Buenos Aires", "Santiago")
                List.of("Bogota", "Brazilia", "Buenos-Aires", "Santiago") // второй вариант инициализации
        );

        Iterator<String> capitalsIterator = capitals.iterator();

        while (capitalsIterator.hasNext()) {
            System.out.println("next capital: " + capitalsIterator.next());
        }

//        for (int i = 0; i < capitals.size(); i++) {
//            if (capitals.get(i).startsWith("B")){
//                capitals.remove(i);
//            }
//        }

//       for (String c : capitals) {
//            if (c.startsWith("B")){
//                capitals.remove(c); // обход по итератору, удаление элемента не через итератора
//            }
//        }

//        for (int i = capitals.size()-1; i >=0; i--) {
//            if (capitals.get(i).startsWith("B")){
//                capitals.remove(i);
//            }
//        }

        //удалять элементы из контейнера можно только через неиспользуемый ранее итератор

        Iterator<String> newCapitalsIterator = capitals.iterator();

        while (newCapitalsIterator.hasNext()) {
            if (newCapitalsIterator.next().startsWith("B")) {
                newCapitalsIterator.remove();
            }
        }

        System.out.println("After remove: " + capitals);

        List<Integer> integerList = List.of(-2, 1, 2, 3, 4);
        // List.of и Arrays.asList дает возвращают лист только для чтения - Immutable List / неизменяемый

        Iterator<Integer> integerIterator = integerList.iterator();
        int sum = 0;

        while (integerIterator.hasNext()) {
            sum += integerIterator.next();
        }
        System.out.println(sum);

        Set<String> rivers = Set.of("Vistula", "Rein", "Danube");
        //нет обращения по индексу

        Iterator<String> riversIterator = rivers.iterator();
        while (riversIterator.hasNext()) {
            System.out.println(riversIterator.next());
        }

        MyList myList = new MyArrayList();
        myList.add(1);
        myList.add(2);
        myList.add(3);

        Iterator<Integer> myListIterator = myList.iterator();
        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }

        Iterator<Integer> myListBackwardIterator = myList.backward();
        while (myListBackwardIterator.hasNext()) {
            System.out.println(myListBackwardIterator.next());
        }

        Iterator<Integer> myListRemoveIterator = myList.iterator();

        while (myListRemoveIterator.hasNext()) {
            if (myListRemoveIterator.next() % 2 == 0) {
                myListRemoveIterator.remove();
            }
        }

        System.out.println(myList);



        for(String c: capitals){
            System.out.println("capital: " + c);
        }
// чтобы работал for each, нужно чтобы extendiл Iterable
        for (Integer i: myList){
            System.out.println("myList element: " + i);
        }

        List<String> names = new ArrayList<>(
                List.of("Max", "Alina", "Alexander", "Sam")
        );
        ListIterator<String> namesIterator = names.listIterator();
        namesIterator.hasNext();
        System.out.println(namesIterator.next());
        namesIterator.hasNext();
        System.out.println(namesIterator.next());
        namesIterator.hasPrevious();
        System.out.println(namesIterator.previous());
        namesIterator.hasPrevious();
        System.out.println(namesIterator.previous());

        ArrayIterator arrayIterator = new ArrayIterator(new int[]{1,2,3,4,5});

        while (arrayIterator.hasNext()){
            System.out.println("array element: " + arrayIterator.next());
        }

        StringIterator stringIterator = new StringIterator("hello");

        while (stringIterator.hasNext()){
            System.out.println("String Iterrator: " + stringIterator.next());
        }

    }
}
