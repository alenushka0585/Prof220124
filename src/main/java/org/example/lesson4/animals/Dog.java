package org.example.lesson4.animals;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woof!");
    }

    // перегрузка
    public void greets(Dog g) {
        System.out.println("Woooof!");
    }

    final public void jump(){
        System.out.println("Dog is jumping");
    }
}
