package org.example.lesson16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Try {
    public static void main(String[] args) {
        try {
            // FileInputStream класс для побайтового считывания из файла
            FileInputStream fis = new FileInputStream("digits.txt");
            // делаем что-то с файлом

            System.out.println(getString().length());

            // если мы открываем файл, то мы должны его закрыть, когда он больше не нужен,
            // чтобы не тратить дескрипторы ввода-вывода
            fis.close();
            System.out.println("File closed");

        } catch (FileNotFoundException e) {
            // FileNotFoundException - checked - нам нужно его обрабатывать
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Close file problem!");
        } catch (NullPointerException e) {
            System.err.println("Null pointer!");
        }

        System.out.println("Programme is finished");
    }

    public static String getString() {
        return null;
    }
}
