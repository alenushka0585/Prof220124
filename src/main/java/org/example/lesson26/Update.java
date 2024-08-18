package org.example.lesson26;

import java.sql.*;

public class Update {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement stmt = connection.createStatement()

        ) {
            {
                int rowAffected = stmt.executeUpdate(
                        "update salespeople set comm = comm + 1"
                );
                System.out.println("rows affected: " + rowAffected);
            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());

        }
    }
}
