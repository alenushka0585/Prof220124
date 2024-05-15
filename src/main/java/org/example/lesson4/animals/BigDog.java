package org.example.lesson4.animals;

public class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("WOOF!");
    }

    @Override
    public void greets(Dog g) {
        System.out.println("WOOOOF!!!");
    }

    public void greets(BigDog g) {
        System.out.println("WOOOOOOOOOF!!!");
    }
}
