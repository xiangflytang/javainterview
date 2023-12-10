package com.java.design.pattern.strategy;

import java.util.Comparator;

interface QuackBehavior{
    void quack();
}
class Quack implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("quack");
    }
}
class Squeak implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("squeak!");
    }
}
class Duck {
    private QuackBehavior quackBehavior;
    public void performQuack(){
        if(quackBehavior!=null){
            quackBehavior.quack();
        }
    }
    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior=quackBehavior;
    }
}
public class StrategyExample {
    public static void main(String[] args) {
        test_duck_quack();
    }
     static void test_duck_quack(){
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
    static void test_comparator(){
//        Comparator.compare();
//        java.util.Comparator compare();
    }
}
