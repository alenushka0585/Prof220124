package org.example.lesson26.homework;

import java.sql.*;

public class HomeWork {
    //1. Напишите метод который принимает идентификатор покупателя (cnum)
    // и стоимость заказа (amt) и распечатывает все заказы этого покупателя
    // стоимостью большей чем amt. Для заказа распечатывайте его
    // идентификатор, стоимость, идентификаторы покупателя и продавца и дату заказа.

    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        selectCustomersOrders(2002, 100000);
    }

    public static void selectCustomersOrders(int customerId, int amount) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement pstmt = connection.prepareStatement(
                        "select * from orders where cnum = ? and amt > ?"
                )

        ) {
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, amount);
            try (
                    ResultSet rsSales = pstmt.executeQuery();
            ) {
                while (rsSales.next()) {
                    int onum = rsSales.getInt("onum");
                    int amt = rsSales.getInt("amt");
                    int cnum = rsSales.getInt("cnum");
                    int snum = rsSales.getInt("snum");
                    String odate = rsSales.getString("odate");
                    System.out.printf("|%5d|%5d|%5d|%5d|%10s|\n", onum, amt, cnum, snum, odate);
                }
            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}
