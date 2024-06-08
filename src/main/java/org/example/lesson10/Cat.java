package org.example.lesson10;

import java.util.Comparator;
import java.util.Objects;

public class Cat implements Comparable{
    String name;
    int age;

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return  "C{" + name + "," + age + "}";
    }

    @Override
    public int compareTo(Object o) {
        Cat cat = (Cat)o;
        return this.name.compareTo(cat.name);
    }

    public static Comparator<Cat> catAgeComparator = new Comparator<Cat>() {
        @Override
        public int compare(Cat c1, Cat c2) {
            return Integer.compare(c1.age, c2.age);
        }
    };


}
