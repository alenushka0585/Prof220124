package org.example.lesson1.homework1;

public class Phone {
//    Создайте класс Phone, который содержит поля number, model и weight.
//    Добавьте метод printPhoneInfo, распечатывающий значения полей класса.
//    Создайте три экземпляра этого класса c разным набором параметров.
//    Выведите на консоль значения их переменных.
//    Добавить в класс Phone методы: receiveCall, имеет один параметр – имя звонящего.
//    Выводит на консоль сообщение "Звонок от {name}".

    private int number;
    private String model;
    private double weight;

    public Phone(int number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void printPhoneInfo(){
        System.out.println("Модель- " + model+
                ", вес - " + weight +
                ", номер - " + number);
    }

    public void receiveCall(String name){
        System.out.println("Звонок от " + name);
    }
}
