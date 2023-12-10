package com.java.design.pattern.singleton;

//静态内部类
//由jvm只初始一个
public class Singleton1 {
    private Singleton1(){}
    private static class SingletonHolder{
        private static final Singleton1 INSTANCE=new Singleton1();
    }
    public static Singleton1 getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}
