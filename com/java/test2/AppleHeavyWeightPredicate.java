package com.java.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleHeavyWeightPredicate implements ApplePredicate{
        public boolean test(Apple apple){
            return apple.getWeight() > 150;
        }
}
class Apple {
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

