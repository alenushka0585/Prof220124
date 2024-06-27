package org.example.lesson17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class BufferedWriterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите несколько строк");
        System.out.println("stop закончит ввод");

        try(Writer writer = new FileWriter("test-output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer))
        {
            String line = scanner.nextLine();
            while (!line.equals("stop")){
                bufferedWriter.append(line);
                bufferedWriter.newLine();
                line= scanner.nextLine();
            }

            bufferedWriter.flush(); // сброс буфера на диск

        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}


