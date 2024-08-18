package org.example.lesson27.reflection;


/*
Reflection - рефлекция - способ загрузить данные о классе
    методы и их параметры
    аннотации
    уровни доступа
    конструкторы

манипуляция методами и полями класса
*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTester {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = Sample.class;

        // ссылка безаргументный конструктрр
        Constructor<?> noArgsConstructor = clazz.getConstructor();

        //создание объекта по ссылке на конструктор
        Sample sampleNoArgs = (Sample) noArgsConstructor.newInstance();

        sampleNoArgs.greetings();

        // ссылка конструктор с параметром
        Constructor<?> twoArgsConstructor = clazz.getConstructor(String.class, int.class);

        Sample sample = (Sample) twoArgsConstructor.newInstance("Masha", 25);
        sample.greetings();

        //методы класса публичные
        Method[] methods = clazz.getMethods();

        for (Method m : methods) {
            System.out.println("Method name: " + m.getName());
        }


        // получение ссылки на метод с определенными типовыми параметрами
        Method jumpMethod = clazz.getMethod("jump", int.class); //публичнык
        jumpMethod.invoke(sample, 17);

        Method greetingsMethod = clazz.getMethod("greetings");
        greetingsMethod.invoke(sampleNoArgs);

        // ссылка на private метод
        Method secretMethod = clazz.getDeclaredMethod("secret");
        // перевод в public
        secretMethod.setAccessible(true);
        // вызов бывшего private метода
        secretMethod.invoke(sample);

        // работа с полями класса
        System.out.println("====fields=====");

        Field[] fields = clazz.getDeclaredFields(); // публичные
        for(Field f: fields) {
            System.out.println("field: " + f.getName());
        }

        Field nameField = clazz.getDeclaredField("name"); // private
        nameField.setAccessible(true); // перевод ссылки на поле в public
        nameField.set(sampleNoArgs, "changed name");
        greetingsMethod.invoke(sampleNoArgs);

        sampleNoArgs.call();

    }
}
