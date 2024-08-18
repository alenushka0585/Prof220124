package org.example.lesson26;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
SQL - Structured Query Language
DML -
Select
Delete
Update
Insert

Create

JDBC - Java Database Connectivity
Driver конкретной базы данных
jdbc url -
jdbc:mysql://localhost:3306/sonoo
jdbc:oracle:thin:@localhost:1521:xe
http://www.sqlite.org/   - встроенная база данных

SQL: MySQL, Postgres, SQLite, MsSQL, Oracle, DB2
No-SQL

 */
public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // sqlite драйвер, локальный файл shop.db в корне
        //загрузить драйвер (поддержку jdbc
        //создать соеденение с базой данной по url

        try (Connection connection = DriverManager.getConnection(url))
        {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Driver is: " + metaData.getDriverName());
            System.out.println("Version is: " + metaData.getDriverVersion());
            System.out.println("Database was created!");

        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
    }
}
