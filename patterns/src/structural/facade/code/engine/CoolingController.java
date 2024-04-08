package structural.facade.code.engine;

public class CoolingController {
    private Radiator radiator = new Radiator();
    private TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(Integer temp) {
        System.out.println("Cooling Controller set temperature upper limit " + temp);
        temperatureSensor.getTemperature();
    }

    public void run() {
        System.out.println("Cooling Controller run.");
        radiator.on();
    }

    public void cool(Integer cool) {
        System.out.println("Cooling Controller cool" + cool);
    }

    public void stop() {
        System.out.println("Cooling Controller stop.");
    }
}
