package org.example.lesson16;

import java.io.FileInputStream;

public class TryWithResource {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("digits.txt")) {
            // для fis автоматически будет вызван close
            // при выходе из try-блока
            // работает только для AutoClosable()


            // work with file
        } catch (Exception e) {
            //
        }
    }
}
