package org.example.lesson26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement stmt = connection.createStatement()

        ) {
            {
                int rowDeleted = stmt.executeUpdate(
                        "delete from orders where odate = '1990-10-03'"
                );
                System.out.println("rows deleted: " + rowDeleted);
            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());

        }
    }
}
