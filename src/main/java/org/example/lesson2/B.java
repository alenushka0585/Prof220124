package org.example.lesson2;

public class B extends A{
    @Override
    public void hello() {
        System.out.println("Hello from B!");
    }

    @Override
    protected void world() {
        System.out.println("World from B!");
    }

//    @Override
//    public void secure() {
//        System.out.println("Secure from B!");
//    }

//    final у класса - нельзя от него наследоваться.
}
