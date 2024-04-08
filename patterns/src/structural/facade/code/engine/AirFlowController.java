package structural.facade.code.engine;

public class AirFlowController {
    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        System.out.println("AirFlowController take air.");
        airFlowMeter.getMeasurement();
    }

    public void off() {
        System.out.println("AirFlowController off.");
    }
}
