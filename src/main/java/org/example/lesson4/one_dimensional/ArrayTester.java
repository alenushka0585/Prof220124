package org.example.lesson4.one_dimensional;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTester {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 7};
        String[] b = {"Apocalypse now", "Taxi Driver", "Psycho"};
        double[] c = new double[10]; // 0 по-умолчанию

        System.out.println(c.length);
        System.out.println(b[1]);
        b[2] = "Hateful eight";

        System.out.println(Arrays.toString(b));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));


        Arrays.sort(
                b,
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return s1.length() - s2.length();
                    }
                }
        );

        System.out.println(Arrays.toString(b));

// требует наличия отсортированного контейнера
        System.out.println(Arrays.binarySearch(a,7));

        int [] e = {1,2,3,4};
        int [] f = Arrays.copyOfRange(e,1,3);

        System.out.println(Arrays.toString(f));

        Arrays.fill(e, 10);

        System.out.println(Arrays.toString(e));

        //Arrays.compare(); сравнение поэлементное
        //Arrays.copyOf()
    }
}
