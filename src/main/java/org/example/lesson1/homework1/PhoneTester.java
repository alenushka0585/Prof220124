package org.example.lesson1.homework1;

public class PhoneTester {
    public static void main(String[] args) {
        Phone phone1 = new Phone(1635566123, "Samsung", 0.2);
        Phone phone2 = new Phone(1636677456, "Xiaomi", 0.21);
        Phone phone3 = new Phone(1637788789, "Apple", 0.15);

        phone1.printPhoneInfo();
        phone2.printPhoneInfo();
        phone3.printPhoneInfo();

        phone1.receiveCall("Maria");

    }
}
