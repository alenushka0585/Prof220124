package org.example.lesson20;

public class Calculator {
    public double multiply(double a, double b){
        return a*b;
    }
    public double add(double a, double b) {
        return a+b;
    }
    public double subtract(double a, double b) {
        return a-b;
    }

    public double divide(double a, double b){
        if(b == 0)
            throw new ArithmeticException("Division by zero");

        return a/b;
    }
}
