package org.example.lesson26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AutoIncrement {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // sqlite драйвер, локальный файл shop.db в корне
// загрузить поддержку jdbc
// создать соединение с базой данных по url
        try (
                Connection connection = DriverManager.getConnection(url);
                // запрос
                Statement stmt = connection.createStatement();
        ) {
            // create table users (id integer not null primary key autoincrement , name text not null);
            int rowsAffected = stmt.executeUpdate(
                    "insert into users (name) values ('Max') "
            );
            if (rowsAffected > 0) {
                try (
                        ResultSet rs = stmt.getGeneratedKeys();
                ) {
                    if(rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("key is: " + id);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}

