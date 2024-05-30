package org.example.lesson8;

import java.util.*;

public class SetTester {
    // List - коллекция в которой элементы доступны по индексу
    //      ArrayList - доступ к элементу O(1) вставка/удадение из начала O(N)
    //      LinkedList - доступ к элементу O(N) работа с началом/концом O(1)
    // Set - набор не повторяющихся элементов
    //      HashSet - вставка и проверка наличия занимают O(1) - занимает много памяти, хранит элементы в произвольном порядке
    //      LinkedHashSet - хранит элементы в порядке вставки
    //      TreeSet - хранит элементы "по-возрастанию"

//    https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
    public static void main(String[] args) {
        Set<String> groups = new HashSet<>(
                Arrays.asList("Abba", "Beatles", "Rolling Stones")
        );

        System.out.println(groups.add("Deep Purple"));
        System.out.println(groups.add("Led Zeppelin"));
        System.out.println(groups.add("Abba"));
        System.out.println("groups: " + groups);
        System.out.println("groups size: " + groups.size());

        System.out.println("contains Abba:" + groups.contains("Abba"));
        System.out.println("contains Boney M:" + groups.contains("Boney M"));

        System.out.println(groups.remove("Beatles"));
        System.out.println(groups.remove("Eurithmics"));



        Set<String> music = new TreeSet<>(groups);

        System.out.println("music: " + music);

        for (String s : groups){
            System.out.println(s);
        }


        for (Iterator<String> groupsIterator = groups.iterator(); groupsIterator.hasNext(); ) {
            System.out.println("iterator group: " + groupsIterator.next());
        }

        Iterator<String> groupsIterator1 = groups.iterator();
        while (groupsIterator1.hasNext()){
            if (groupsIterator1.next().equals("Abba")){
                groups.remove("Abba");
            }
        }

        System.out.println(groups);

        System.out.println(getUniqueWords("max sveta elena alexander dima sam max sam antonina"));

        TreeSet<String> month = new TreeSet<>(
                Arrays.asList("January", "February", "March","April", "May",
                        "June", "July", "August", "September", "October", "November", "December")
        );

        System.out.println(month);

        System.out.println(month.subSet("D", "M")); // все элементы между
        System.out.println(month.tailSet("P")); //все элементы выше
        System.out.println(month.headSet("C")); // все элементы ниже

        System.out.println("duplicates: " + getDuplicates("max sveta elena alexander dima sam max sam antonina"));
    }

    // HashSet
    // если мы хотим наш класс в хэш-контейнере, нужно соблюдать правила
    // 1. реализовать equals() + hashCode() (целое число)
    // 2. hashCode не менялся во время жизни объекта
    // 3. если объекты эквиваленты, то hashCode должны быть одинаковы

    public static Set<String> getUniqueWords (String s){
        Set<String> collection = new HashSet<>(
                Arrays.asList(s.split(" "))
        );
        return collection;
    }

    public static Set<String> getDuplicates (String s){
        String [] words = s.split(" ");
        Set<String> w = new HashSet<>();
        Set<String> d = new HashSet<>();
        for (String word: words){
            boolean result = w.add(word);
            if(!result){
                d.add(word);
            }
        }
        return d;
    }
}
