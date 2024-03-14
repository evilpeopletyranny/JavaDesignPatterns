package patterns.structural.facade.code;

import patterns.structural.facade.code.engine.*;

/**
 * Эмитируем работу двигателя.
 * Все части двигателя находятся в пакете engine и не интересуют нас.
 */
public class Main {
    public static void main(String[] args) {
        int DEFAULT_COOLING_TEMP = 90;
        int MAX_ALLOWED_TEMP = 50;
        FuelInjector fuelInjector = new FuelInjector();
        AirFlowController airFlowController = new AirFlowController();
        Starter starter = new Starter();
        CoolingController coolingController = new CoolingController();
        CatalyticConverter catalyticConverter = new CatalyticConverter();

        //Правильная последовательность действий для включения двигателя.
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();

        //Правильная последовательность действий для выключения двигателя.
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();

        System.out.println("-------------------------");

        //Пользователю не интересно как работает двигатель и какова правильная последовательность действий.
        //Пользователь хочет кнопку вкл/выкл, с которой легко работать и она не требует глубинных знаний.
        //Здесь как раз таки и поможет паттерн фасад.
        CarEngineFacade carEngineFacade = new CarEngineFacade();

        //нажали вкл
        carEngineFacade.startEngine();

        //нажали выкл
        carEngineFacade.stopEngine();

        //Пользователю не приходиться знать внутренностей и последовательность действий.
        //К тому же если добавяться новые элементы или поменяется последовательность,
        //то у пользователя также остануться лишь кнопки вкл/выкл
    }
}
