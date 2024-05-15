package org.example.lesson3.casino;

import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dealer dealer = new Dealer();

        int sum = 0;

        do{
            Card card = dealer.getCard();
            System.out.println("карта "  + card);
            sum+=card.getValue();
            System.out.println("Ваш счет: " + sum);
            System.out.println("Нажмите N для прекращения игры Y для продолжения");
        }while (!scanner.next().equals("N"));
    }
}
