package org.example.lesson17;

import java.io.BufferedReader;
import java.io.StringReader;

public class StringStreamTester {
    public static void main(String[] args) {
        String string = "hello\nworld\nhow are you?";
        BufferedReader bufferedReader = new BufferedReader(
                new StringReader(string)
        );

        bufferedReader.lines()
                .forEach(
                        s -> System.out.println("string: " +s));

    }
}
