package org.example.lesson20;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.function.Predicate;

public class LambdaMatcher<T> extends BaseMatcher<T> {
    // описание того что матчер делает для анализа ошибок
    private String description;
    // лябмда для сравнения элементов
    private final Predicate<T> predicate;

    public LambdaMatcher(String description, Predicate<T> predicate) {
        this.description = description;
        this.predicate = predicate;
    }

    public LambdaMatcher(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean matches(Object o) {
        return predicate.test((T) o);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(this.description);
    }
}
