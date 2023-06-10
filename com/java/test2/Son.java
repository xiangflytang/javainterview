package com.java.test2;

public class Son extends Father {
    public static String name = "Son name";

    public static void main(String[] args) {
        Father instance = new Son();
        System.out.println(instance.name);
        int aaa;
        System.out.println(name);
    }
}

class Father {
    public String name = "father name" ;
}
