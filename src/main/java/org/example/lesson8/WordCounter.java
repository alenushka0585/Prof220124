package org.example.lesson8;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordCounter {
    public static void main(String[] args) {
        System.out.println(countWords("один раз это один раз"));
    }

    public static Set<Word> countWords(String s) {
        Set<Word> words = new HashSet<>();
        for(String w: s.split(" "))
        {
            Word d = new Word(w);
            if(words.contains(d)) {
                // найти
                d = findWord(words, d);
            }
            d.count++;
            words.add(d);
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

    private static class Word {
        public String word;
        public int count = 0;

        public Word(String word) {
            this.word = word;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Word word1 = (Word) o;
            return Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        @Override
        public String toString() {
            return "Word{" +
                    "word='" + word + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
