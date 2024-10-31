package pattern3_behavior.behavior9_observer.code.example3_alarm;

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
