package com.java.design.pattern.observer.buildin;

import java.util.Observable;

public class WeatherData extends Observable {
    private float temp;
    private float humid;
    private float pressure;

    public WeatherData() {
    }

    public void measurementChanged(){
        setChanged();
        notifyObservers();
    }
    public void setMeasurements(float temp,float humid,float pressure){
        this.temp=temp;
        this.humid=humid;
        this.pressure=pressure;
        measurementChanged();
    }

    public float getTemp() {
        return temp;
    }

    public float getHumid() {
        return humid;
    }

    public float getPressure() {
        return pressure;
    }
}
