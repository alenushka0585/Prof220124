package org.example.lesson16.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
//        1. Напишите метод, принимающий на вход имя тек текстового файла,
//        и воззвращающий количество строк в нем
//        public static int countLines(String fileName)

        System.out.println(countLines("matches.txt"));
//        Посчитайте количество строк текстового файла, содержащих определенную подстроку
//        public static int countWordsWithPattern(String fileName, String pattern)

        System.out.println(countWordsWithPattern("matches.txt", "2022, 9, 10"));
//        (x) Посчитайте количество слов в текстовом файле -
//        считается что слова отделяются пробелами
//        public static int countWords(String fileName)

        System.out.println(countWords("test.txt"));
    }

    public static int countLines(String fileName) {
        int count = 0;

        try (Reader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

//            String line = bufferedReader.readLine();
//            while (line != null) {
//                count++;
//                line = bufferedReader.readLine();
//            }

            count = (int) bufferedReader.lines().count();

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public static int countWordsWithPattern(String fileName, String pattern) {
        int count = 0;

        try (Reader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

//            String line = bufferedReader.readLine();
//            while (line != null) {
//                if (line.contains(pattern)) {
//                    count++;
//                }
//                line = bufferedReader.readLine();
//            }

            count = (int) bufferedReader.lines().filter(s -> s.contains(pattern)).count();

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }

    public static int countWords(String fileName) {
        int count = 0;
        try (
                Reader reader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(reader);
        ) {

//            String line = bufferedReader.readLine();
//
//            while (line != null) {
//                String[] words = line.split(" ");
//                count += words.length;
//                line = bufferedReader.readLine();
//            }

            count = (int) bufferedReader.lines()
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .count();

        } catch (Exception e) {
            System.out.println(e);
        }
        return count;
    }
}
