package org.example.lesson22;

public class Practice {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println(function1()));
        t1.start();

        Thread t2 = new MyThread(function1());
        t2.start();

        Thread t3 = new Thread(){
            @Override
            public void run() {
                MyThread myThread = new MyThread(function1());
                myThread.start();
            }
        };
        t3.start();

    }

    static class MyThread extends Thread{
        private String text;

        public MyThread(String text) {
            this.text = text;
        }

        @Override
        public void run() {
            System.out.println(function2(text));
        }
    }

    public static String function2 (String text){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return text +"|" + Thread.currentThread().getId() + ":" +
                System.currentTimeMillis();
    }
    public static String function1(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "" + Thread.currentThread().getId() + ":" +
                System.currentTimeMillis();
    }
}
