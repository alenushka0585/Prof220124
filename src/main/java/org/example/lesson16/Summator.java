package org.example.lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Summator {
    public static void main(String[] args) {

        try (
                Reader reader = new FileReader("digits.txt");
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            int sum = 0;
            String line = bufferedReader.readLine();

            while (line != null) {
                sum += Integer.parseInt(line);
                line = bufferedReader.readLine();
            }
            System.out.println("Sum is: " + sum);

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
