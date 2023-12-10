package com.java.exception.handling;

public class TestException {

    public static void main(String[] args) {

        System.out.println(new TestException().test());
        ;
        System.out.println(new TestException().test2());
        ;

        try {
            proc1();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
        proc2();
        proc3();
    }

    static int test() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
        }
    }

    static int test2() {
        int x = 1;
        try {
            x++;
            return x;
        } finally {
            ++x;
            //return x;
        }
    }


    static void proc1() {
        try {
            System.out.println("inside proc1");
            throw new RuntimeException("demo");
        } catch (Exception e){
            System.out.println(e);
        }
    }

    static void proc2() {
        try {
            System.out.println("inside proc2");
            return;
        } finally {
            System.out.println("proc2's finally");
        }
    }

    static void proc3() {
        try {
            System.out.println("inside proc3");
        } finally {
            System.out.println("proc3's finally");
        }
    }


}
