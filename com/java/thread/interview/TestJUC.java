package com.java.thread.interview;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class TestJUC {
    private AtomicInteger a = new AtomicInteger();
    @Test
    public void  testThreadLocal() throws Exception {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        System.out.println("线程：test");
        Thread thread1 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(1);
            System.out.println("线程：" + Thread.currentThread().getName() + ",local:" + threadLocal1.get());
            System.out.println("线程：" + Thread.currentThread().getName() + ",local:" + threadLocal2.get());
            System.out.println("Total cpu number"+Runtime.getRuntime().availableProcessors());;
            threadLocal1.remove();
            threadLocal2.remove();
        });
        Thread thread2 = new Thread(() -> {
            threadLocal1.set(2);
            threadLocal2.set(2);
        });
        thread1.start();
        thread2.start();
        Thread.currentThread().sleep(1000);
        threadLocal1.set(3);
        System.out.println("线程：" + Thread.currentThread().getName() + ",local:" + threadLocal1.get());

    }
}

