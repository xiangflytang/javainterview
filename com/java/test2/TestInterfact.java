package com.java.test2;

public class TestInterfact implements InterfaceTest {
    @Override
    public String salary() {
        return "salary AAA";
    }

    public static void main(String[] args) {
        TestInterfact test = new TestInterfact();
        System.out.println(test.salary());

    }
}
