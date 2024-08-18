package org.example.lesson27.reflection;

import org.example.lesson27.annotation.Call;

import java.lang.reflect.Method;

public class Sample {
    private String name;
    private int age = 33;

    public Sample() {
        name = "Java Reflection API";
    }

    public Sample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greetings() {
        System.out.println("Name is: " + name);
    }

    public void jump(int height) {
        System.out.println("Jumping, height is: " + height);
    }

    private void secret() {
        System.out.println("It's a secret!");
    }

    @Call(url = "https://www.google.com", method = "Post")
    public void call() throws NoSuchMethodException {
        Class<?> clazz = this.getClass();
        Method callMethod = clazz.getMethod("call");
        Call callAnnotation = callMethod.getAnnotation(Call.class);
        System.out.println(callAnnotation.url() + "|" + callAnnotation.method());
    }
}
