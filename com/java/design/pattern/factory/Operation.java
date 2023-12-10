package com.java.design.pattern.factory;

public abstract class Operation {
    private double a;
    private double b;
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }

    public abstract double getResult();

}



 class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getA() + getB();
    }
}

 class OperationDiv extends Operation {
    @Override
    public double getResult() {

        return getA() / getB();
    }
}

 class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getA() * getB();
    }
}


 class OperationSub extends Operation {
    @Override
    public double getResult() {
        return getA() - getB();
    }
}
