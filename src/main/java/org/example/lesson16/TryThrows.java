package org.example.lesson16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryThrows {
    // никогда не выбрасывайте ничего из main в продуктивном коде
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("digits.txt");
            hello();
        } catch (IOException  | NullPointerException e) {
            // catch блок ловит 2 исключения
        }
    }

    public static void hello() throws IOException {
        // TODO
    }
}
