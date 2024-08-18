package org.example.lesson27.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // означает, что к ней можно получить доступ при работ приложения
// @ метит этот интерфейс как аннотацию
public @interface HelloAnnotation {
    String name();
    String value();
    int age() default 25;
}
