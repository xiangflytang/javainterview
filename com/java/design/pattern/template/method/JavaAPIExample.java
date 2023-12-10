package com.java.design.pattern.template.method;

import java.io.*;
import java.util.Arrays;

public class JavaAPIExample {
    public static void main(String[] args) {
        //test_arrays_sort();
        //test_input_stream();
        test_input_stream2();
    }

    //所有要sort的都要实现
    static void test_arrays_sort() {
        int[] arr = new int[3];
        arr[0] = 5;
        arr[1] = 4;
        arr[2] = 6;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void test_input_stream() {
        try (InputStream inputStream = new FileInputStream("D:\\project\\jianzhioffer\\src\\com\\java\\design\\pattern\\template\\method\\example.txt")) {
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                System.out.println((char) byteRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
    static void test_input_stream2(){
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            String s = readAsString(input);
            System.out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }

}
