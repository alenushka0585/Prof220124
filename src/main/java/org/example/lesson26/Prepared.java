package org.example.lesson26;

import java.sql.*;

public class Prepared {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                // скомпилированный запрос
                PreparedStatement pstmt = connection.prepareStatement(
                        "select * from salespeople where comm > ?"
                );

        ) {
            pstmt.setInt(1, 14); // номер ? начиная с 1
            try (
                    ResultSet rsSales = pstmt.executeQuery();
            )
            {
                while (rsSales.next()) {
                    int snum = rsSales.getInt("snum");
                    String sname = rsSales.getString("sname");
                    String city = rsSales.getString("city");
                    int comm = rsSales.getInt("comm");
                    System.out.printf("|%5d|%10s|%10s|%5d|\n", snum, sname, city, comm);
                    System.out.println("============================");
                }
            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());

        }

        try (
                Connection connection = DriverManager.getConnection(url);
                // скомпилированный запрос
                PreparedStatement pstmt = connection.prepareStatement(
                        "select * from orders where amt > ? and amt < ?"
                );
        ) {
            pstmt.setInt(1, 100000); // номер ? начиная с 1
            pstmt.setInt(2, 200000);
            try (
                    ResultSet rsSales = pstmt.executeQuery();
            )
            {
                while (rsSales.next()) {
                    int onum = rsSales.getInt("onum");
                    int amt = rsSales.getInt("amt");
                    System.out.printf("|%5d|%5d|\n", onum, amt);
                }
            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}

