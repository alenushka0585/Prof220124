package org.example.lesson22;

public class SynchronizationTest {

    //"разделяемый" ресурс
    private static int data[]={0};

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Calculation();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();// ожиданием в данном случае в main потоке окончаниея t1
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        //все потоки завершились

        System.out.println("data: " + data[0]);
    }

    //synchronized одновременно в этом куске кода может работать только 1 поток
    //synchronized без указания монитора будет синхронизовать потоки на классе
    //SynchronizationTest.class
    public /*synchronized*/ static void add(){
//        data[0]++;
        synchronized (monitor){
            data[0]++;
        }
    }

    //как работает синхронизация
    //поток выполняет на объекте синхронизации wait
    //если на объекте синхронизации никто больше не ждет, то wait завершается мгновенно
    //и поток выполняет синхронизированный блок
    //после того как поток выходит из синхронизированного блока
    //поток выполняет метод notify этого объекта синхронизации
    //и это пробуждает потоки которые ждут в wait на этом объекте

    //в качестве синхронизации может использоваться любой объект
    private static Object monitor = new Object();

    static class Calculation implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                add();
            }
        }
    }
}
