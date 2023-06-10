package com.java.basic;

public class FinallyTest
{
    public static void main(String[] args) {

        System.out.println(new FinallyTest().test());;
    }

    static int test()
    {
        int x = 1;
        try
        {
            x++;
            return x;
        }
        finally
        {   int y=3;
            return y;
        }
    }
}