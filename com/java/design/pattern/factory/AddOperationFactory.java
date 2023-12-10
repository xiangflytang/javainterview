package com.java.design.pattern.factory;

public class AddOperationFactory implements Factory {
    @Override
    public  Operation createOperation() {
        return new OperationAdd();
    }
;
}
