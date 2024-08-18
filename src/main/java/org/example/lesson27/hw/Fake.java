package org.example.lesson27.hw;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Fake {
//    2. Добавьте аннотацию Fake с методом String value() default ""
//    Повесьте эту аннотацию на поле  specialization класса Course
//    В toString в Course используйте value() из аннотации Fake
//    вместо значения specialization если value() не пусто.
String value() default "";
}
