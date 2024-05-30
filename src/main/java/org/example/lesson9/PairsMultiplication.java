package org.example.lesson9;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PairsMultiplication {
    public static void main(String[] args) {
        Integer[] digits = {2, 7, 5, 12, 14};
        System.out.println(calculate(digits, 60));
        System.out.println(calculate(digits, 1024));
    }

    private static boolean calculate(Integer[] digits, int i) {
        Arrays.sort(digits);
        Deque<Integer> d = new LinkedList<>(
                Arrays.asList(digits));

        int f = d.removeFirst();
        int l = d.removeLast();
        while ((d.size() > 0)) {
            int p = f * l;
            if (p == i) {
                return true;
            }
            if (p < i) {
                f = d.removeFirst();
            } else {
                l = d.removeLast();
            }
        }
        return false;
    }
}
