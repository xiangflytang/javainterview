package com.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class UseCallable implements Callable {
    private int sum;

    @Override
    public Object call() throws Exception {
        return null;
    }
}
class TestCallable{

    public static void main(String[] args) {
        UseCallable callable = new UseCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
    }
}

