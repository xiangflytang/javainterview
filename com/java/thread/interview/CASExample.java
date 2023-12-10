package com.java.thread.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // Increment counter using CAS
        for (int i = 0; i < 10; i++) {
            new Thread (()->{
               int currentValue;
               int newValue;
               do{
                   currentValue= counter.get();
                   newValue= currentValue+1;
               }while(!counter.compareAndSet(currentValue,newValue));
                System.out.println("current Value is "+ counter.get());
            }).start();
        }
    }
}
