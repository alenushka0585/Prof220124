package org.example.lesson11.homework;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
//        1. Создайте метод, принимающий на вход массив строк и массив целых одинаковой длины и возвращающий Map
//        public static Map makeMap(String [] strings, int [] ints)
//        Например: ["Dima", "Masha"], [23,33] -> [{"Dima":23}, {"Masha", 33}].
//

        String[] strings = new String[]{"Dima", "Masha"};
        int[] ints = new int[]{23, 33};
        System.out.println(makeMap(strings, ints));

//
//        2. Верните самую часто встречающуюся строку в списке строк
//        public static String mostFrequentString(List strings)
//
List<String> list = new ArrayList<>(List.of("apple", "banana", "apple", "orange", "banana", "apple"));
        System.out.println(mostFrequentString(list));


//*** 3. Сгруппируйте слова с одинаковым набором символов
//        Один и те-же символы могут встречаться несколько раз
//        public static List> getWords(List strings)
//        Например: ["alla", "student", "students", "al", "pass", "sap", "lalalala"] -> [["student", "students"], ["alla", "al", "lalalala"], ["pass", "sap"]]

        List<String> s =  new ArrayList<>(
                Arrays.asList("alla","student", "students", "al", "pass", "sap", "lalalala"));
        System.out.println(getWords(s));
    }

    public static Map<String, Integer> makeMap(String[] strings, int[] ints) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], ints[i]);
        }
        return map;
    }

    public static String mostFrequentString(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            }
            map.put(s, map.get(s) + 1);
        }

        String s = null;
        int max = 0;

        for(Map.Entry<String,Integer> pairs: map.entrySet()){
            if (pairs.getValue() > max){
                s = pairs.getKey();
                max = pairs.getValue();
            }
        }

        return s;
    }

    public static List<List<String>> getWords(List<String> strings){
        if (strings == null || strings.isEmpty()) {
            return new ArrayList<>(); // Возвращаем пустой список, если входной список пустой или null
        }
        Map<Set, List<String>> map = new HashMap<>();

        for (String s : strings){
            Set<Character> set = new TreeSet<>();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            for (char c:chars){
                set.add(c);
            }

            if (!map.containsKey(set)){
                List<String> words = new ArrayList<>();
                words.add(s);
                map.put(set, words);
            } else {
                map.get(set).add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();
       for (List<String> stringList: map.values()){
           result.add(stringList);
       }
       return result;
    }
}
