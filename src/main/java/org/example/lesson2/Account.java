package org.example.lesson2;

public class Account {
    //    UML - Universal Modelling Language механизм для описание структуры программного продукты
//    Account
//    -id: String
//    -name: String
//    -balance: int = 0
//    +Account(id, name, balance)
//    +Account(id, name)
//    +credit(int amount) = возвращается баланс счета
//        amount только положительный - если нет, не уменьшаем а печатаем сообщение
//    +transfer(account, amount) = возвращает баланс счета
//        если amount больше чем баланс, то операцию не производим а выводим сообщение
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int credit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Amount can be only positive");
        }
        return balance;
    }

    public int debit(int amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Amount can't be more than balance or less then 0");
        }
        return balance;
    }

    public int transfer(Account account, int amount) {
        if (amount < 0){
            System.out.println("Amount can be only positive");
        } else if (amount > balance){
            System.out.println("Amount can't be more than balance");
        } else {
            debit(amount);
            account.credit(amount);
        }
        return balance;
    }

    @Override
    public String toString() {
        return "id: " + id  +
                ", name: " + name +
                ", balance: " + balance;
    }
}
