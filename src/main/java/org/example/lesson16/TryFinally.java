package org.example.lesson16;

import java.io.FileInputStream;

public class TryFinally {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("digits.txt");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            // выполняется ВСЕГДА после try-блока
            // не зависимо от того было ли исключение или нет
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    //
                }
            }
        }


    }
}
