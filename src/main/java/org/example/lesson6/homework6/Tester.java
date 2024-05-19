package org.example.lesson6.homework6;

import org.example.lesson5.implementation.MyArrayList;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
//      1. Есть список countries {"Andorra", "Belize", "Cayman", "France",
//      "Argentina", "Cuba", "Sweden", "austria"} и список
//
//      words {"Andorra", "Canada", "First", "candy", "austria", "Argentina",
//      "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard",
//      "Cuba"}
//      Оставить в countries только те страны, которые присутствуют также и в
//      списке words

        List<String> countries = new ArrayList<>(
                Arrays.asList("Andorra", "Belize", "Cayman", "France", "Argentina",
                        "Cuba", "Sweden", "austria" )
        );

        List<String> words = new ArrayList<>(
                List.of("Andorra", "Canada", "First", "candy",
                        "austria", "Argentina", "wood", "parrot", "cat",
                        "Alan", "Cuba", "Finland", "Axelrod", "Avangard", "Cuba" )
        );

        System.out.println(countriesFromTwoLists(countries, words));


//        Напишите метод, принимащий два массива целых и возвращающий список из
//        общих элементов этих массивов.

        int[] arr1 = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = new int[]{1, 0, 6, 15, 6, 4, 7, 0};

        System.out.println(commonElements(arr1,arr2));



//        3. Напишите итератор для перебора MyArrayList в порядке возрастания значений элементов

        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(50);
        myArrayList.add(2);
        myArrayList.add(10);
        myArrayList.add(-8);
        myArrayList.add(0);
        myArrayList.add(15);

        System.out.println(myArrayList);

        Iterator<Integer> myArraListSortedIterator= myArrayList.sortedIterator();
        while (myArraListSortedIterator.hasNext()){
            System.out.println(myArraListSortedIterator.next());
        }

        System.out.println(myArrayList);

        System.out.println("-------------------------------------------");

        //     4. Напишите для MyArrayList ListIterator возвращая его в методе listIterator(),
//    реализовать операции
//    boolean hasNext()
//    boolean  hasPrevious()
//    E next()
//    E previous()
//    остальные можно не реализовывать

        ListIterator<Integer> myArrayListIterator = myArrayList.listIterator();
        System.out.println(myArrayListIterator.hasNext());
        System.out.println("next" + myArrayListIterator.next());
        System.out.println(myArrayListIterator.hasNext());
        System.out.println("next" + myArrayListIterator.next());
        System.out.println(myArrayListIterator.hasNext());
        System.out.println("next" + myArrayListIterator.next());
        System.out.println(myArrayListIterator.hasPrevious());
        System.out.println(myArrayListIterator.previous());
        System.out.println(myArrayListIterator.hasPrevious());
        System.out.println(myArrayListIterator.previous());
    }




    public static List<String> countriesFromTwoLists(List<String> countries, List<String> words) {
        if (countries == null || countries.isEmpty()
                || words == null || words.isEmpty()) {
            return null;
        }

        List<String> result = new ArrayList<>();
        for (int i = countries.size() - 1; i >= 0; i--) {
            if (!words.contains(countries.get(i))) {
                countries.remove(i);
            }
        }

        return countries;
    }


    private static List<Integer> commonElements(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        if (arr1.length == 0 || arr1 == null
                || arr2.length == 0 || arr2 == null ) {
            return null;
        }
        for (Integer i1: arr1){
            for (Integer i2 : arr2){
                if (i1.equals(i2)){
                    result.add(i1);
                }
            }
        }

        return result;
    }
}
