package pattern3_behavior.behavior9_observer.code.example3_alarm;

import java.util.ArrayList;
import java.util.List;

class TemperatureSensor implements Subject {
    private float temperature;
    private List<Observer> observers;

    public TemperatureSensor(){
        observers = new ArrayList<>();
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature(){
        return temperature;
    }

    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature);
        }
    }
}
