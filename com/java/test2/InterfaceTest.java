package com.java.test2;

public interface InterfaceTest {
    default String work() {
        return "default";
    }

    ;

    default String salary() {
        return "salary";
    }

    ;
}
