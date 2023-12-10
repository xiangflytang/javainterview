package com.java.design.pattern.observer.weatherstation;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList <Observer>observers;
    private float temp;
    private float humid;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index=observers.indexOf(o);
        if(index >0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer: observers){
            observer.update(temp,humid,pressure);
        }
    }
    public void measurementChanged(){
        notifyObserver();
    }
    public void setMeasurements(float temp,float humid,float pressure){
        this.temp=temp;
        this.humid=humid;
        this.pressure=pressure;
        measurementChanged();
    }
}
