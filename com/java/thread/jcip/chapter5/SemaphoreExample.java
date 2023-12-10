package com.java.thread.jcip.chapter5;

import com.java.thread.jcip.chapter6.ExecutorExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute( new Worker(i,semaphore));
        }
        executorService.shutdown();
    }
}
class Worker implements Runnable{
    private final int id;
    private final Semaphore semaphore;

    public Worker(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try{
            System.out.println("worker id "+id +" try to acquire");
            semaphore.acquire();// get permit
            System.out.println("worker "+id +" acquired a permit");
            // mock work
            Thread.sleep(2000);
            System.out.println("worker id "+id +" releasing");
            semaphore.release();// get permit
            System.out.println("worker id "+id +" released");

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}