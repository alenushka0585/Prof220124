package org.example.lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderTester {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("test.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)){

            String line = bufferedReader.readLine();
            while (line != null){
                System.out.println("Line: " + line);
                line = bufferedReader.readLine();
            }

        } catch (Exception  e){
            System.out.println(e);
        }

    }
}
