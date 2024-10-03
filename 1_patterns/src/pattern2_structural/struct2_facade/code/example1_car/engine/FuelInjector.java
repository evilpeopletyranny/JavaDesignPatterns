package pattern2_structural.struct2_facade.code.example1_car.engine;

public class FuelInjector {
    private FuelPump fuelPump = new FuelPump();

    public void on() {
        System.out.println("Fuel Injector on.");
    }

    public void off() {
        System.out.println("Fuel Injector off.");
    }

    public void inject() {
        System.out.println("Fuel Injector inject");
        fuelPump.pump();
    }
}
