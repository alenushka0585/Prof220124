package org.example.lesson16;

public class PrintfTester {
    public static void main(String[] args) {
        //System.out стандартный вывод
        //System.err стандартный вывод ошибок
        //System.in стандартный ввод

//                                boolean   int          double      string
        System.out.printf("It's a %b, year %d, salary is %f, name is %s\n", false, 15, 390.4, "Max");

        // стандартные настройки
        System.out.printf("pi is %f\n", Math.PI);

// три знака после зяпятой всего 10 позиций
        System.out.printf("pi is %10.3f\n", Math.PI);

        // https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
    }
}
