package com.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadInit {

    public static void main(String[] args)throws InterruptedException, ExecutionException {
        //runnable has no return
        //实现 Runnable 接口
        MyRunnable instance = new MyRunnable();
        Thread thread = new Thread(instance);
        thread.start();

        // callable接口
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println("callable can have return "+ft.get());
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // ...
        System.out.println("create thread");
    }
}

 class MyCallable implements Callable<Integer> {
    public Integer call() {
        return 123;
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("from inherite thread");
    }
}