package com.java.thread.interview;

public class DaemonExample {

    public static void main(String[] args) throws Exception{
        Runnable task = () -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread daemonThread = new Thread(task);
        daemonThread.setDaemon(true); // 将线程设置为Daemon线程
        daemonThread.start();
        Thread.currentThread().sleep(1000);
        System.out.println("Main thread is exiting...");
    }
}

