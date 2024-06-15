package org.example.lesson11;

import java.util.*;
import static java.util.AbstractMap.SimpleEntry;

public class MapTester {
    /*
     Map хранит соответствие "ключ" -> "значение"
     HashMap - неупорядоченная, скорость о(1)
     LinkedHashMap - порядок вставки сохроняется
     HashTable - потокобезопасная HashMap
     TreeMap - сортированная по ключу
     */
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("Germany", "Berlin");
        capitals.put("France", "Paris");
        System.out.println(capitals);
        System.out.println(capitals.get("Germany")); // Berlin
        System.out.println(capitals.get("Belgium")); // null

        System.out.println(capitals.size()); //2
        System.out.println(capitals.put("UK", "London"));// null при вставки того, чего не было
        System.out.println(capitals.put("France", "Lille"));// предыдущее значение возвращается
        //при вставке со старым ключом, заменяется старое значени

        System.out.println(capitals);

        System.out.println(capitals.containsKey("Germany"));// true
        System.out.println(capitals.containsValue("London"));// true

        System.out.println(capitals.keySet());// Set всех ключей
        System.out.println(capitals.values());// Collection всех значений, так как значения могут повторяться

        for (String k : capitals.keySet()) {
            System.out.println(k + ":" + capitals.get(k));
        }

        System.out.println(capitals.containsKey("Estonia"));//false
        System.out.println(capitals.containsValue("Tallinn"));//false

        Map<String, Integer> townLength = new HashMap<>();

        for (String k : capitals.keySet()) {
            townLength.put(k, capitals.get(k).length());
        }

        System.out.println(townLength);

        for (Map.Entry<String, String> pair : capitals.entrySet()) {
            // пара это ключ значение
            System.out.println(pair.getKey() + ":" + pair.getValue());
        }

        TreeMap<Integer, String> fruits = new TreeMap<>(
                Map.of(89, "banana", 67, "grapes", 52,
                        "apple", 61, "kiwi")
        );
        fruits.put(100, "Pear");
        System.out.println(fruits);

        System.out.println(fruits.headMap(65)); // ниже по ключу
        System.out.println(fruits.tailMap(80)); // выше по ключу

        String s = "один раз это один раз но только один раз";

        System.out.println(countWords(s));

        String sentence = "hello how exactly was his eye";
        System.out.println(firstLetterToList(sentence));

        AbstractMap.SimpleEntry<String, Integer> pair = new AbstractMap.SimpleEntry<>(
                "Max", 123);

        SimpleEntry<String, Integer> pair2 = new SimpleEntry<>(
                "Max", 123); // если сделать статический импорт

        System.out.println("pair: " + pair.getKey() + ":" + pair.getValue());



    }

    public static Map <String, Integer> countWords(String s){
        Map<String, Integer> result = new LinkedHashMap<>();
        for (String w: s.split(" ")){
            if (result.containsKey(w)){
                int i = result.get(w)+1;
                result.put(w,i);
            } else {
                result.put(w,1);
            }

        }
        return result;
    }

    public static Map<Character, List<String>> firstLetterToList(String s){
        Map <Character, List<String>> m = new HashMap<>();
        for (String w: s.split(" ")){
            Character c = w.charAt(0);
            List<String> v = m.get(c);
            if(v == null) {
                v = new ArrayList<>();
            }
            v.add(w);
            m.put(c, v);
        }
        return m;
    }
}
