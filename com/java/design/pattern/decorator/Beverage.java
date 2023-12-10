package com.java.design.pattern.decorator;

public abstract class Beverage {
    String description = "unknown beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
