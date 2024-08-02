package org.example.lesson22;

/*
CPU - процессор
Процесс - выполняющаяся программа
Метод - функция программы
Ядро (Core) - вычислительный модуль процессора, который и занимается выполнением команд процессора
Метод, выполняющийся на ядре, или ожидающий выполнения, называется поток (Thread)
 */
/*
Чем характерезуется поток Thread?
Есть идентификатор
Это объект, поэтому есть адресное пространство
Есть состояние - New, Runnable, Running, Waiting, Dead
Поток выполняется только 1 раз
Стэк - набор локальных для потока переменных
Каждый созданный поток занимает ~2Мб оперативной памяти
 */

public class ThreadIntro {
    public static void main(String[] args) {
        // у каждого потока есть идентификатор
        System.out.println("Main thread id is: " +
                Thread.currentThread().getId()
        );

        // сколько ядер
        // Runtime - информация о текущей машине
        // возможность запустить команды операционной системы

        System.out.println("Number od cores: " + Runtime.getRuntime().availableProcessors());

        //Создадим пустой поток
        Thread t1 = new Thread();
        t1.start(); //запуск потока на исполнение

        Thread t2 = new Thread() {
            @Override
            public void run() {
                // тело потока
                System.out.println("t2 id is: " +
                        Thread.currentThread().getId()
                );
            }
        };

        t2.start();
        // повторный зауск уже запущенного потока вызывает исключение
//        t2.start();

        //Runnable - работа, которая должна быть выполнена в порожденном потоке
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread from Runnable, id: " +
                        Thread.currentThread().getId());
            }
        };

        //Runnable можно переиспользовать
        new Thread(r1).start();
        new Thread(r1).start();

        //основной поток (main) по-умолчанию ожидает завершения всех порожденных потоков

        new Thread(){
            @Override
            public void run() {
                System.out.println("Slow Thread, id "
                + Thread.currentThread().getId());
                //Thread.sleep переводит поток в состояние ожидания на указанное количество милисекунд
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Slow Thread, id "
                        + Thread.currentThread().getId());
            }
        }.start();

        //поток можно "демонизировать" - сделать так,
        // чтобы основной поток больше не ждал его завершения

        Thread daemonThread = new Thread(){
            @Override
            public void run() {
                System.out.println("Daemon thread start, id: "
                + Thread.currentThread().getId());

                if(Thread.currentThread().isDaemon()){
                    System.out.println("I'm  daemon!");
                }else {
                    System.out.println(":(");
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Daemon thread ended, id: " +
                        Thread.currentThread().getId());
            }
        };

        //в начале поток должен быть настроен на демонизацию
        // и тольеко потом запущен

        daemonThread.setDaemon(true);
        daemonThread.setPriority(Thread.MAX_PRIORITY); // 1-10
        daemonThread.start();

        System.out.println("End of main");

        new Thread(() -> hello()).start();
        new Thread(ThreadIntro::hello).start();



    }//окончание main

    public static void hello(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}
