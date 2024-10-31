package pattern3_behavior.behavior9_observer.code.example3_alarm;

class Display implements Observer {
    private String name;

    public Display(String name){
        this.name = name;
    }

    @Override
    public void update(float temperature){
        System.out.println("Дисплей " + name + " отображает температуру: " + temperature + "°C");
    }
}
