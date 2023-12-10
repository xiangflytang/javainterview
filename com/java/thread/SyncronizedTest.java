package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncronizedTest {
    public static void main(String[] args) {
        // synchronized instance
//        SynchronizedInstance e1 = new SynchronizedInstance();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> e1.func1());
//        executorService.execute(() -> e1.func1());
        // synchronized class
        SynchronizedClass e2 = new SynchronizedClass();
        SynchronizedClass e3 = new SynchronizedClass();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> e2.func1());
        executorService2.execute(() -> e3.func1());

        // lock with Reentrant lock
//        LockExample le = new LockExample();
//        ExecutorService executorService4 = Executors.newCachedThreadPool();
//        executorService4.execute(()->le.func());
//        executorService4.execute(()->le.func());
    }
}

class SynchronizedInstance {

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

class SynchronizedClass {

    public void func1() {
        synchronized (SynchronizedClass2.class) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + " ");
                if (i % 50 == 0) {
                    System.out.println("\n");
                }
            }
        }
    }
}

class SynchronizedClass2 {

    public void func1() {
        synchronized (SynchronizedClass2.class) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

class LockExample {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }
}