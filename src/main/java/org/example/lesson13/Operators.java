package org.example.lesson13;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Operators {
    public static void main(String[] args) {
        //UnaryOperator - это Function у которого входной и выходной пареметр одного типа
        //UnaryOperator<Integer> == Function<Integer, Integer>

        int [] numbers = new int[]{1,3,5,2,4,11};

        IntBinaryOperator multiplay = (left, right) -> left*right;

        System.out.println(Arrays.stream(numbers).reduce(multiplay));

        //Optional - может быть значение, а может и не быть

        System.out.println(
                Arrays.stream(numbers).max()
        );

    }
}
