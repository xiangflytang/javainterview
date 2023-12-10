package com.java.design.pattern.decorator;

public class StarBuzz {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage =new Mocha(beverage);
        beverage =new Soy(beverage);

        System.out.println(beverage.getDescription());
        System.out.println(beverage.cost());
    }
}
