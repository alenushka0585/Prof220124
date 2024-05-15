package org.example.lesson2.person;

public class Staff extends Person{
    private double salary;

    public Staff(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public void introduce() {
        System.out.println("Staff " + getName() + ", salary " + salary);
    }
}
