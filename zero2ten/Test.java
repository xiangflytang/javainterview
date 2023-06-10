package zero2ten;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int count=0;
        for (int i =0;i< 100;i++){
            //count= count++;
            count++;
        }
        System.out.println(count);
    }
//    public void test (){
//        Set<String> ss= new HashSet();
//        List<String> ll = new ArrayList<>();
//        Runnable thread = new Runnable();
//        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
//    }
//    public static List<Apple> filterGreenApples(List<Apple> inventory){
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple: inventory){
//            if ("green".equals(apple.getColor())) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }

}
