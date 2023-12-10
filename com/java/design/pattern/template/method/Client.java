package com.java.design.pattern.template.method;

 abstract class CaffeineBeverage {
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();

    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater(){
        System.out.println("boilWater");
    }
    void pourInCup() {
        System.out.println("pourInCup");
    }

}
class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("brew tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Tea add lemon");
    }
}
public class Client {
    public static void main(String[] args) {
        CaffeineBeverage tea= new Tea();
        tea.prepareRecipe();
    }
}