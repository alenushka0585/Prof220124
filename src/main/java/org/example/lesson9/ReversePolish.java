package org.example.lesson9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReversePolish {
    public static void main(String[] args) {

        /*
        (3 + 4 - 2)*6
        3 4 + 2 - 6 *
            7 2 - 6 *
                5 6 *
                    30
         */
        String toCalculate = "3 4 + 2 - 6 *";
        System.out.println(reversePolishCalculator(toCalculate));
    }

    private static int reversePolishCalculator(String toCalculate) {
        Queue<String> t = new LinkedList<>(
                Arrays.asList(toCalculate.split(" "))
        );
        int op1 = Integer.parseInt(t.poll());
        while (t.size() >= 2) {
            int op2 = Integer.parseInt(t.poll());
            String operation = t.poll();
            if (operation.equals("*")) {
                op1 = op1 * op2;
            } else if (operation.equals("/")) {
                op1 = op1 / op2;
            } else if (operation.equals("-")) {
                op1 = op1 - op2;
            } else if (operation.equals("+")) {
                op1 = op1 + op2;
            }
        }
        return op1;
    }
}
