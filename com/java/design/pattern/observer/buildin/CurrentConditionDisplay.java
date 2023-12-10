package com.java.design.pattern.observer.buildin;


import com.java.design.pattern.observer.weatherstation.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temp;
    private float humid;
    private Observable weatherData;

    public CurrentConditionDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current temp:" + temp + "humid" + humid);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humid = weatherData.getHumid();
            display();
        }
    }
}
