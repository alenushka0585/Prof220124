package org.example.lesson20;

import org.example.lesson17.Car;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

//https://hamcrest.org/JavaHamcrest/tutorial
public class HamcrestIntro {
    @Test
    public void testEmptyString() {
        String input = "";
        assertThat(input, Matchers.instanceOf(String.class));
        assertThat(input, Matchers.emptyString());
        assertThat(input, Matchers.isEmptyOrNullString());

        String group = "Red Hot Chili Peppers";
        assertThat(group, Matchers.startsWith("Red"));
        assertThat(group, Matchers.endsWith("Peppers"));
        assertThat(group, Matchers.containsString("Chili"));
        assertThat(group, Matchers.equalToIgnoringCase("red hot chili peppers"));
    }

    @Test
    public void testListOfIntegers() {
        List<Integer> ints = List.of(5, 2, 4);

        assertThat(ints, Matchers.hasItem(2));
        assertThat(ints, Matchers.hasSize(3));
        assertThat(ints, Matchers.containsInAnyOrder(2, 4, 5));
        assertThat(ints, Matchers.contains(5, 2, 4));
        assertThat(ints, Matchers.everyItem(Matchers.greaterThan(1)));
    }

    @Test
    public void testArrayOfStrings() {
        String[] words = {"hello", "world", "equator", "sun"};

        assertThat(words, Matchers.arrayWithSize(4));
        assertThat(words, Matchers.hasItemInArray("sun"));
        assertThat(words, Matchers.arrayContaining("hello", "world", "equator", "sun"));

        LambdaMatcher<String> lengthMatcher = new LambdaMatcher<>(
                s -> s.length() < 10
        );
        List<String> w = Arrays.asList(words);

        assertThat(
                w,
                Matchers.everyItem(lengthMatcher)
        );

    }

    @Test
    public void testMapOfStrings() {
        Map<String, Integer> people = new HashMap<>();
        people.put("Max", 23);
        people.put("Misha", 26);

        assertEquals(people.size(), 2);
        assertThat(people, Matchers.hasKey(Matchers.equalToIgnoringCase("Misha")));
        assertThat(people, Matchers.hasValue(23));
        assertThat(people, Matchers.hasEntry("Max", 23));

        assertThat(people.keySet(), Matchers.everyItem(Matchers.startsWith("M")));

        assertThat(
                people.values(),
                Matchers.everyItem(
                        Matchers.allOf(
                                Matchers.greaterThan(20),
                                Matchers.lessThan(30)
                        )
                )
        );
    }

    @Test
    public void TestProperty() {
        Car peugeot = new Car("Pegeot", "407", 14500);

        assertThat(peugeot, Matchers.instanceOf(Car.class));
        assertThat(peugeot, Matchers.hasProperty("maker"));
        assertThat(peugeot,
                Matchers.hasProperty(
                        "model",
                        Matchers.equalTo("407")));

        List<Car> cars = List.of(
                peugeot,
                new Car("Toyota", "Celica", 24300)
        );

        assertThat(cars, Matchers.hasSize(2));
        assertThat(
                cars,
                Matchers.everyItem(
                        Matchers.hasProperty(
                                "price",
                                Matchers.greaterThan(10000.0)
                        )
                )
        );


    }
}
