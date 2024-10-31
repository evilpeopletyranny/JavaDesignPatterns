package pattern3_behavior.behavior9_observer.code.example3_alarm;

class Alarm implements Observer {
    @Override
    public void update(float temperature){
        if(temperature > 30.0f){
            System.out.println("Сигнал тревоги! Высокая температура: " + temperature + "°C");
        }
    }
}
