package com.java.thread.interview;

import java.util.LinkedList;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String input = "This    is   a     test   string   with    multiple    spaces.";

        // Replace multiple spaces with a single space
      /*  String result = input.replaceAll("\\s+", " ");

        System.out.println("Original string: " + input);
        System.out.println("String with multiple spaces replaced: " + result);

        String input2 = "  ";
        String result2 = input2.replaceAll("\\s+", " ");

        System.out.println("Original string: " + "b" + input2 + "a");
        System.out.println("String with multiple spaces replaced: " + "b" + result2 + "a");
        String input3 = "This    is   a     test   string   with    multiple    spaces.";
        System.out.println(removeSpaces(input3));

        String input4 = "  ";
        System.out.println("Original string: " + "b" + input4 + "a");
        System.out.println("String with multiple spaces replaced: " + "b" + removeSpaces(input4) + "a");

        System.out.println("Original string: " + "b" + input + "a");
        */
        System.out.println("Original string: " + input);
        System.out.println(removeSpacesWithPrevious(input));
    }

    public static String removeSpaces(String str) {
        StringBuilder sbuilder = new StringBuilder();
        char[] arr = str.toCharArray();
        int length = arr.length;
        // 是否为连续的第一个空格。
        boolean isFirst = true;
        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ') {
                if (isFirst) {
                    sbuilder.append(arr[i]);
                    isFirst = false;
                }
            } else {
                //不是空格
                sbuilder.append(arr[i]);
                isFirst = true;
            }

        }
        return sbuilder.toString();
    }
    // for 循环整个string
    // 1.用一个变量记录上一个char,
    // 2.当前如果为空格，就看上一个是否为空格，如果上一个char不是空格，就放到stringbuilder中，
    // 3.当前如果不为空格，直接放到stringbuilder
    public static String removeSpacesWithPrevious(String str) {
        StringBuilder sbuilder = new StringBuilder();
        char previous = 0; // initialLize to 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (previous != ' ') {
                    sbuilder.append(str.charAt(i));
                    previous = str.charAt(i);
                }
            } else {
                sbuilder.append(str.charAt(i));
                previous = str.charAt(i);
            }
        }
        return sbuilder.toString();
    }

}
