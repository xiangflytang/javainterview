package com.java.design.pattern.factory;

public class Client {
    public static void main(String[] args) {
        Factory addFactory = new AddOperationFactory();
        Operation operation = addFactory.createOperation();
        operation.setA(1);
        operation.setB(2);
        System.out.println(operation.getResult());
        Factory subFactory = new SubOperationFactory();
        Operation operation2 = subFactory.createOperation();
        operation2.setA(10);
        operation2.setB(2);
        System.out.println(operation2.getResult());
    }
}

