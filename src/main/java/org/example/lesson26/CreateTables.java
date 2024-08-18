package org.example.lesson26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTables {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // sqlite драйвер, локальный файл shop.db в корне
        //загрузить драйвер (поддержку jdbc
        //создать соеденение с базой данной по url

        try (Connection connection = DriverManager.getConnection(url);
             // запрос
             Statement stmt = connection.createStatement();
        ) {
            //Statement.execute() - выполнение произвольных SQL команд
            //Statement.executeUpdate() - выполнение update/delete - возвращает
            // количество измененных/удаленных строк в таблице
            // Statement.executeQuery() - выполнение select - возвращает ResultSet - результат

            stmt.execute("create table salespeople (snum int primary key not null,  " +
                    "  sname text not null, city text not null, comm integer not null);");
            System.out.println("table salespeople created!");

            stmt.execute("create table customers (cnum int primary key not null,  " +
                    "  cname text not null, city text not null, rating integer not null, snum int not null);");
            System.out.println("table customers created!");

            stmt.execute("create table orders (onum int primary key not null,   " +
                    "   amt int not null, odate text not null, cnum int not null, snum int not null);");
            System.out.println("table orders created!");


        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }


    }
}
