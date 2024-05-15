package org.example.lesson2.animals;

public class FlyingFish implements Flyer,Swimmer{
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }

    @Override
    public void swim() {
        System.out.println("I'm swimming");
    }
}
