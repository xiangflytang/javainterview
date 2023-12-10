package com.java.interview.yahuilong;

abstract class base{
    abstract  void test();
}
interface basei{
    void tryit();
}
public class yahuilong extends base {
    void test(){
        System.out.println("hello world");
    };
    public static void main(String[] args) {

        test_while();
        test_chinese();
       yahuilong yahuilong = new yahuilong();
        yahuilong.test();
    }

    static void test_while() {
        int a = 0;
        int c = 0;
        do {
            --c;
            a = a - 1;

        } while (a > 0);
        System.out.println(c);
    }
    static void test_chinese(){
        char chineseChar = '中';
        System.out.println(5+5+"5+5");
        System.out.println(chineseChar);
    }
}