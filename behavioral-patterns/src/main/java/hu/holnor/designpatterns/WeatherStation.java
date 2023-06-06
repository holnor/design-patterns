package hu.holnor.designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Observable {
    private float temperature;
    private float humidity;
    private List<Observer> displays = new ArrayList<Observer>();

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void startMeasure() {
        Random random = new Random();
        int delay = random.nextInt(10000);
        while (true) {
            try {
                Thread.sleep(delay);
                measureTemperature();
                delay = random.nextInt(10000);
                Thread.sleep(delay);
                measureHumidity();
                delay = random.nextInt(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void measureTemperature() {
        Random random = new Random();
        this.temperature += random.nextFloat() * 2 - 1;
        notifyObservers();
    }

    private void measureHumidity() {
        Random random = new Random();
        this.humidity += random.nextFloat() * 2 - 1;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        displays.add(observer);
    }
    public void unregisterObserver(Observer observer) {
        displays.remove(observer);
    }

    public void notifyObservers() {
        for (Observer display : displays) {
            display.update();
        }
    }
}
