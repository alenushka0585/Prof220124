package org.example.lesson4.reference;

public class BoxingUnboxing {
    public static void main(String[] args) {

        //примитивные типы int boolean float, byte double
        // ссылочный типы Integer Boolean Float, Byte Double - Wrapper
        int i = 10;
        Integer i1 = i; //boxing

        if (i1 < 100) {
            System.out.println();
        }
    }
}
