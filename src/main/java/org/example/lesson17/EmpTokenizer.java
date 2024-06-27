package org.example.lesson17;

import org.example.lesson14.Emp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class EmpTokenizer {
    public static void main(String[] args) {
//        write();
        read();
    }

    public static void write() {
        Emp max = new Emp(
                "Max Kotkov", 27, "analyst"
        );
        try (PrintWriter printWriter = new PrintWriter("employee.txt")) {
            printWriter.format(
                    "%s|%d|%s",
                    max.getName(),
                    max.getAge(),
                    max.getPosition()
            );

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void read() {
        try (
                Reader reader = new FileReader("employee.txt");
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {

            String s = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(s,"|");
            String name = tokenizer.nextToken();
            int age = Integer.parseInt(tokenizer.nextToken());
            String position = tokenizer.nextToken();

            System.out.println(new Emp(name,age,position));


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
