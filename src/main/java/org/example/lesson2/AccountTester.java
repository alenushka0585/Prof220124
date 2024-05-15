package org.example.lesson2;

public class AccountTester {
    // создайте два счета
// первый - 20
// второй - 30
// распечатайте первый
// распечатайте второй
// добавьте на первый 10 евро
// переведите с первого на второй 100 евро
// распечатайте первый
// распечатайте второй
// переведите с первого на второй 15 евро
// распечатайте первый
// распечатайте второй
    public static void main(String[] args) {
        Account acc1 = new Account("001","Ivan", 20);
        Account acc2 = new Account("002","Peter", 30);

        System.out.println(acc1);
        System.out.println(acc2);

        acc1.credit(10);
        acc1.transfer(acc2, 100);

        System.out.println(acc1);
        System.out.println(acc2);

        acc1.transfer(acc2, 15);

        System.out.println(acc1);
        System.out.println(acc2);
    }
}
