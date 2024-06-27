package org.example.lesson16;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) {
        int i = 0;
        try(
                FileInputStream fis = new FileInputStream("digits.txt");
                FileOutputStream fos = new FileOutputStream("digits-copy.txt")) {

            // -1 - байты во входном потоке закончились
            // fis.read() - считывает и возвращает 1 байт
            // fis.read(byte[]) - считывает данные в массив и возвращает
            // количество считанных байт

            while ( (i = fis.read()) != -1){
                fos.write(i);
            }

        } catch (Exception e){

        }
    }
}
