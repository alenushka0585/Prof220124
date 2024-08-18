package org.example.lesson27.hw;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Course {
//    1. Создайте класс Course с приватными полями
//    String specialization
//    int duration
//    double price
//    Создайте конструктор со всеми полями
//    и метод toString который возвращает строку со значениями всех полей.
//    С помощью Reflection API создайте экземпляр  класса Course
//    через ссылку на рефлексионный конструктор.
//    С помощью Reflection API вызовите у экземпляра класса
//    метод toString и выведите на экран его результат

    @Fake(value = "Logistic")
    private String specialization;
    private int duration;
    private double price;

    public Course(String specialization, int duration, double price) {
        this.specialization = specialization;
        this.duration = duration;
        this.price = price;
    }

    @Override
    public String toString() {
        try {
            Field specializationField = this.getClass().getDeclaredField("specialization");
            if (specializationField.isAnnotationPresent(Fake.class)) {
                Fake fakeAnnotation = specializationField.getAnnotation(Fake.class);
                String fakeValue = fakeAnnotation.value();
                if (!fakeValue.isEmpty()) {
                    return "Specialization: " + fakeValue + ", Duration: " + duration + ", Price: " + price;
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return "Specialization: " + specialization + ", Duration: " + duration + ", Price: " + price;
    }

    public static void main(String[] args) {

        try {
            Class<?> clazz = Course.class;
            Constructor<?> constructor =
                    clazz.getConstructor(String.class, int.class, double.class);
            Course course = (Course) constructor.newInstance("IT", 12, 1500);
            Method toStringMethod = Course.class.getMethod("toString");
            String result = (String) toStringMethod.invoke(course);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
