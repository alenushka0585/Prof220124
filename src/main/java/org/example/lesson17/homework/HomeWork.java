package org.example.lesson17.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork {
    public static void main(String[] args) {
//        1. Распечатайте уникальные слова из файла в обратном порядке
//        - имя файла передается в метод в виде параметра
//        public static void uniqueWords(String filename)

        uniqueWords("homework17.txt");

//        2. (xxx) Распечатайте в каких строках файла содержатся уникальные слова
//        Например, если строки файла:
//        один раз
//        это один раз
//        но только раз
//        но один это два
//        Результат:
//        [{один: [0,1,2]}, {раз: [0,1,3]}, {это: [1,3]}, {но:[2,3]} …]
//        Обратите внимание на IntStream.range(…)
        uniqueWordsLines("homework17.txt");
    }

    public static void uniqueWords(String filename) {

        try (Reader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            LinkedHashSet<String> set = bufferedReader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            List<String> list = new ArrayList<>(set);
            Collections.reverse(list);

            list.forEach(System.out::println);


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void uniqueWordsLines(String filename) {
        try (Reader reader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

//            Map<String, List<Integer>> wordLinesMap = new LinkedHashMap<>();
//            String line;
//            int lineNumber = 0;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] words = line.split(" ");
//                for (String word : words) {
//                    wordLinesMap.computeIfAbsent(word, k -> new ArrayList<>()).add(lineNumber);
//                }
//                lineNumber++;
//            }
//            System.out.println(wordLinesMap);

            List<String> lines = bufferedReader.lines().toList(); // строки файла

            Map<String, List<Integer>> map =
                    IntStream.range(0, lines.size())
                    .mapToObj(i -> i)
                    .flatMap(i -> Arrays.stream(lines.get(i).split("\\s+")).map(
                                    w -> new AbstractMap.SimpleEntry<>(w, i)
                            )
                    ) // SimpleEntry<слово, номер строки>
                    .collect(
                            Collectors.groupingBy(
                                    pair -> pair.getKey(),
                                    LinkedHashMap::new,
                                    Collectors.mapping(
                                            pair -> pair.getValue(),
                                            Collectors.toList()
                                    )
                            )
                    ) // LinkedHashMap<слово, List<номер строки>>
            ;
            System.out.println(map);

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
