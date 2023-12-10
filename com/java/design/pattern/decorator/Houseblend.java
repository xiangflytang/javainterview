package com.java.design.pattern.decorator;

public class Houseblend extends Beverage {
    public Houseblend() {
        description= "house blend";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
