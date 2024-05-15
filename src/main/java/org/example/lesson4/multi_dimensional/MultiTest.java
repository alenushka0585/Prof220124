package org.example.lesson4.multi_dimensional;

import java.util.Arrays;

public class MultiTest {
    public static void main(String[] args) {
        int[][] c = new int[][]{
                {1, 3, 5},
                {4},
                {-10, 20, -40, 5}
        };

        System.out.println(c[0][2]);
        System.out.println(c[2][2]);

        System.out.println(c.length);
        System.out.println(c[1].length);

        System.out.println(sum(c));

        System.out.println(Arrays.toString(flatten(c)));


    }

    public static int [] flatten (int[] [] a){
        int length = 0;
        for (int i = 0; i < a.length; i++) {
                length+=a[i].length;
        }
        int [] b = new int[length];
        int pos = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[pos++] = a[i][j];
            }
        }
        return b;
    }
    public static int sum(int[][] a) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                s += a[i][j];
            }
        }
        return s;
    }


}
