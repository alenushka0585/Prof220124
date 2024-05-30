package org.example.lesson8.homework;

import org.example.lesson8.WordCounter;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class HomeWorkTester {
    public static void main(String[] args) {
//        Напишите метод, принимающий на вход строку
//        и возвращающий набор уникальных символов этой строки
//        Например: "hello, world!" -> {' ', 'd', 'w', h', 'e', 'l', 'o', 'w', 'r'}.

        String s = "hello, world!";
        System.out.println(uniqueChars(s));


//        Напишите метод, который принимает на вход набор (Set) целых чисел
//        и удаляющий из этого набора все отрицательные числа (порядок не важен).
//        Например: {-1, 12,3,4,-8,-2} -> {4, 12, 3, 8}

        Set<Integer> integerSet = new HashSet<>(
                Arrays.asList(-1, 12,3,4,-8,-2)
        );

        positiveSet(integerSet);
        System.out.println(integerSet);

//** 3. Напишите метод, который принимает строку
// и возвращает для каждого слова строки порядковые номера слов.
//  Например: "один раз это один раз но только раз" -> {"один":[0,3], "раз":[1,4,7], "это":[2], "но":[5], "только":[6]}

        String s2 = "один раз это один раз но только раз";
        System.out.println(ordinalOfWords(s2));

        }

    private static Set<Word> ordinalOfWords(String s2) {
        Set<Word>  words= new HashSet<>();
        String[] arr = s2.split(" ");

        for (int i = 0; i < arr.length; i++) {
            Word w = new Word(arr[i]);
            words.add(w);
            if(words.contains(w)){
                w = findWord(words,w);
                w.index.add(i);
            }
        }
        return words;
    }

    private static Word findWord(Set<Word> words, Word d) {
        for(Word w: words) {
            if(w.equals(d))
                return w;
        }
        return null;
    }

    private static class Word{
        private String Word;
        private List<Integer> index= new ArrayList<>();

        public Word(String word) {
            Word = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word = (Word) o;
            return Objects.equals(Word, word.Word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Word);
        }

        @Override
        public String toString() {
            return "\"" + Word + "\":" +
                      index;
        }
    }

    private static void positiveSet(Set<Integer> integerSet) {
        for (Iterator<Integer> setIterator = integerSet.iterator(); setIterator.hasNext();){
            int num = setIterator.next();
            if (num <0){
                setIterator.remove();
            }
        }
    }

    private static HashSet<Character> uniqueChars(String s) {
        HashSet<Character> result = new HashSet<>();
        for (char c : s.toCharArray()){
            result.add(c);
        }
        return result;
    }
}
