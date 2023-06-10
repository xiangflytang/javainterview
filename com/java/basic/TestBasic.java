package com.java.basic;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestBasic {
    public static void main(String[] args) {
testClass();
    }
    public static void testClass(){
        List<String> list= new LinkedList();
        Class<?>tbClazz=list.getClass();
//        tbClazz.getMethod();
        System.out.println(tbClazz.toString());
        Thread ss= new Thread();
        Runnable rr = new Runnable() {
            @Override
            public void run() {

            }
        };


    }
    public static void test_thread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute();
    }
}
