package org.example.lesson26;

import org.example.lesson24.france.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement stmt = connection.createStatement();
                // ResultSet - результат select запроса - все строки которые удовлетворяют запросу
                ResultSet rs = stmt.executeQuery("select * from customers order by cname ");
                ResultSet rsSales = stmt.executeQuery(" select * from salespeople ");


        ) {
            //      create table customers (
            //      cnum int primary key not null,
            //      cname text not null, city text not null,
            //      rating integer not null,
            //      snum int not null);
            while (rs.next()){ // переход к следующй строки ResultSet
                int customerId = rs.getInt("cnum");
                String name = rs.getString("cname");
                int ratting = rs.getInt("rating");
                int snum = rs.getInt("snum");

                System.out.printf("|%5d|%10s|%5d|%5d|\n",
                        customerId,
                        name,
                        ratting,
                        snum);
            }

            while (rsSales.next()){
                int salesId = rsSales.getInt("snum");
                String salesName = rsSales.getString("sname");

                System.out.printf("|%5d|%10s|\n",
                        salesId,
                        salesName);
            }

        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}

