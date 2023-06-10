package com.java.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String...args){
        List<Apple> inventory = Arrays.asList(new Apple(180,"red"),new Apple(155, "green"));
        List<Apple> heavyApples =filterApples(inventory,new AppleHeavyWeightPredicate());
        System.out.println(heavyApples);
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple a){
                return "red".equals(a.getColor());
            }
        });
        System.out.println(redApples);

        List<Apple> result =
                filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(result);
        inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);
        Runnable run1 = ()-> System.out.println("Hello World 1");
        run1.run();
    }

    static List<Apple> filterApples(List<Apple> inventory,
                                    ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
