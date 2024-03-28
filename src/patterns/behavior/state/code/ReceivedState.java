package patterns.behavior.state.code;

/**
 * Посылка получена.
 * Конкретное состояние.
 */
public class ReceivedState implements PackageState {

    /**
     * Нет последубщего состояния.
     *
     * @param pkg посылка, которая будет переведа в следующее состояние.
     */
    @Override
    public void next(Package pkg) {
        System.out.println("This package is already received by a client.");
    }

    /**
     * Предыдущее состояние - досталвена.
     *
     * @param pkg посылка, которая будет переведа в предыдущее состояние.
     */
    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("Package received.");
    }
}
