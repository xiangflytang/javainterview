package com.java.lambda;

public class Apple {
    Integer weight;
    String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    Integer getWeight(){
        return weight;
    }
    String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}