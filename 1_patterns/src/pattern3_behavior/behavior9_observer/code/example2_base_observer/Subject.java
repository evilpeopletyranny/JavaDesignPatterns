package pattern3_behavior.behavior9_observer.code.example2_base_observer;

import java.util.ArrayList;
import java.util.List;

// Класс Subject (наблюдаемый)
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Добавляем нового наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Удаляем наблюдателя
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Уведомляем всех наблюдателей о изменении состояния
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    // Метод изменения состояния
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
