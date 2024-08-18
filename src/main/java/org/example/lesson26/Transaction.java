package org.example.lesson26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Transaction {
    //Transaction
    // способ группировки изменяющих данные операции
    // чтобы они либо состоялись все, либо не состоялась не одна
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement stmt = connection.createStatement()

        ) {
            {
                //autocommit=true - каждый запрос выполняется в рамках отдельной транзакции
                //autocommit=false - все запросы выполняются в рамках одной и той-же транзакции

                connection.setAutoCommit(false); // включает транзакционный режим для SQLite

                // start transaction;
                // запросы
                // commit; // все запросы в транзакции выполняются и транзакция успешно завершается


                // start transaction;
                // запросы
                // rollback; // все запросы в транзакции откатываются на стадию до start transaction;

                stmt.execute("insert into customers (cnum, cname, rating, snum, city) " +
                        " values (4002, 'Below', 100, 1001, 'Viena') ");
                //System.out.println(4/0);
                stmt.execute("insert into orders (onum, amt, odate, cnum, snum) values " +
                        " (7002, 250000, '2024-08-12', 4002, 1001)  "
                );
                connection.commit();


            }

        } catch (
                Exception e) {
            System.out.println("exception: " + e.getMessage());

        }
    }
}
