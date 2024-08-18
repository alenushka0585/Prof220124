package org.example.lesson27.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Call {
    String url();
    String method();
    String login() default "user";
    String password() default "secret";
}
