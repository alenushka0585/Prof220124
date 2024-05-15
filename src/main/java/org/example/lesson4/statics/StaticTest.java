package org.example.lesson4.statics;

public class StaticTest {
    public static void main(String[] args) {
       Logger logger =  Logger.getInstance();
       logger.log("Hallo");

        System.out.println(Constants.DB_URL);
    }

}
