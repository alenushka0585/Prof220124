package org.example.lesson27.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@HelloAnnotation(name = "Max", value = "Hello")
public class AnnotationTester {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        // Class<?> clazz = AnnotationTester.class;
        // Class<?> clazz = new AnnotationTester().getClass();
        Class<?> clazz = Class.forName("org.example.lesson27.annotation.AnnotationTester");
        //получаем все связанные с классом аннотации
        Annotation[] annotations = clazz.getAnnotations();

        for(Annotation a: annotations) {
            System.out.println("type: " + a.annotationType());
        }

        // аннотация класса
        HelloAnnotation helloAnnotation =
                clazz.getAnnotation(HelloAnnotation.class);

        System.out.println(helloAnnotation.name() +
                helloAnnotation.value() +
                helloAnnotation.age());


        // ссылка на метод через reflection
        Method method = clazz.getMethod("doSomething");

        // аннотиции метода
        HelloAnnotation methodHelloAnnotation =
                method.getAnnotation(HelloAnnotation.class);

        System.out.println("name: " + methodHelloAnnotation.name() +
                ", value: " + methodHelloAnnotation.value() +
                ", age: " + methodHelloAnnotation.age());
    }


    @HelloAnnotation(name = "Ivan", value = "Hi", age=42)
    public void doSomething() {

    }

    public void doSomething(String s) {

    }
}
