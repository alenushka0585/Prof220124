package org.example.lesson2.person;

public class UniversityTester {
    public static void main(String[] args) {
        Person person = new Person("John", 23);
        Student student = new Student("Vasilisa", 23, 3, "music");
        Staff staff = new Staff("Alex", 37, 23500);

        Object[] object = {person, student, staff};
        ((Person)object[0]).introduce();

        Person[] persons = {person, student, staff};

        for (int i = 0; i < persons.length; i++) {
            persons[i].introduce();
        }

    }
}
