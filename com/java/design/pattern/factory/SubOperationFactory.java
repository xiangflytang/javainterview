package com.java.design.pattern.factory;

public class SubOperationFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
