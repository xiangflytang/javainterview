package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadInterrupted {
    public static void main(String[] args) throws Exception {
//        Thread thread = new Thread();
//
//        try {
//
//            Thread.currentThread().sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // test interrupt
//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");

        // test interrupt 2
//        Thread thread2 = new MyThread2();
//        thread2.start();
//        System.out.println(Thread.currentThread().getName());
//        Thread.currentThread().sleep(5000);
//        thread2.interrupt();

        // test executor

        testExecutor();
    }
    public static void testExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                System.out.println("Thread run in executor");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }

}

class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Thread run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread start");

        while (!interrupted()) {
            System.out.println("hello world");
            System.out.println("22");
        }
        System.out.println("Thread end");

    }
}

