package com.java.design.pattern.observer.weatherstation;

public class CurrentConditionDisplay implements Observer,DisplayElement{
    private float temp;
    private float humid;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current temp:"+temp + "humid" + humid);
    }

    @Override
    public void update(float temp, float humid, float pressure) {
        this.temp=temp;
        this.humid=humid;
        display();
    }
}
