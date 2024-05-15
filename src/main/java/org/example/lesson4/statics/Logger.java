package org.example.lesson4.statics;

//Singleton = когда хотим создать только один экземпляр класса
// нужен приватный конструктор и статик метод на instance
public class Logger {
    private Logger() {
    }
    private static Logger instance;
    public static Logger getInstance(){
        if (instance==null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String s){
        System.out.println("logger: " + s);
    }
}
