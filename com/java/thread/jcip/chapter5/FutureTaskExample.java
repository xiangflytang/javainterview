package com.java.thread.jcip.chapter5;

import java.util.concurrent.RunnableFuture;

import java.util.concurrent.*;

public class FutureTaskExample {

    public static void main(String[] args) {
        test_future_interface();
        //test_future_task();
    }

    static void test_future_interface() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 提交一个任务
        Future<Integer> future = executorService.submit(new Task());
        System.out.println("Task submitted. Waiting for result...");

        try {
            // 阻塞等待任务完成并获取结果
            Integer result = future.get();
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
    static void test_future_task() {
        Callable <Integer> callable = new Task();
        FutureTask<Integer>futureTask= new FutureTask<>(callable);
        // 提交任务
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        System.out.println("Task submitted. Waiting for result...");
        try {
            // 阻塞等待任务完成并获取结果
            Integer result = futureTask.get();
            System.out.println("Task result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }


    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            // 模拟一个耗时任务
            Thread.sleep(2000);
            return 42;
        }
    }
}
