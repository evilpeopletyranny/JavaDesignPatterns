package pattern3_behavior.behavior9_observer.code.example3_alarm;

public class Main {
    public static void main(String[] args) {
        // Создаем наблюдаемый объект
        TemperatureSensor sensor = new TemperatureSensor();

        // Создаем наблюдателей
        Display display1 = new Display("1");
        Display display2 = new Display("2");
        Alarm alarm = new Alarm();

        // Подписываем наблюдателей на объект
        sensor.addObserver(display1);
        sensor.addObserver(display2);
        sensor.addObserver(alarm);

        // Изменяем состояние объекта
        sensor.setTemperature(25.0f);
        sensor.setTemperature(28.5f);
        sensor.setTemperature(32.0f);
    }
}
