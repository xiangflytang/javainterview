package com.java.thread.jcip.chapter6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main2(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 提交任务
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task(i));
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running in thread: " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // 创建固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
            executorService.execute(new Task(i));
        }
        //关闭线程池
        executorService.shutdown();
    }
}


