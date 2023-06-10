package com.java.lambda;

import com.java.test2.Apple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) throws Exception {
//        String oneLine = processFile((BufferedReader br) -> br.readLine());
//        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
        Object oo = new Object();
        testPredicate();
        testConsumer();
        testFunction();
        testComparator();
        testRunnable();
    }
    public static void  testComparator(){
        List<Apple> inventory = Arrays.asList(new Apple(180,"red"),new Apple(155, "green"));
        inventory.sort(new AppleComparator());
    }
    public static void  testComparatorLambda(){
        List<Apple> inventory = Arrays.asList(new Apple(180,"red"),new Apple(155, "green"));
        inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
    }

    public static void methodRefer(){
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
    public static void testPredicate(){
        List<String>strings =
                Arrays.asList("abc","","efg");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(strings, nonEmptyStringPredicate);
        System.out.println(nonEmpty);
    }
    public static void testConsumer(){
        forEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));
    }

    public static void testFunction(){
        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);

        List<Integer> l = map(
                Arrays.asList("lambdas","in","action"),
                (String s) -> s.length()
        );
        System.out.println(l);
    }
    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i: list){
            c.accept(i);
        }
    }
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
    public static void testRunnable(){
        //https://blog.csdn.net/qq_33291299/article/details/128551490
        Runnable r = ()-> System.out.println("Hello world");
        Thread th = new Thread(r);
        th.start();
    }
}
