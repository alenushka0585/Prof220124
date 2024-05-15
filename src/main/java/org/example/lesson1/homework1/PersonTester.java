package org.example.lesson1.homework1;

public class PersonTester {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Иванов Иван", 34);

        person1.talk();
        person1.move();

        person2.talk();
        person2.move();

        person1.setFullName("Gohn Smith");
        person2.setAge(25);

        person1.talk();
        person1.move();
    }
}
