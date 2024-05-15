package org.example.lesson1;

public class Dog {
//    CTRL + ALT + L выравнивание

// Fn + Alt + Ins - constructor

    private String breed;
    private int age;
    private String color;
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public void bark(){
        System.out.println("Dog " + name + " is barking");
    }

    public void info(){
        System.out.println("Dog " + name + ",age " + age + ",bread: " + breed);
    }
}
