package org.example.lesson2;

public class A {
    public void hello(){
        System.out.println("Hello from A!");
    }

    protected void world(){
        System.out.println("World from A!");
    }

   final public void secure(){  // метод не может быть переопределен в дочерних классах
        System.out.println("Secure from A!");
    }
}
