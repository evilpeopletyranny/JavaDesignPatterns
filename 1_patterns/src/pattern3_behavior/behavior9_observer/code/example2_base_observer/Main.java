package pattern3_behavior.behavior9_observer.code.example2_base_observer;

// Демонстрация работы паттерна Observer
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        // Создаем наблюдателей
        Observer observer1 = new ConcreteObserver("Наблюдатель 1");
        Observer observer2 = new ConcreteObserver("Наблюдатель 2");

        // Подписываем наблюдателей на объект
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Меняем состояние объекта, что приводит к уведомлению наблюдателей
        subject.setState("Изменение состояния!");
    }
}
