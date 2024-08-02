package org.example.lesson20.homework;

import org.example.lesson20.LambdaMatcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class  ProbeTest {

//    1. Напишите тест который проверит что в
//    List odds = List.of(22, 12, 6);
//    Все значения четные.
//            Воспользуйтесь LambdaMatcher

    @Test
    public void isOnlyEven() {
        List<Integer> odds = List.of(22, 12, 6);

        LambdaMatcher<Integer> evenMatcher = new LambdaMatcher<>(num -> num % 2 == 0);

        assertThat(odds, Matchers.everyItem(evenMatcher));

    }

//    Проверьте что maxOfArray для {1,2,3,4} вернет 4
//    И что maxOfArray для пустого массива вернет 0

    @Test
    public void maxOfArrayTest() {
        int[] ints = {1, 2, 3, 4};
        int[] emptyArr = new int[1];

        assertThat(Probe.maxOfArray(ints), Matchers.equalTo(4));
        assertThat(Probe.maxOfArray(emptyArr), Matchers.equalTo(0));
    }

}
